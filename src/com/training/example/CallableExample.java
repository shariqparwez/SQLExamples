package com.training.example;
import java.sql.*;
public class CallableExample {
	public static void main(String[] args){
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Connection con = DriverManager.getConnection(url,"SHARIQ","Oracle@1234");
			System.out.println(con);
			CallableStatement stmt = con.prepareCall("call updatePhoneNumber(?,?)");
			
			stmt.setInt(1, 102);
			stmt.setLong(2, 7411264114L);
			
			stmt.execute();
			System.out.println("Thanks for updating phone Number");
			
		} catch(Exception e){
			e.printStackTrace(); //hj
		}
	}
}
