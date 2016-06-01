package test;

import org.junit.Test;

import crypto_workshop.Monoaphabetic;

public class TestROT {

	@Test
	public void testROT1() {
		
		int i = 1;
		String toencrypt = "Dieser Text soll verschlüsselt werden.";
		String encrypted = Monoaphabetic.encryptROT(toencrypt, i);
		String decrypted = Monoaphabetic.decryptROT(encrypted, i);
		
		System.out.println("Verschlüsseln und entschlüsseln mit ROT " + i);
		System.out.println("------------------------------------------");
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		System.out.println("Entschlüsselt:\t" + decrypted);
		System.out.println();
		System.out.println();
		
	}
	
	@Test
	public void testROTCodeBreak() {
		String toencrypt = "Dieser Text soll verschlüsselt werden.";
		String encrypted = Monoaphabetic.encryptROT(toencrypt, 1);
		String decrypted = Monoaphabetic.decryptROT(encrypted, 2);
		
		System.out.println("Verschlüsseln mit unbekanntem ROT, Versuch der Entschlüsselung");
		System.out.println("--------------------------------------------------------------");
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		System.out.println("Entschlüsselt:\t" + decrypted);
		System.out.println();
		System.out.println();
	}
	
	@Test
	public void testROTCodeBreakBruteForce() {
		String toencrypt = "Dieser Text soll verschlüsselt werden.";
		String encrypted = Monoaphabetic.encryptROT(toencrypt, 10);
		
		
		System.out.println("Verschlüsseln mit unbekanntem ROT, Versuch der Entschlüsselung");
		System.out.println("--------------------------------------------------------------");
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		for(int i=1; i<=26;i++){
			String decrypted = Monoaphabetic.decryptROT(encrypted, i);
			System.out.println("Versuch "+i+":\t" + decrypted);
		}	
		
		System.out.println();
		System.out.println();
	}

}
