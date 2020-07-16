package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BodyTempDateRegist;

public class BodyTempRegisterDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/bodytemp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean RegistraionBodyTemp(BodyTempDateRegist bodyTempDateRegist) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(date);

			String sql2 = "select * from bodytemp where tempdate like ? and userid=? order by tempdate asc";
			String sql = "insert into bodytemp (bdtemp,symptom,place,memo,userid) VALUES(?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			pStmt2.setString(1,"%" + strDate + "%");
			pStmt2.setString(2, bodyTempDateRegist.getUserid());
			ResultSet rs = pStmt2.executeQuery();
			int i = 0;
			while(rs.next()) {
				i = 1;
			}
			if(bodyTempDateRegist.getBodyTemp() != 0 && bodyTempDateRegist.getSymptom() != "" && bodyTempDateRegist.getPlace() != "" && bodyTempDateRegist.getMemo() != "" && i != 1) {
				pStmt.setDouble(1, bodyTempDateRegist.getBodyTemp());
				pStmt.setString(2, bodyTempDateRegist.getSymptom());
				pStmt.setString(3, bodyTempDateRegist.getPlace());
				pStmt.setString(4, bodyTempDateRegist.getMemo());
				pStmt.setString(5, bodyTempDateRegist.getUserid());
			}
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
