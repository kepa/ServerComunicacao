package protocoloConfiavel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;

public class Tester {

	public static void main(String[] args) {
	
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		
		
		
		Pacote n = new Pacote(0,22,322);
		
	try {
		
		
		out = new ObjectOutputStream(bos);   
		out.writeObject(n);
		byte[] b = bos.toByteArray();
		
		out.close();
		
		DatagramPacket d = new DatagramPacket(b, b.length);
		
		System.out.println(d.getData().length);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(d.getData());
		ObjectInputStream in = null;
		
		in = new ObjectInputStream(bis);
		Pacote o = (Pacote)in.readObject();
		
		System.out.println(o.getAck());

	} catch (Exception e) {
		System.out.print(e.getLocalizedMessage());
	}

	}

}
