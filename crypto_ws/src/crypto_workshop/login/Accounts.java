package crypto_workshop.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Accounts {
	
	private Map<String,Account> accounts;
	private String exportFile;
	
	public Accounts(String fileName) throws IOException{
		accounts = new HashMap<String,Account>();
		File file = new File(fileName);
		if(!file.exists()){
			file.createNewFile();
		}
		exportFile = fileName;
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		while(line!=null){
			String[] split = line.split("\t");
			String name = split[0];
			String password = split[1];
			if(accounts.containsKey(name)){
				System.out.println("Doppelter Account: " + name + " wird nicht berücksichtigt");
			}
			else{
				System.out.println("Accountdaten gelesen: " + name);
				Account acc = new Account(name, password, true);
				accounts.put(name, acc);
			}
			line= in.readLine();
		}
		in.close();
	}
	
	public void login(String name, String password){
		if(accounts.containsKey(name)){
			Account account = accounts.get(name);
			if(account.checkPassword(password)){
				System.out.println("Herzlich Willkommen, " + name);
			}
			else{
				System.out.println("Falsches Passwort, Zugang verweigert.");
			}
		}
		else{
			System.out.println("Account nicht gefunden, bitte registrieren Sie sich.");
		}
	}
	
	public void register(String name, String password){
		if(accounts.containsKey(name)){
			System.out.println("Name ist bereits vergeben, bitte einen anderen wählen.");
		}
		else{
			Account newAcc = new Account(name, password);
			accounts.put(name, newAcc);
			System.out.println("Herzlich Willkommen, " + name + ". Der Account wurde gespeichert");
		}
	}
	
	public void export() throws IOException{
		File file = new File(exportFile);
		PrintWriter out = new PrintWriter(new FileWriter(file));
		Set<String> keySet = accounts.keySet();
		for (String key : keySet) {
			Account account = accounts.get(key);
			out.println(account.getName() + "\t"+account.getPassword());
		}
		out.flush();
		out.close();
	}

}
