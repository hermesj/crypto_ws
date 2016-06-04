package crypto_workshop.login;

public class Account {
	
	private String name;
	private String password;
	
	public Account(String name, String password) {
		this.name = name;
		this.password = password.hashCode()+"";
	}
	
	public Account(String name, String password, boolean dbImport) {
		if(dbImport){
			this.name=name;
			this.password=password;
		}
		else{
			this.name = name;
			this.password = password.hashCode()+"";
		}
	}

	public String getName(){
		return name;
	}
	
	public boolean checkPassword(String password){
		if(this.password.equals(password.hashCode()+"")){
			return true;
		}
		return false;
	}

	public String getPassword() {
		return password;
	}
	
	

}
