package group.pro150.chatroom.userauth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class Password {
	String encodedPass, randGenStr;

	Password(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		randGenStr = "";
		for (int i = 0; i < 255; i++) {
			int hi = (int) (Math.random() * 64 + 45);
			if (hi > 45) {
				hi += 2;
			}
			if (hi > 57) {
				hi += 7;
			}
			if (hi > 90) {
				hi += 4;
			}
			if (hi > 95) {
				hi += 1;
			}
			if (hi > 122) {
				hi = 45;
			}
			if (hi < 45) {
				hi = 45;
			}
			randGenStr += (char) hi;
		}
		this.encodedPass = hashWith256(password, randGenStr);
	}
	
	Password(String password, String randGenStr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		this.randGenStr = randGenStr;
		this.encodedPass = hashWith256(password, randGenStr);
	}

	public String getEncodedPass() {
		return encodedPass;
	}

	public String getRandGenStr() {
		return randGenStr;
	}
	
	public void setPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.encodedPass = hashWith256(password, randGenStr);
	}
	
	public void setPasswordAndRand(String password , String randGenStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.encodedPass = hashWith256(password, randGenStr);
		this.randGenStr = randGenStr;
	}

	public boolean checkPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String encodedPassTemp = hashWith256(password, randGenStr);
		if (encodedPassTemp.equals(encodedPass)) {
			return true;
		} else {
			return false;
		}
	}

	public static String hashWith256(String textToHash, String theRandStr)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		textToHash += theRandStr;
		byte[] byteOfTextToHash = textToHash.getBytes("UTF-8");
		byte[] hashedByteArray = digest.digest(byteOfTextToHash);
		String encoded = Base64.encode(hashedByteArray);
		return encoded;
	}
}