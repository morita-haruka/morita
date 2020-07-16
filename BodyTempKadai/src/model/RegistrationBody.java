package model;

import dao.BodyTempDAO;
public class RegistrationBody {
	public boolean execute(double bodyTemp) {
		BodyTempDAO dao = new BodyTempDAO();
		boolean result = dao.findbyRegistration(bodyTemp);
		return result;
	}
}
