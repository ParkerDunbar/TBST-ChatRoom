package group.pro150.chatroom.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class Password {
	String encodedPass, randGenStr;

	Password(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.randGenStr = genRandBase64Str(127);
		this.encodedPass = hashWith256(password, randGenStr);
	}
	
	Password(String password, String randGenStr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		this.randGenStr = randGenStr;
		this.encodedPass = hashWith256(password, randGenStr);
	}
	
	Password(String encodedPass, String randGenStr, boolean areYouSureYouWantToDoThis) throws cluelessCallerException{
		if(!areYouSureYouWantToDoThis) {
			throw new cluelessCallerException();
		}
		else {
			this.encodedPass = encodedPass;
			this.randGenStr = randGenStr;
		}
	}
	
	public static String genRandBase64Str(int length) {
		String randGenStr = "";
		for (int i = 0; i < length; i++) {
			int randomCharacterInteger = (int) (Math.random() * 62 + 48);
			if (randomCharacterInteger > 57) {
				randomCharacterInteger += 7;
			}
			if (randomCharacterInteger > 90) {
				randomCharacterInteger += 6;
			}
			if (randomCharacterInteger > 122) {
				randomCharacterInteger = 48;
			}
			if (randomCharacterInteger < 48) {
				randomCharacterInteger = 48;
			}
			randGenStr += (char) randomCharacterInteger;
		}
		return randGenStr;	
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
	
	public void setPassword(String password, String randGenStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
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
		byte[] hashedByetArray = digest.digest(byteOfTextToHash);
		String encoded = Base64.encode(hashedByetArray);
		encoded = encoded.replaceAll("\\+", "");
		encoded = encoded.replaceAll("\\/", "");
		encoded = encoded.replaceAll("=", "");
		return encoded;
	}
}
