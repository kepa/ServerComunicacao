package protocol;

public class ProtocolSegment {
	
	//review this data for segment
	private static final int SEQUENCE_NUMBER_OFFSET = 0;
	private static final int ACK_NUMBER_OFFSET = 4;
	private static final int FLAGS_OFFSET = 8;
	private static final int CHECKSUM_OFFSET = 12;
	private static final int RECEIVER_WINDOW_OFFSET = 12;
	private static final int SEGMENT_LENGHT_OFFSET = 20;
	private static final int HEADER_SIZE = 24;
	
	private int sequenceNumber;
	private int ackNumber;
	private int flags;
	private int checksum;
	private int receiverWindow;
	private int segmentLength; // number of data bytes (<= MSS)
	private byte[] segmentData;	
	private boolean ackReceived;
	private TimerHandler timerHandler;
	
	
	public ProtocolSegment(ProtocolInstance protocolInstance) {
		
		this.segmentData = new byte[protocolInstance.getMaximumSegmentSize()];
		this.sequenceNumber = 0;
		this.ackNumber = 0;
		this.flags = 0;
		this.checksum = 0;
		this.receiverWindow = 0;
		this.segmentLength = 0;
		this.ackReceived = false;	
		
	}
	
	//complete method
	public int checkSum() {
		
		//TODO
		
		return 0;
		
	}
	
	//complete method
	public boolean hasAck() {
		
		//TODO
		return false;
	}
	
	//complete method
	public boolean hasData() {
		
		//TODO
		return false;
		
	}
	
	public void makePayload(byte[] payload) {
		
		//TODO
		//finish implementation
		
	}
	
			
}
