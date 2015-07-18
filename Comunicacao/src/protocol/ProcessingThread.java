package protocol;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class ProcessingThread extends Thread {

	private ProtocolBuffer receiverBuffer;
	private ProtocolBuffer senderBuffer;
	private DatagramSocket socket;
	private InetAddress sourceIP;
	private int sourcePort;
	private ProtocolInstance protocol;
	
	public ProcessingThread (ProtocolBuffer receiverBuffer, ProtocolBuffer senderBuffer, DatagramSocket socket, InetAddress sourceIP, int sourcePort, ProtocolInstance protocol) {
		
		this.receiverBuffer = receiverBuffer;
		this.senderBuffer = senderBuffer;
		this.socket = socket;
		this.sourceIP = sourceIP;
		this.sourcePort = sourcePort;
		this.protocol = protocol;
		
	}
	
	public void run() {
		
		// *** complete 
		// Essentially:  while(cond==true){  // may loop for ever if you will not implement RDT::close()  
		//                socket.receive(pkt)
		//                seg = make a segment from the pkt
		//                verify checksum of seg
		//	              if seg contains ACK, process it potentailly removing segments from sndBuf
		//                if seg contains data, put the data in rcvBuf and do any necessary 
		//                             stuff (e.g, send ACK)
		//
		
	}
	
	public void makeSegment(ProtocolSegment segment, byte[] payload) {
		
		
		
	}
	
}
