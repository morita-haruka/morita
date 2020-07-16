package model;

import java.io.Serializable;

public class BodyTempDateRegist implements Serializable{
	private double bodyTemp;
	private String symptom;
	private String place;
	private String memo;
	private String userid;

	public BodyTempDateRegist(double bodytemp,String symptom,String place,String memo,String userid) {
		this.symptom = symptom;
		this.place = place;
		this.memo = memo;
		this.bodyTemp = bodytemp;
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public String getSymptom() {
		return symptom;
	}

	public String getPlace() {
		return place;
	}

	public String getMemo() {
		return memo;
	}

	public double getBodyTemp() {
		return bodyTemp;
	}
}
