package com.training.entity;

public class User {
	private String userName;
	private String passWord;
	private String role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String userName, String passWord, String role) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}


	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public String getRole() {
		return role;
	}
	
	
	
}
