package com.easylearnjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.easylearnjava.exception.ServiceException;
import com.easylearnjava.util.DBConnection;


/**
 *This class interacts with the database and fetches the password and returns to LoginService class.
 */
public class LoginDao {

	public String getUserPassword(String userName) {

		Connection con;
		PreparedStatement stmt;
		DBConnection dbConn = new DBConnection();
		String passwordFromDB = null;

		try {
			con = dbConn.getDBConnection();

			String sql = "SELECT user_password FROM  USER where user_name = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);

			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				passwordFromDB = res.getString("USER_PASSWORD");
			}
			dbConn.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException("global.exception.message");
		}
		return passwordFromDB;
	}

}
