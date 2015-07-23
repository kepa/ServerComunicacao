package protocol;

public class Conversions {
	
	//TODO review this conversions
	
	public static void convertIntToByte (int integerValue, byte[] byteData, int index) {
		
		byteData[index++] = (byte) ((integerValue & 0xFF000000) >> 24);
		byteData[index++] = (byte) ((integerValue & 0x00FF0000) >> 16);
		byteData[index++] = (byte) ((integerValue & 0x0000FF00) >> 8);		
		byteData[index] = (byte) (integerValue & 0x000000FF);

	}
	
	public static void convertShortToByte (short shortValue, byte[] byteData, int index) {
		
		byteData[index++] = (byte) ((shortValue & 0xFF00) >> 8);
		byteData[index] = (byte) (shortValue & 0x00FF);
		
	}
	
	public static int convertByteToInt (byte[] byteData, int index) {
		
		int integerValue = 0;
		int temp = 0;
		
		if(byteData[index] < 0) {
			
			temp = 0x0000007F & (byteData[index]);
			temp += 128;
			
		} else {
			
			temp = 0x000000FF & (byteData[index]);
			
		}
		
		index++;
		integerValue = temp;
		integerValue <<= 8;
		
		if(byteData[index] < 0) {
			
			temp = 0x0000007F & (byteData[index]);
			temp += 128;
			
		} else {
			
			temp = 0x000000FF & (byteData[index]);
			
		}
		
		index++;
		integerValue = temp;
		integerValue <<= 8;
		
		if(byteData[index] < 0) {
			
			temp = 0x0000007F & (byteData[index]);
			temp += 128;
			
		} else {
			
			temp = 0x000000FF & (byteData[index]);
			
		}
		
		index++;
		integerValue = temp;
		integerValue <<= 8;
		
		if(byteData[index] < 0) {
			
			temp = 0x0000007F & (byteData[index]);
			temp += 128;
			
		} else {
			
			temp = 0x000000FF & (byteData[index]);
			
		}

		integerValue = temp;

		return integerValue;
	}

}
