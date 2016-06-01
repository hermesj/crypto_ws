package test;

import org.junit.Test;

import crypto_workshop.Monoaphabetic;

public class TestCaesar {

	@Test
	public void testCaesarMode() {
		String toencrypt = "Dieser Text soll verschlüsselt werden.";
		String encrypted = Monoaphabetic.encryptCeasar(toencrypt);
		String decrypted = Monoaphabetic.decryptCeasar(encrypted);
		
		System.out.println("Originaltext:\t" + toencrypt);
		System.out.println("Verschlüsselt:\t" + encrypted);
		System.out.println("Entschlüsselt:\t" + decrypted);
	}

}
