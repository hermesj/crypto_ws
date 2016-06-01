package test;

import org.junit.Test;

import crypto_workshop.Cryptographer;
import crypto_workshop.Monoaphabetic;

public class TestCodwordMonoAlph {

	@Test
	public void testCodewordMono() {
		
		String codeword = "Kryptologie";
		String toencrypt = "Dieser Text soll verschlüsselt werden.";
		String encrypted = Monoaphabetic.encryptWithCodeWord(codeword, toencrypt);
		String decrypted = Monoaphabetic.decryptWithCodeWord(codeword, encrypted);
		
		System.out.println("Verschlüsseln und entschlüsseln mit Codewort " + codeword);
		System.out.println("------------------------------------------");
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		System.out.println("Entschlüsselt:\t" + decrypted);
		System.out.println();
		System.out.println();
		
	}
	
	
	@Test
	public void testCodewordBreakBruteForce() {
		String codeword = "Kryptologie";
		String toencrypt = "Dieser Text soll verschlüsselt werden.";
		String encrypted = Monoaphabetic.encryptWithCodeWord(codeword, toencrypt);
			
		System.out.println("Verschlüsseln und entschlüsseln mit Codewort " + codeword);
		System.out.println("------------------------------------------");
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		for(int i=1; i<=26;i++){
			String decrypted = Monoaphabetic.decryptROT(encrypted, i);
			System.out.println("Versuch "+i+":\t" + decrypted);
		}	
		
		System.out.println();
		System.out.println();
	}
	
	@Test
	public void testCodewordBreakFreqAnalysis(){
		String codeword = "Kryptologie";
		String toencrypt = "Dieser Text soll verschlüsselt werden. Er kann sehr viel einfacher entschlüsselt werden, je länger er ist, deswegen schreibe ich hier noch etwas mehr dazu. Vor allem der, die und das sind einfach zu erkennen. Toll, oder?";
		String encrypted = Monoaphabetic.encryptWithCodeWord(codeword, toencrypt);
			
		System.out.println("Verschlüsseln und entschlüsseln mit Codewort " + codeword);
		System.out.println("------------------------------------------");
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		
		Cryptographer.countLetters(encrypted);
		
		Cryptographer.countBigrams(encrypted);
		
		Cryptographer.countTwins(encrypted);
		
		System.out.println();
		System.out.println();
	}
	

}
