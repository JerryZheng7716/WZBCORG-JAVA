package other.wzbcOrg;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 implements Base64Imp {

	public String encode(String str) {
		byte[] bt = str.getBytes(); 
		String newKey=(new BASE64Encoder()).encodeBuffer(bt); 
		return newKey;
	}

	public String getFormattedText(byte[] bytes) {
		byte[] bt;
		String key = "";
		try {
			bt = (new BASE64Decoder()).decodeBuffer(new String(bytes));
			key=new String(bt, "utf-8"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return key;

	}

}
