package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.UserInfomation;

public class AcountDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/bodytemp";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean RegistraionUser(UserInfomation userInfomation) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "insert into userinfo (username,mailadress,password) VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if(userInfomation.getName() != "" && userInfomation.getMailAdress() != "" && userInfomation.getPassWord() != "") {
				pStmt.setString(1, userInfomation.getName());
				pStmt.setString(2, userInfomation.getMailAdress());
				pStmt.setString(3, userInfomation.getPassWord());
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

	public String findByLogin(Login login) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT mailadress,password,userid FROM USERINFO where mailadress = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, login.getMailAdress());
			pStmt.setString(2, login.getPassWord());

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String userid = rs.getString("userid");
				return userid;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
