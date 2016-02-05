package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.training.ifaces.DAO;
import com.training.entity.*;
import com.training.utils.*;

public class CustomerDAO implements DAO<Customer> {
	private Connection con;
	public CustomerDAO(Connection con){
		super();
		this.con = con;
	}
	public CustomerDAO() {
		super();
		// TODO Auto-generated constructor stub
		con = SqlConnection.getOracleConnection();
		
	}

	@Override
	public int add(Customer t) {
		// TODO Auto-generated method stub
		
		String sql = "insert into CUSTOMER values(?,?,?,?)";
		int rowAdded = 0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getCustomerId());
			pstmt.setString(2, t.getCustomerName());
			pstmt.setString(3, t.getEmail_Id());
			pstmt.setLong(4, t.getHandPhone());
			
			rowAdded = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowAdded;
	}

	@Override
	public Customer find(int key) {
		// TODO Auto-generated method stub
		String sql = "select * from CUSTOMER where customerId=?";
		Customer cust = null;
		try{
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(sql);
			//pstmt.set
			pstmt.setInt(1, key);
			
			//ResultSet rs = pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			
			//while loop
			
			while(rs.next()){
				/*String customerName = rs.getString("customerName");
				String email_Id = rs.getString("email_Id");
				long handPhone = rs.getLong("handPhone");
				
				cust = new Customer(key,customerName,email_Id,handPhone);*/
				cust=getCustomer(rs);
				
				
			}
			//set to constructor
		} catch (Exception e){
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Customer> custList = new ArrayList<Customer>();
		String sql = "SELECT * FROM customer";
		//Customer cust = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Customer cust=getCustomer(rs);
				custList.add(cust);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return custList;
	}

	@Override
	public int update(int key, long handPhone) {
		// TODO Auto-generated method stub
		String sql = "UPDATE customer SET handPhone = ? WHERE customerId = ?";
		Customer cust = null;
		int rowUpdated = 0;
		try{
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(sql);
			//pstmt.set
			pstmt.setInt(2, key);
			pstmt.setLong(1, handPhone);
			
			//ResultSet rs = pstmt.executeQuery();
			rowUpdated = pstmt.executeUpdate();
			
			//set to constructor
		} catch (Exception e){
			e.printStackTrace();
		}
		return rowUpdated;
	}

	@Override
	public int delete(int key) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM customer WHERE customerId = ?";
		//Customer cust = null;
		int rowDeleted = 0;
		try{
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(sql);
			//pstmt.set
			pstmt.setInt(1, key);
			
			//ResultSet rs = pstmt.executeQuery();
			rowDeleted = pstmt.executeUpdate();
			
			//set to constructor
		} catch (Exception e){
			e.printStackTrace();
		}
		return rowDeleted;
	}
	private Customer getCustomer(ResultSet rs){
		Customer cust = null;
		try{
			int customerId = rs.getInt("CustomerId");
			String customerName = rs.getString("customerName");
			String email_Id = rs.getString("email_Id");
			long handPhone = rs.getLong("handPhone");
			
			cust = new Customer(customerId,customerName,email_Id,handPhone);

		} catch(Exception e){
			e.printStackTrace();
		}
		return cust;
	}
}
