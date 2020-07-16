package model;

import dao.BodyTempRegisterDAO;

public class BodyTempRegistrationLogic {
	public boolean Register(BodyTempDateRegist bodyTempDateRegist) {
		BodyTempRegisterDAO dao = new BodyTempRegisterDAO();
		boolean result = dao.RegistraionBodyTemp(bodyTempDateRegist);
		return result;
	}
}
