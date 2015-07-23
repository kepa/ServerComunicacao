package protocoloConfiavel;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.zip.CRC32;
import java.util.zip.Checksum;



public class Pacote implements Serializable{
	
	private InetAddress destino;
	private InetAddress origem;
	
	private int numSequencia;
	private int numACK;
	
	private long checksum;
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
		
		//setting checksum
		Checksum checksum = new CRC32();
		checksum.update(dados, 0, dados.length);
		this.checksum = checksum.getValue();
		
	}
	
	public Pacote(int numSequencia, int numACK, 
			int larguraPacote) {
		
		this.numSequencia = numSequencia;
		this.numACK = numACK;
		this.larguraPacote = larguraPacote;
		
	}
	
	
	public long getChecksum(){
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
