package protocol;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.TimerTask;

public class TimerHandler extends TimerTask {

	private ProtocolBuffer senderBuffer;
	private ProtocolSegment segment;
	private DatagramSocket socket;
	private InetAddress ip;
	private int port;
	
	public TimerHandler(ProtocolBuffer senderBuffer, ProtocolSegment segment, DatagramSocket socket, InetAddress ip, int port) {
		
		this.senderBuffer = senderBuffer;
		this.segment = segment;
		this.socket = socket;
		this.ip = ip;
		this.port = port;
		
	}
	
	public void run() {
		// TODO complete for SR
		
	}

}
