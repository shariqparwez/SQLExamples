package com.training.apps;
import java.util.List;

import com.training.daos.CustomerDAO;
import com.training.entity.Customer;
import com.training.utils.*;

public class SQLApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SqlConnection sql = new SqlConnection();
		//sql.getOracleConnection();
		//System.out.println(SqlConnection.getOracleConnection());
		
		
		/*Customer cust = new Customer(102,"Shalini","shaliniverma@outlook.com",8078967321L);
		CustomerDAO dao = new CustomerDAO();
		int rowAdded = dao.add(cust);
		System.out.println(rowAdded + ":= Row[s] Added");*/
		
		/*CustomerDAO dao2 = new CustomerDAO();
		Customer cust2 = new Customer();
		
		cust2 = dao2.find(101);
		System.out.println(cust2.showCustomer());*/
		
		CustomerDAO dao3 = new CustomerDAO();
		int rows = dao3.update(101, 9852270473L);
		System.out.println("Rows Updated");
		
		List<Customer> custList = dao3.findAll();
		System.out.println(custList);
		
		
	}

}
