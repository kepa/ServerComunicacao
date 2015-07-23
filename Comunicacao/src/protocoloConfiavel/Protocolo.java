package protocoloConfiavel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Protocolo {
	
	private int portaDestino;
	private int portaOrigem;
	private InetAddress destinoIP;
	private InetAddress origemIP;
	private DatagramSocket socket;	
	//private ProtocolBuffer senderBuffer;
	//private ProtocolBuffer receiverBuffer;
	
	public Protocolo(String sourceHost, int sourcePort, int destinationPort) {
		
		
		this.portaOrigem = sourcePort;
		this.portaDestino = destinationPort;
		
		try {
			
			this.socket = new DatagramSocket(this.portaDestino);
			this.origemIP = InetAddress.getByName(sourceHost);
		
		} catch (IOException e) {
			
			
		}
		
		//ProcessingThread thread = new ProcessingThread(this.receiverBuffer, this.senderBuffer, this.socket, this.sourceIP, this.sourcePort, this);
		//thread.start();
		
	}
	
	public int sendData(byte[] buffer, int size) throws Exception{
		
		//Pacote n = new Pacote(this.destinoIP., this.origemIP, 2 ,2, buffer.length, buffer);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		
		out = new ObjectOutputStream(bos);   
		//out.writeObject(n);
		byte[] b = bos.toByteArray();
		
		//DatagramPacket envio = new DatagramPacket(b, b.length, n.getDestino(), this.socket.getPort());
		
		//this.socket.send(envio);
		
		return size;
		
	}
	
	// called by app
	// receive one segment at a time
	// returns number of bytes copied in buf
	public int receivedData(byte[] buffer, int size) {
		
		//*****  complete
		
		return 0;   // fix
		
	}
	
	// called by app
	public void close() {
		
		//close the connection
	
	}
	

}
