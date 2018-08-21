package com.bean;

import java.io.InputStream;
import java.sql.Blob;

public class StudentBean {
	private int id;
	private String name;
	private InputStream is;
	private Blob blob; 
	private String email;
	private String password;
	private long mobile;
	private String dob;
	private byte[] imageData;
	
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public StudentBean(String name,InputStream is,String email, String password,
			long mobile,String dob){
		this.name=name;
		this.is=is;
		this.email=email;
		this.password=password;
		this.mobile=mobile;
		this.dob=dob;
	}
	public StudentBean(int id,String name, InputStream is, String email, String password, long mobile, String dob) {
		super();
		this.id=id;
		this.name = name;
		this.is = is;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dob = dob;
	}
	public StudentBean(int id,String name, Blob blob, String email, String password, long mobile, String dob) {
		super();
		this.id=id;
		this.name = name;
		this.blob = blob;
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

	public Blob getBlob() {
		return blob;
	}

	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	
	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public StudentBean(int id, String name, InputStream is, Blob blob, String email, String password, long mobile,
			String dob, byte[] imageData) {
		super();
		this.id = id;
		this.name = name;
		this.is = is;
		this.blob = blob;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dob = dob;
		this.imageData = imageData;
	}
	
}
