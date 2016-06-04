package crypto_workshop.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {
	
	public static void start(String database) throws IOException{
		Accounts accounts = new Accounts(database);
		
		boolean stopped = false;
		while (!stopped) {
			System.out.println("Was wollen Sie tun?");
			System.out.println("Drücken Sie 1 für das Registrieren.");
			System.out.println("Drücken Sie 2 für das Einloggen.");
			System.out.println("Drücken Sie 3 für das Beenden.");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int chValue = in.readLine().charAt(0);
			String name;
			String password;
			switch (chValue) {
			case '1':
				System.out.println("Bitte wählen Sie Ihren Nutzernamen");
				name = in.readLine();
				System.out.println("Bitte wählen Sie Ihr Passwort");
				password = in.readLine();
				accounts.register(name, password);
				break;
			case '2':
				System.out.println("Bitte wählen Sie Ihren Nutzernamen");
				name = in.readLine();
				System.out.println("Bitte wählen Sie Ihr Passwort");
				password = in.readLine();
				accounts.login(name, password);;
				break;
			case '3':
				accounts.export();
				stopped = true;
			}
			System.out.println();
			System.out.println();
		}
		
	}

}
