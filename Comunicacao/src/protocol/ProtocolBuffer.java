package protocol;

import java.util.concurrent.Semaphore;

public class ProtocolBuffer {
	
	private ProtocolSegment[] buffer;
	private int bufferSize;
	private int bufferBase;
	private int bufferNext;
	private Semaphore mutex;
	private Semaphore full;
	private Semaphore empty;
	
	public ProtocolBuffer(int bufferSize) {
		
		this.buffer = new ProtocolSegment[bufferSize];
		
		for (int i = 0; i<bufferSize; i++) {
			
			this.buffer[i] = null;
			
		}
		
		this.bufferSize = bufferSize;
		this.bufferBase = 0;
		this.bufferNext = 0;
		this.mutex = new Semaphore(1, true);
		this.full = new Semaphore(0, true);
		this.empty = new Semaphore(bufferSize, true);
		
	}
	
	public void putInNextSlot(ProtocolSegment segment) {
		
		try {
			
			this.empty.acquire();
			this.mutex.acquire();
			
			this.buffer[this.bufferNext%this.bufferSize] = segment;
			this.bufferNext++;
			
			this.mutex.release();
			this.full.release();
			
		} catch (InterruptedException e) {

			System.out.println("Buffer put in next slot having some trouble: " + e);
			
		}

	}
	
	public ProtocolSegment getNext() {
		
		//TODO complete
		return null;
		
	}
	
	// Put a segment in the *right* slot based on seg.seqNum
	// used by receiver in Selective Repeat
	public void putSegmentInSequenceNumber(ProtocolSegment segment) {
		
		//TODO complete
		
	}

}
