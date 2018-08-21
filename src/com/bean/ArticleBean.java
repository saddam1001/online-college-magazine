package com.bean;

import java.io.InputStream;

public class ArticleBean {
	//artname,arttype,cattype,catname,
	//postdate,is,extension
	private int id;
	private String artname;
	private String arttype;
	private String cattype;
	private String catname;
	private String postdate;
	private InputStream is;
	private String extension;
	
	public ArticleBean(){
		super();
	}
	
	public ArticleBean(String artname, String arttype, String cattype, String catname, String postdate, InputStream is,
			String extension) {
		super();
		this.id = id;
		this.artname = artname;
		this.arttype = arttype;
		this.cattype = cattype;
		this.catname = catname;
		this.postdate = postdate;
		this.is = is;
		this.extension = extension;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtname() {
		return artname;
	}

	public void setArtname(String artname) {
		this.artname = artname;
	}

	public String getArttype() {
		return arttype;
	}

	public void setArttype(String arttype) {
		this.arttype = arttype;
	}

	public String getCattype() {
		return cattype;
	}

	public void setCattype(String cattype) {
		this.cattype = cattype;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
