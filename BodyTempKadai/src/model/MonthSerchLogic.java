package model;

import java.util.List;

import dao.BodyTempGetDAO;

public class MonthSerchLogic {
	public List<BodyTempTebleDate> getDate(String userid,String date){
		BodyTempGetDAO dao = new BodyTempGetDAO();
		List<BodyTempTebleDate> resultList = dao.getTempData(userid, date);
		return resultList;
	}
}
