package test;

import org.junit.Test;

import crypto_workshop.Cryptographer;
import crypto_workshop.Monoaphabetic;
import crypto_workshop.Polyalphabetic;

/**
 * Tests to test the Cryptographer class.
 * Implemented for the CryptoWorkshop of the SSK-Stiftung
 * 2015-09-05
 * @author jhermes
 *
 */
public class CryptoTests {

	@Test 
	public void testCodeWordMonoAlph(){
		String codeword = "Hundenase";
		String toencrypt = "Dies ist der zu verschlüsselnde Text";
		String encrypted = Monoaphabetic.encryptWithCodeWord(codeword, toencrypt);
		String decrypted = Monoaphabetic.decryptWithCodeWord(codeword, encrypted);
		
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		System.out.println("Entschlüsselt:\t" + decrypted);
	}
	
	@Test
	public void testGetSubAlph(){
		String codeword = "Ähnliche";
		Monoaphabetic.getSubstitutionAlphabet(codeword);
	}
	
	@Test
	public void testPreprocess(){
		String text = "mäl söhün öb tatßächlich alles Örsetzt Ürd.";
		System.out.println(Cryptographer.normalize(text));
				
	}
	
	/**
	 * Test to show how Characters were represented in Java
	 */
	@Test
	public void testCharacters() {
		Character ch = 'a';
		System.out.println(ch);
		System.out.println((char)(ch+1));
	}
	
	/**
	 * Test the Ceasar method
	 */
	@Test
	public void testCeasar(){
		String encryptCeasar = Monoaphabetic.encryptCeasar("abz");
		System.out.println(encryptCeasar);
	}

	
	/**
	 * Test encryption and decoding with ROT method
	 */
	@Test 
	public void forwardback(){
		String toencrypt = "wirverschluesselnjetztdiesensatz";
		String encrypted = Monoaphabetic.encryptROT(toencrypt, 3);
		String decrypted = Monoaphabetic.decryptROT(encrypted, 3);
		System.out.println(encrypted);
		System.out.println(decrypted);
	}
	
	
	/**
	 * Test brute force ROT decoding
	 */
	@Test
	public void decodeBruteForce(){
		String toencrypt = "malsehenobmandashiererkennt";
		String encrypted = Monoaphabetic.encryptROT(toencrypt, 15);
		Monoaphabetic.testAllROT(encrypted);
	}
	
	/**
	 * Test Vigenere encryption
	 */
	@Test
	public void encodeVigenere(){
		String toencrypt = "boxkampfschilderung";
		String encrypted = Polyalphabetic.encryptVigenere(toencrypt, "hund");
		Monoaphabetic.testAllROT(encrypted);
	}
	
	/**
	 * Test Vigenere decoding
	 */
	@Test
	public void decodeVigenere(){
		String toencrypt = "boxkampfschilderung"; 
		String encrypted = Polyalphabetic.encryptVigenere(toencrypt, "hund");
		String decoded = Polyalphabetic.decodeVigenere(encrypted, "hund");
		System.out.println(decoded);
	}
	
	@Test
	public void testFreqAnalysis(){
		String toTest = "dannwollenwirmalgenaudiesentextaufseinehaeufigkeitenuntersuchenjelaengerdabeidertextdestosprechenderduerftedasergebnisseinaberlangsamistauchmalgutoder";
		Cryptographer.countLetters(toTest);
	}
}
