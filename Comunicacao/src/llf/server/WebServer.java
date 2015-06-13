package llf.server;

import java.io.* ;
import java.net.* ;
import java.util.* ;

public final class WebServer {

	public static void main(String[] args) throws Exception {
		
		//Ajuste de porta de resquests
		int port = 4000;
		
		//Criando porta TCP de servidor
		ServerSocket listen = new ServerSocket(port);
		
		//Abre canal para escutar indefinidamente
		while(true){
			
			//Aceita o request	
			Socket newRead = listen.accept();
			
			System.out.println(newRead.getPort());
			
			//Cria um objeto HttpRequest para lidar com a nova conexao e sua subsequente resposta
			HttpRequest request = new HttpRequest(newRead);
			
			Thread t = new Thread(request);
			
			t.start();
			
		}

	}

}
