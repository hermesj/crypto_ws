package test;

import static org.junit.Assert.*;

import org.junit.Test;

import crypto_workshop.Cryptographer;

/**
 * Tests to test the Cryptographer class.
 * Implemented for the CryptoWorkshop of the SSK-Stiftung
 * 2015-09-05
 * @author jhermes
 *
 */
public class CryptoTests {

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
		String encryptCeasar = Cryptographer.encryptCeasar("abz");
		System.out.println(encryptCeasar);
	}

	
	/**
	 * Test encryption and decoding with ROT method
	 */
	@Test 
	public void forwardback(){
		String toencrypt = "wirverschluesselnjetztdiesensatz";
		String encrypted = Cryptographer.encryptROT(toencrypt, 3);
		String decrypted = Cryptographer.decryptROT(encrypted, 3);
		System.out.println(encrypted);
		System.out.println(decrypted);
	}
	
	
	/**
	 * Test brute force ROT decoding
	 */
	@Test
	public void decodeBruteForce(){
		String toencrypt = "malsehenobmandashiererkennt";
		String encrypted = Cryptographer.encryptROT(toencrypt, 15);
		Cryptographer.testAllROT(encrypted);
	}
	
	/**
	 * Test Vigenere encryption
	 */
	@Test
	public void encodeVigenere(){
		String toencrypt = "malsehenobmandashiererkennt";
		String encrypted = Cryptographer.encryptVigenere(toencrypt, "hund");
		Cryptographer.testAllROT(encrypted);
	}
	
	/**
	 * Test Vigenere decoding
	 */
	@Test
	public void decodeVigenere(){
		String toencrypt = "malsehenobmandashiererkennt";
		String encrypted = Cryptographer.encryptVigenere(toencrypt, "hund");
		String decoded = Cryptographer.decodeVigenere(encrypted, "hund");
		System.out.println(decoded);
	}
}
