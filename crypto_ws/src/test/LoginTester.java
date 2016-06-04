package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import crypto_workshop.login.UserInterface;

public class LoginTester {

	@Test
	public void testLogin() throws IOException {
		UserInterface.start("data.txt");
	}

}
