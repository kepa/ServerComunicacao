package protocol;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ProtocolInstance {
	
	//set this to conform to SR protocol
	private static final int MAXIMUM_BUFFER_SIZE = 3;
	private static final int MAXIMUM_SEGMENT_SIZE_BYTES = 100;
	
	private int sourcePort;
	private int destinationPort;
	private InetAddress sourceIP;
	private DatagramSocket socket;	
	private ProtocolBuffer senderBuffer;
	private ProtocolBuffer receiverBuffer;
	
	public ProtocolInstance(String sourceHost, int sourcePort, int destinationPort) {
		
		//source is the host and destination is the server
		this.sourcePort = sourcePort;
		this.destinationPort = destinationPort;
		
		try {
			
			this.socket = new DatagramSocket(this.destinationPort);
			this.sourceIP = InetAddress.getByName(sourceHost);
		
		} catch (IOException e) {
			
			System.out.println("Problems with ProtocolInstance Constructor: " + e);
			
		}
		
		//pass MAXIMUM_BUFFER_SIZE as parameter when Buffer implemented
		this.senderBuffer = new ProtocolBuffer();
		this.receiverBuffer = new ProtocolBuffer();
		
		ProcessingThread thread = new ProcessingThread(this.receiverBuffer, this.senderBuffer, this.socket, this.sourceIP, this.sourcePort, this);
		thread.start();
		
	}
	
	public ProtocolInstance(String sourceHost, int sourcePort, int destinationPort, int senderBufferSize, int receiverBufferSize) {
		
		//source is the host and destination is the server
		this.sourcePort = sourcePort;
		this.destinationPort = destinationPort;
		
		try {
			
			this.socket = new DatagramSocket(this.destinationPort);
			this.sourceIP = InetAddress.getByName(sourceHost);
		
		} catch (IOException e) {
			
			System.out.println("Problems with ProtocolInstance Constructor: " + e);
			
		}
		
		
		//pass senderBufferSize and receiverBufferSize as parameters when Buffer implemented
		this.senderBuffer = new ProtocolBuffer();
		this.receiverBuffer = new ProtocolBuffer();
		
		ProcessingThread thread = new ProcessingThread(this.receiverBuffer, this.senderBuffer, this.socket, this.sourceIP, this.sourcePort, this);
		thread.start();
		
	}
	
	// called by application
	// returns total number of sent bytes 
	public int sendData(byte[] buffer, int size) {
		
		//****** complete	
		// divide data into segments	
		// put each segment into sndBuf		
		// send using udp_send()	
		// schedule timeout for segment(s) 
		
		return size;
		
	}
	
	// called by app
	// receive one segment at a time
	// returns number of bytes copied in buffer
	public int receivedData(byte[] buffer, int size) {
		
		//*****  complete
		
		return 0;   // fix
		
	}
	
	// called by application
	public void close() {
		
		//close the connection
	
	}
	
	public int getMaximumBufferSize() {
		
		return ProtocolInstance.MAXIMUM_BUFFER_SIZE;
		
	}
	
	public int getMaximumSegmentSize() {
		
		return ProtocolInstance.MAXIMUM_SEGMENT_SIZE_BYTES;
		
	}

}
