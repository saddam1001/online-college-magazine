package com.bean;

public class FeedBean {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String feed;
	public FeedBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeedBean(String fname, String lname, String email, String feed) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.feed = feed;
	}
	public FeedBean(int id,String fname, String lname, String email, String feed) {
		super();
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.feed = feed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeed() {
		return feed;
	}
	public void setFeed(String feed) {
		this.feed = feed;
	}
}
