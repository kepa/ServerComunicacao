package protocoloConfiavel;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;



public class Pacote implements Serializable{
	
	private InetAddress destino;
	private InetAddress origem;
	
	private int numSequencia;
	private int numACK;
	
	private int checksum;
	private int larguraPacote;
	
	private byte[] dados;	
	
	private int timer;

	public Pacote(InetAddress destino,InetAddress origem,int numSequencia, int numACK, 
			int larguraPacote, byte[] dados) {
		
		this.destino = destino;
		this.origem = origem;
		this.numSequencia = numSequencia;
		this.numACK = numACK;
		this.larguraPacote = larguraPacote;
		
	}
	
	public Pacote(int numSequencia, int numACK, 
			int larguraPacote) {
		
		this.numSequencia = numSequencia;
		this.numACK = numACK;
		this.larguraPacote = larguraPacote;
		
	}
	
	
	public int getChecksum(){
		return this.checksum;
	}
	
	public int getAck(){
		return this.numACK;
	}

	public InetAddress getDestino() {
		return destino;
	}

	public void setDestino(InetAddress destino) {
		this.destino = destino;
	}

	public InetAddress getOrigem() {
		return origem;
	}

	public void setOrigem(InetAddress origem) {
		this.origem = origem;
	}
	
	

	
}
