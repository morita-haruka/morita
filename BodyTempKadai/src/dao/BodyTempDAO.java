package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Result;

public class BodyTempDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/bodytemp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Result> findAll(String date){
		List<Result> resultList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER,DB_PASS)){
			String sql = "select * from bodytemp where tempdate like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,"%" + date + "%");

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				double bodytemp = rs.getInt("BDTEMP");
				String tempdate = rs.getString("TEMPDATE");
				Result result = new Result(bodytemp,tempdate);
				resultList.add(result);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return resultList;
	}

	public boolean findbyRegistration(double bodyTemp) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "insert into BODYTEMP (BDTEMP) VALUES(?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setDouble(1, bodyTemp);

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
