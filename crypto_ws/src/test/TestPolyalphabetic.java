package test;

import org.junit.Test;

import crypto_workshop.Cryptographer;
import crypto_workshop.Monoaphabetic;
import crypto_workshop.Polyalphabetic;

public class TestPolyalphabetic {
	
	/**
	 * Test Vigenere encryption
	 */
	@Test
	public void encodeVigenere(){
		String codeword = "boxkampfschilderung";
		String toencrypt = "Dieser Text soll verschlüsselt werden. Er kann sehr viel einfacher entschlüsselt werden, je länger er ist, deswegen schreibe ich hier noch etwas mehr dazu. Vor allem der, die und das sind einfach zu erkennen. Toll, oder?";
		String encrypted = Polyalphabetic.encryptVigenere(toencrypt, codeword);
		Monoaphabetic.testAllROT(encrypted);
		Cryptographer.countLetters(encrypted);
		Cryptographer.countBigrams(encrypted);
		Cryptographer.countTwins(encrypted);
	}
	
	/**
	 * Test Vigenere decoding
	 */
	@Test
	public void decodeVigenere(){
		String codeword = "boxkampfschilderung";
		String toencrypt = "Dieser Text soll verschlüsselt werden."; 
		String encrypted = Polyalphabetic.encryptVigenere(toencrypt, codeword);
		String decrypted = Polyalphabetic.decodeVigenere(encrypted, codeword);
		System.out.println("Polyalphabetisches verschlüsseln und entschlüsseln mit Codewort " + codeword);
		System.out.println("------------------------------------------");
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		System.out.println("Entschlüsselt:\t" + decrypted);
		System.out.println();
		System.out.println();
	}

}
