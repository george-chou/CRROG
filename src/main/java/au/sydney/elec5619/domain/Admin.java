package au.sydney.elec5619.domain;

public class Admin {
	
	private String password;

	@Override
	public String toString() {
		return "Admin [password=" + password + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

}
