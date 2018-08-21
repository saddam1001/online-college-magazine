package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.FacultyBean;
import com.db.DBConnection;

public class FacultyDAO {
	//name, image, email, password, mobile,dob
	public static int facultyRegistration(FacultyBean m){
		int inserted = 0;
		String sql="insert into faculty(name,image,email,"
				+ "password,mobile,dob) values(?,?,?,?,?,?)";
		
		try {
			
			Connection con=DBConnection.getConnection();
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1, m.getName());
			pst.setBinaryStream(2, m.getIs());
			pst.setString(3, m.getEmail());
			pst.setString(4, m.getPassword());
			pst.setLong(5, m.getMobile());
			
			String date=m.getDob();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udate=sdf.parse(date);
			long l=udate.getTime();
			java.sql.Date sdate=new java.sql.Date(l);
			
			pst.setDate(6, sdate);
			inserted=pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return inserted;
	}

	public static boolean Login(FacultyBean f) {
		boolean status=false; 
		
		String sql="select email,password from faculty where email=? and password=?";
		try{
			Connection con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,f.getEmail());
			pst.setString(2, f.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{status= true;}
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return status;
		
	}
	
	public static List<FacultyBean> getAllFacultyInfo(){
		List<FacultyBean> list=new ArrayList<FacultyBean>();
		Connection con=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(
					"select * from faculty"
					);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				
				int id=rs.getInt("id");
				String name=rs.getString("name");
				InputStream is=rs.getBinaryStream("image");
				String email=rs.getString("email");
				String pwd=rs.getString("password");
				Long mobile=rs.getLong("mobile");
				java.sql.Date sdate=rs.getDate("dob");
				String dob=sdf.format(sdate);
				
				FacultyBean faculty = new FacultyBean();
				faculty.setId(id);
				faculty.setName(name);
				faculty.setIs(is);
				faculty.setEmail(email);
				faculty.setPassword(pwd);
				faculty.setMobile(mobile);
				faculty.setDob(dob);
				list.add(faculty);
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
