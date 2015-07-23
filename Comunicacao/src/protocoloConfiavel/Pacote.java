package protocoloConfiavel;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.zip.CRC32;
import java.util.zip.Checksum;



public class Pacote implements Serializable{
	
	private int destino;
	private int origem;
	
	private int numSequencia;
	private int numACK;
	private int flags;
	private boolean ackRecebido;
	
	private long checksum;
	private int larguraPacote;
	
	private byte[] dados;	
	
	private int timer;

	public Pacote(int destino,int origem,int numSequencia, int numACK, 
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
	
	public Pacote(){
		 this.destino = 0;
		 this.origem = 0;
		
		 this.numSequencia = 0;
		 this.numACK = 0;
		 this.flags = 0;
		 this.ackRecebido = false;
		
		 this.checksum = 0;
		 this.larguraPacote = 0;
		
		 this.dados = null;	
		
		 this.timer = 0;
	}
	
	
	public long getChecksum(){
		return this.checksum;
	}
	
	public int getAck(){
		return this.numACK;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getOrigem() {
		return origem;
	}

	public void setOrigem(int origem) {
		this.origem = origem;
	}
	
	

	
}
