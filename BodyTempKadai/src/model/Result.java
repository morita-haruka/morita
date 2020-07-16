package model;

import java.io.Serializable;

public class Result implements Serializable{
	private double bodyTemp;
	private String date;

	public Result() {}
	public Result(double bodytemp,String date) {
		this.bodyTemp = bodytemp;
		this.date = date;
	}
	public double getBodyTemp() {
		return bodyTemp;
	}

	public String getDate() {
		return date;
	}

}
