package protocol;

public class ProtocolSegment {
	
	//review this data for segment
	private static final int SEQUENCE_NUMBER_OFFSET = 0;
	private static final int ACK_NUMBER_OFFSET = 4;
	private static final int FLAGS_OFFSET = 8;
	private static final int CHECKSUM_OFFSET = 12;
	private static final int RECEIVER_WINDOW_OFFSET = 12;
	private static final int SEGMENT_LENGTH_OFFSET = 20;
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
	
	public void setSequenceNumber(int sequenceNumber) {
		
		this.sequenceNumber = sequenceNumber;
		
	}
	
	public static int getSequenceNumberOffset() {
		
		return SEQUENCE_NUMBER_OFFSET;
		
	}
	
	public void setAckNumber(int ackNumber) {
		
		this.ackNumber = ackNumber;
		
	}
	
	public static int getAckNumberOffset() {
		
		return ACK_NUMBER_OFFSET;
		
	}
	
	public void setFlags(int flags) {
		
		this.flags = flags;
		
	}
	
	public static int getFlagsOffset() {
		
		return FLAGS_OFFSET;
		
	}
	
	public void setChecksum(int checksum) {
		
		this.checksum = checksum;
		
	}
	
	public static int getChecksumOffset() {
		
		return CHECKSUM_OFFSET;
		
	}
	
	public void setReceiverWindow(int receiverWindow) {
		
		this.receiverWindow = receiverWindow;
		
	}
	
	public static int getReceiverWindowOffset() {
		
		return RECEIVER_WINDOW_OFFSET;
		
	}
	
	public void setSegmentLength(int segmentLength) {
		
		this.segmentLength = segmentLength;
		
	}
	
	public static int getSegmentLengthOffset() {
		
		return SEGMENT_LENGTH_OFFSET;
		
	}
	
	public static int getHeaderSize() {
		
		return HEADER_SIZE;
		
	}
	
	public int getSegmentLength() {
		
		return this.segmentLength;
		
	}
	
	public byte[] getSegmentData() {
		
		return this.segmentData;
		
	}
	
	public void setSegmentData(byte[] segmentData) {
		
		this.segmentData = segmentData;
		
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
	
	//TODO check this method, is not return nor setting anything
	public void makePayload(byte[] payload) {
		
		Conversions.convertIntToByte(this.sequenceNumber, payload, ProtocolSegment.SEQUENCE_NUMBER_OFFSET);
		Conversions.convertIntToByte(this.ackNumber, payload, ProtocolSegment.ACK_NUMBER_OFFSET);
		Conversions.convertIntToByte(this.flags, payload, ProtocolSegment.FLAGS_OFFSET);
		Conversions.convertIntToByte(this.checksum, payload, ProtocolSegment.CHECKSUM_OFFSET);
		Conversions.convertIntToByte(this.receiverWindow, payload, ProtocolSegment.RECEIVER_WINDOW_OFFSET);
		Conversions.convertIntToByte(this.segmentLength, payload, ProtocolSegment.SEGMENT_LENGTH_OFFSET);
		
		for (int i = 0; i<this.segmentLength; i++) {
			
			payload[i+ProtocolSegment.HEADER_SIZE] = this.segmentData[i];
			
		}
		
	}
	
			
}
