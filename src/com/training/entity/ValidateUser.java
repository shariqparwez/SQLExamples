package com.training.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.training.utils.*;

public class ValidateUser {
	private Connection con;
	
	public ValidateUser() {
		super();
		// TODO Auto-generated constructor stub
		con = SqlConnection.getOracleConnection();
	}

	public boolean Validate(User usr){
		String sql = "SELECT * FROM SAPIENTUSER WHERE username=? AND password=?";
		boolean check = false;
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usr.getUserName());
			pstmt.setString(2, usr.getPassWord());
			ResultSet rs = pstmt.executeQuery();
			check = rs.next();
		} catch (Exception e){
			e.printStackTrace();
		}
		return check;
	}
}
