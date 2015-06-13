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
		
		InputStream input = socket.getInputStream();
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		BufferedReader read = new BufferedReader(new InputStreamReader(input));
		String request = read.readLine();
		
		System.out.println();
		System.out.println(request);
		
		//Pegar o nome do arquivo
		StringTokenizer tokens = new StringTokenizer(request);
		tokens.nextToken();  
		String arquivo = tokens.nextToken();
		arquivo = "." + arquivo;
		
		//Tratando caso nao haja arquivo nomeado
		FileInputStream fis = null;
		boolean arquivoExiste = true;
		try {
			fis = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			arquivoExiste = false;
		}
		
		// Mensagem de resposta
		String statusLine = null;
		String contentTypeLine = null;
		String entityBody = null;
		
		if (arquivoExiste) {
			statusLine = "HTTP-Version 1.0 Status-Code 200 SUCCESS";
			contentTypeLine = "Content-type: " +   contentType(arquivo) + CRLF;

		}else {
			statusLine = "HTTP-Version 1.0 Status-Code 404 NOT FOUND";
			contentTypeLine = "text/html";
			entityBody = "<HTML>" + 
				"<HEAD><TITLE>Not Found</TITLE></HEAD>" +
				"<BODY>Not Found</BODY></HTML>";
		}
		
		//Criando o header
		out.writeBytes(statusLine);
		out.writeBytes(contentTypeLine);
		out.writeBytes(CRLF);

		if(arquivoExiste){
			sendBytes(fis, out);
			fis.close();
		}else {
			out.writeBytes(entityBody);
		}
		
		
		out.close();
		read.close();
		socket.close();



		
	}

	private static void sendBytes(FileInputStream fis, OutputStream os)  throws Exception {
			   // Construct a 1K buffer to hold bytes on their way to the socket.
			   byte[] buffer = new byte[1024];
			   int bytes = 0;

			   // Copy requested file into the socket's output stream.
			   while((bytes = fis.read(buffer)) != -1 ) {
			      os.write(buffer, 0, bytes);
			   }
			}

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
