package crypto_workshop;

public class Polyalphabetic extends Cryptographer {
	

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
