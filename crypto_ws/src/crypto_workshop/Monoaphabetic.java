package crypto_workshop;

public class Monoaphabetic extends Cryptographer{
	
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
	

}
