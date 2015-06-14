package llf.server;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public final class HttpRequest implements Runnable {
	
	//Determinante do fim do pacote e corta a leitura
	final static String CRLF = "\r\n";
	//Socket criado da conxao com o cliente
	Socket socket;
	
	//Construtor com o socket criado
	public HttpRequest(Socket socket) throws Exception {
		this.socket = socket;
	}

	//Execucao do thread
	public void run() {
		try {
			processRequest();
		} catch (Exception e) {
			System.out.println(e);
		}


	}
	
	
	private void processRequest() throws Exception {
		
		//Pegando os dados do request
		InputStream input = socket.getInputStream();
		
		//Criando o canal de gravacao de dados
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		//Leitor dos dados do header
		BufferedReader read = new BufferedReader(new InputStreamReader(input));
		String request = read.readLine();
		
		System.out.println();
		//MOstrando no log qual é o request feito
		System.out.println(request);
		
		//Pegar o nome do arquivo pulando os metodos, assumindo todos como GET
		StringTokenizer tokens = new StringTokenizer(request);
		tokens.nextToken();  //Pulando metodo
		String arquivo = tokens.nextToken();
		arquivo = "." + arquivo; // Atribuindo a extensao do arquivo
		
		//Tratando caso nao haja arquivo nomeado
		FileInputStream fis = null;
		boolean arquivoExiste = true;
		try {
			fis = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			//Valida a falta e retorna o arquvio 404
			arquivoExiste = false;
			fis = new FileInputStream("404.html");
		}
		
		// Mensagem de resposta, header e body 
		String statusLine = null;
		String contentTypeLine = null;
		
		//Elaborando o header para a existencia ou nao do arquivo
		if (arquivoExiste) {
			//Passando a mensagem que foi encontrado
			statusLine = "HTTP/1.0 200 OK\r\n";
			//Definindo o tipo de arquivo devolvido
			contentTypeLine = "Content-type: " +   contentType(arquivo) + CRLF;

		}else {
			//Nao existindo o arquivo ele vai informar 404 e alterar o tipo 
			statusLine = "HTTP/1.1 404 Not Found\r\n";
			contentTypeLine = "Content-type: text/html";
		}
		//Resgstra no log qual resposta
		System.out.println(statusLine);
		
		//Criando o pacote
		out.writeBytes(statusLine);
		out.writeBytes(contentTypeLine);
		//Linha de quebra
		out.writeBytes(CRLF);

		//Adiciona arquivo ao body do pacote
		sendBytes(fis, out);
		fis.close();
		
		
		//Termina todas as serializacoes
		out.close();
		read.close();
		socket.close();



		
	}
	
	//Metodo que escreve no buffer do pacote os dados
	private static void sendBytes(FileInputStream fis, OutputStream os)  throws Exception {
			   
			   byte[] buffer = new byte[1024];
			   int bytes = 0;

			   while((bytes = fis.read(buffer)) != -1 ) {
			      os.write(buffer, 0, bytes);
			   }
			}
	
	//Metodo que retorna o tipo de arquivo baseando no seu nome
	private static String contentType(String fileName){
		if(fileName.endsWith(".htm") || fileName.endsWith(".html")) {
			return "text/html";
		}
		if(fileName.endsWith(".txt")) {
			return "text/plain";
		}
		if(fileName.endsWith(".jpg")) {
			return "image/jpeg";
		}
		if(fileName.endsWith(".css")) {
			return "text/css";
		}
		return "application/octet-stream";
	}


}
