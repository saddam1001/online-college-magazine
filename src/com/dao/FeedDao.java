package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.FeedBean;
import com.bean.StudentBean;
import com.db.DBConnection;

public class FeedDao {

	public static int insertFeed(FeedBean fb){
		int status=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=DBConnection.getConnection();
			pst=con.prepareStatement("insert into feedback(firstname,lastname,email,feed) values(?,?,?,?)");
			pst.setString(1, fb.getFname());
			pst.setString(2, fb.getLname());
			pst.setString(3, fb.getEmail());
			pst.setString(4, fb.getFeed());
			status=pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	public static List<FeedBean> viewAllFeeds(){
		List<FeedBean> list=new ArrayList<FeedBean>();
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=DBConnection.getConnection();
			pst=con.prepareStatement("select * from feedback order by id");
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(4);
				String feed=rs.getString(5);
				
				FeedBean fb=new FeedBean();
				fb.setId(id);
				fb.setFname(fname);
				fb.setLname(lname);
				fb.setEmail(email);
				fb.setFeed(feed);
				
				
				
				list.add(fb);
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
