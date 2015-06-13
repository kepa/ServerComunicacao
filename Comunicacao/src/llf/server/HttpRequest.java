package llf.server;

import java.io.*;
import java.net.*;

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
		OutputStream out = socket.getOutputStream();
		
		BufferedReader read = new BufferedReader(new InputStreamReader(input));
		String request = read.readLine();
		
		System.out.println();
		System.out.println(request);
		
		String headerLine = null;
		while ((headerLine = read.readLine()).length() != 0) {
			System.out.println(headerLine);
			
		}
		
		out.close();
		read.close();
		socket.close();



		
	}


}
