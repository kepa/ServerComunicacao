package protocoloConfiavel;

import java.net.DatagramSocket;
import java.net.InetAddress;

import protocol.Conversions;
import protocol.ProtocolSegment;


public class GerConfiavel extends Thread {
	
	private ProtocolBuffer receiverBuffer;
	private ProtocolBuffer senderBuffer;
	private DatagramSocket socket;
	private InetAddress sourceIP;
	private int sourcePort;
	private Protocolo protocolo;
	
	public GerConfiavel(DatagramSocket socket){
		this.socket = socket;
	}
	
	public void run() {
		
		try{
			processamento();
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public void processamento() throws Exception{
		
		
		
		while(true){
			
			
			
			if(){
				
			}
			
		}
	}
		
	public void makeSegment(Pacote pacote, byte[] payload) {
		
		segment.setSequenceNumber(Conversions.convertByteToInt(payload, ProtocolSegment.getSequenceNumberOffset()));
		segment.setAckNumber(Conversions.convertByteToInt(payload, ProtocolSegment.getAckNumberOffset()));
		segment.setFlags(Conversions.convertByteToInt(payload, ProtocolSegment.getFlagsOffset()));
		segment.setChecksum(Conversions.convertByteToInt(payload, ProtocolSegment.getChecksumOffset()));
		segment.setReceiverWindow(Conversions.convertByteToInt(payload, ProtocolSegment.getReceiverWindowOffset()));
		
		byte[] data = segment.getSegmentData();
		
		for (int i=0; i<segment.getSegmentLength(); i++) {
			
			data[i] = payload[i+ProtocolSegment.getHeaderSize()];
			
		}
		
		segment.setSegmentData(data);
		
	}
	
}
