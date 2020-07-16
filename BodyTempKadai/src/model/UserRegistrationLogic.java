package model;

import dao.AcountDAO;
public class UserRegistrationLogic {
	public boolean Register(UserInfomation userInfomation) {
		AcountDAO dao = new AcountDAO();
		boolean result = dao.RegistraionUser(userInfomation);
		return result;
	}

}
