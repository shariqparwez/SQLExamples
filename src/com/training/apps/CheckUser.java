package com.training.apps;
import com.training.entity.*;

public class CheckUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1 = new User("SHARIQ","sapient","admin");
		User user2 = new User("Vaibhav","lenovo","user");
		
		ValidateUser validate = new ValidateUser();
		System.out.println(validate.Validate(user1));
		System.out.println(validate.Validate(user2));
	}

}
