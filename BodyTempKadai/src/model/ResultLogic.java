package model;

import java.util.List;

import dao.BodyTempDAO;

public class ResultLogic {
	public List<Result> execute(String date,String userid){
		BodyTempDAO dao = new BodyTempDAO();
		List<Result> resultList = dao.findAll(date);
		return resultList;
	}

}
