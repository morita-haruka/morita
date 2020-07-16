package model;

import dao.AcountDAO;

public class UserLoginLogic {
	public String execute(Login login) {
		AcountDAO dao = new AcountDAO();
		String userid = dao.findByLogin(login);
		return userid;
	}
}
