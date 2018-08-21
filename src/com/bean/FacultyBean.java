package com.bean;

import java.io.InputStream;

public class FacultyBean {
	private int id;
	private String name;
	private InputStream is;
	private String email;
	private String password;
	private long mobile;
	private String dob;
	
	public FacultyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FacultyBean(String email,String password) {
		super();
		this.email=email;
		this.password=password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public FacultyBean(String name,InputStream is,String email, String password,
			long mobile,String dob){
		this.name=name;
		this.is=is;
		this.email=email;
		this.password=password;
		this.mobile=mobile;
		this.dob=dob;
	}
	public FacultyBean(int id,String name, InputStream is, String email, String password, long mobile, String dob) {
		super();
		this.id=id;
		this.name = name;
		this.is = is;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
}
