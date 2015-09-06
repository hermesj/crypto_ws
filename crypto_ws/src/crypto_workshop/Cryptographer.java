package crypto_workshop;

/** A collection of basic encryption methods in Java.
 * Implemented for the CryptoWorkshop of the SSK-Stiftung
 * 2015-09-05
 * @author jhermes
 */
public class Cryptographer {
	
	/**
	 * Returns the encryption of specified String with Ceasars method (rot 3) 
	 * @param toencrypt String to encrypt
	 * @return encrypted String
	 */
	public static String encryptCeasar(String toencrypt){
		return encryptROT(toencrypt, 3);
	}
	
	/**
	 * Returns the encryption of the specified String with the ROT-(specified int) Method  
	 * @param toencrypt String to encrypt
	 * @param rot Value of ROT method
	 * @return encrypted String
	 */
	public static String encryptROT(String toencrypt, int rot){
		toencrypt = toencrypt.toLowerCase();
		StringBuffer encrypted = new StringBuffer();
		for(int i=0; i<toencrypt.length(); i++){
			encrypted.append(encodeChar(toencrypt.charAt(i), rot));
		}
		return encrypted.toString();
	}
	
	/**
	 * Encodes one character with the specified ROT method
	 * @param ch Character to encode
	 * @param rot Value of ROT method
	 * @return encoded character
	 */
	public static char encodeChar(char ch, int rot){
		int chValue = ch;
		chValue = chValue +rot;
		if(chValue>'z'){
			chValue = chValue - 26;
		}
		return (char) chValue;
	}
	
	/**
	 * Decodes one character with the specified ROT method
	 * @param ch Character to decode
	 * @param rot Value of ROT method
	 * @return decoded character
	 */
	public static char decodeChar(char ch, int rot){
		int chValue = ch;
		chValue = chValue -rot;
		if(chValue<'a'){
			chValue = chValue + 26;
		}
		return (char) chValue;
	}
	
	/**
	 * Returns the decryption of the specified String with the ROT-(specified int) Method  
	 * @param todecrypt String to decrypt
	 * @param rot Value of ROT method
	 * @return decrypted String
	 */
	public static String decryptROT(String todecrypt, int rot){
		todecrypt = todecrypt.toLowerCase();
		StringBuffer decrypted = new StringBuffer();
		for(int i=0; i<todecrypt.length(); i++){
			decrypted.append(decodeChar(todecrypt.charAt(i), rot));
		}
		return decrypted.toString();
	}
	
	/** Tests all ROT decryption methods on the specfied String 
	 * @param encoded encoded String 
	 */
	public static void testAllROT(String encoded){
		for(int i=1; i<=26; i++){
			System.out.println(decryptROT(encoded, i));
		}
	}
	
	/**
	 * Returns the encryption of the specified String with the Vigenere Method  
	 * @param toencrypt String to encrypt
	 * @param key Key for Vigenere method
	 * @return encrypted String
	 */
	public static String encryptVigenere(String toencrypt, String key){
		toencrypt = toencrypt.toLowerCase();
		key=key.toLowerCase();
		StringBuffer encrypted = new StringBuffer();
		for(int i=0; i<toencrypt.length();){
			for(int j=0; j<key.length()&&i<toencrypt.length(); j++){
				int rot = key.charAt(j)-'a';
				encrypted.append(encodeChar(toencrypt.charAt(i), rot));
				i++;				
			}
		}
		return encrypted.toString();
	}
	
	
	/**
	 * Returns the decryption of the specified String with the Vigenere Method  
	 * @param todecode String to encrypt
	 * @param key Key for Vigenere method
	 * @return decrypted String
	 */
	public static String decodeVigenere(String todecode, String key){
		todecode = todecode.toLowerCase();
		key=key.toLowerCase();
		StringBuffer encrypted = new StringBuffer();
		for(int i=0; i<todecode.length();){
			for(int j=0; j<key.length()&&i<todecode.length(); j++){
				int rot = key.charAt(j)-'a';
				encrypted.append(decodeChar(todecode.charAt(i), rot));
				i++;				
			}
		}
		return encrypted.toString();
	}

}
