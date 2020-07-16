package model;

public class Login {
	String mailAdress;
	String passWord;

	public Login(String mailadress,String password) {
		this.mailAdress = mailadress;
		this.passWord = password;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public String getPassWord() {
		return passWord;
	}
}
