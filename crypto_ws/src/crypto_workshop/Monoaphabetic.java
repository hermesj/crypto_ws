package crypto_workshop;

import java.util.HashSet;
import java.util.Set;

public class Monoaphabetic extends Cryptographer{
	
	/**
	 * Returns the encryption of specified String with Ceasars method (rot 3) 
	 * @param toencrypt String to encrypt
	 * @return encrypted String
	 */
	public static String encryptCeasar(String toencrypt){
		return encryptROT(toencrypt, 3);
	}
	
	public static String decryptCeasar(String todecrypt){
		return decryptROT(todecrypt, 3);
	}
	
	/**
	 * Returns the encryption of the specified String with the ROT-(specified int) Method  
	 * @param toencrypt String to encrypt
	 * @param rot Value of ROT method
	 * @return encrypted String
	 */
	public static String encryptROT(String toencrypt, int rot){
		toencrypt = normalize(toencrypt);
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
		todecrypt = normalize(todecrypt);
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
	
	
	public static String encryptWithCodeWord(String codeword, String toencrypt){
		toencrypt = normalize(toencrypt);
		char[] substitutionAlphabet = getSubstitutionAlphabet(codeword);
		
		StringBuffer encrypted = new StringBuffer();
		for(int i=0; i<toencrypt.length();i++){
			
			char current = toencrypt.charAt(i);
			if(Character.isLetter(current)){
				int position = current - 'a';
				encrypted.append(substitutionAlphabet[position]);
			}
			else{
				encrypted.append(current);
			}
		}
		
		return encrypted.toString();
	}
	
	public static String decryptWithCodeWord(String codeword, String todecrypt){
		todecrypt = normalize(todecrypt);
		
		char[] substitutionAlphabet = getSubstitutionAlphabet(codeword);
		
		StringBuffer decrypted = new StringBuffer();
		for(int i=0; i<todecrypt.length();i++){
			char current = todecrypt.charAt(i);
			if(Character.isLetter(current)){
				for (int j = 0; j < substitutionAlphabet.length; j++) {
					if(current == substitutionAlphabet[j]){
						decrypted.append((char)(j+'a'));
					}
				}
			}
			else{
				decrypted.append(current);
			}
			
		}
		
		return decrypted.toString();
	}
	
	public static char[] getSubstitutionAlphabet(String codeword){
		char[] substitionAlphabet = new char[26];
		int alphCounter = 0;
		codeword = normalize(codeword);
		Set<Character> alreadyIn = new HashSet<Character>();
		for(int i=0; i<codeword.length(); i++){
			char current = codeword.charAt(i);
			if(Character.isLetter(current) && !alreadyIn.contains(current)){
				substitionAlphabet[alphCounter]=current;
				alphCounter++;
			}
			alreadyIn.add(current);			
		}
		for(int i='z'; i>='a'; i--){
			char current = (char)i;
			if(!alreadyIn.contains(current)){
				substitionAlphabet[alphCounter]=current;
				alphCounter++;
			}
		}
		return substitionAlphabet;
	}
	

}
