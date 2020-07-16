package model;

import java.io.Serializable;

public class BodyTempTebleDate implements Serializable{
	private String date;
	private String symptom;
	private String place;
	private String memo;
	private double bodyTemp;
	private String userid;

	public BodyTempTebleDate(){}

	public BodyTempTebleDate(String date,String symptom,String place,String memo,double bodytemp,String userid) {
		this.date = date;
		this.symptom = symptom;
		this.place = place;
		this.memo = memo;
		this.bodyTemp = bodytemp;
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public String getDate() {
		return date;
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
