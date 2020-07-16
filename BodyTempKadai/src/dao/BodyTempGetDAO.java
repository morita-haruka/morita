package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BodyTempTebleDate;

public class BodyTempGetDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/bodytemp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<BodyTempTebleDate> getTempData(String userid,String date){
		List<BodyTempTebleDate> resultList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER,DB_PASS)){
			String sql = "select * from bodytemp where tempdate like ? and userid=? order by tempdate asc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,"%" + date + "%");
			pStmt.setString(2, userid);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				double bodytemp = rs.getDouble("bdtemp");
				String tempdate = rs.getString("TEMPDATE");
				String symptom = rs.getString("SYMPTOM");
				String place = rs.getString("PLACE");
				String memo = rs.getString("MEMO");
				String userId = rs.getString("USERID");
				BodyTempTebleDate bodyTempTebleDate = new BodyTempTebleDate(tempdate, symptom, place, memo, bodytemp, userId);
				resultList.add(bodyTempTebleDate);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return resultList;
	}
}
