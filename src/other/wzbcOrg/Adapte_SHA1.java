package other.wzbcOrg;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Adapte_SHA1 implements Base64Imp{
	private SHA1 sha1;
	public Adapte_SHA1(SHA1 sha1){
		this.sha1 = sha1;
	}
	public  String getFormattedText(byte[] bytes) {
		
		return sha1.getFormattedText(bytes);
	
	}
	
	public String encode(String str) {
		return sha1.encode(str);
	}

}
