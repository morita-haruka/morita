package model;

public class UserInfomation {
	String name;
	String mailAdress;
	String passWord;

	public UserInfomation(String name,String mailadress,String password) {
		this.name = name;
		this.mailAdress = mailadress;
		this.passWord = password;
	}

	public String getName() {
		return name;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public String getPassWord() {
		return passWord;
	}
}
