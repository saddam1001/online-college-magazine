package com.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentBean;
import com.db.DBConnection;

public class StudentDAO {
	//name, image, email, password, mobile,dob
	public static int memberRegistration(StudentBean m){
		int inserted = 0;
		String sql="insert into new_student(name,image,email,"
				+ "password,mobile,dob) values(?,?,?,?,?,?)";
		
		try {
			
			Connection con=DBConnection.getConnection();
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1, m.getName());
			pst.setBlob(2, m.getIs());
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

	public static boolean Login(String email,String password) {
		boolean status=false; 
		
		String sql="select email,password from new_student where email=? and password=?";
		try{
			Connection con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,email);
			pst.setString(2, password);
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
	
	public static List<StudentBean> getAllStudentInfo(){
		List<StudentBean> list=new ArrayList<StudentBean>();
		Connection con=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(
					"select * from new_student"
					);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				
				int id=rs.getInt("student_id");
				String name=rs.getString("name");
				Blob blob=rs.getBlob("image");
				String email=rs.getString("email");
				String pwd=rs.getString("password");
				Long mobile=rs.getLong("mobile");
				java.sql.Date sdate=rs.getDate("dob");
				String dob=sdf.format(sdate);
				
				StudentBean student = new StudentBean();
				student.setId(id);
				student.setName(name);
				student.setBlob(blob);
				student.setEmail(email);
				student.setPassword(pwd);
				student.setMobile(mobile);
				student.setDob(dob);
				list.add(student);
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	} 
	public static byte[] viewImage(String email){
		byte[] bytes=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=DBConnection.getConnection();
			pst=con.prepareStatement("select image from new_student where email=?");
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				//blob=rs.getBlob("image");
				 bytes=rs.getBytes("image");
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return bytes;
	}

	public static StudentBean viewProfile(String mail) {
		StudentBean profile=null;
		Connection con=null;
		PreparedStatement pst=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String sql="select * from new_student where email=?";
		try {
			con=DBConnection.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1, mail);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				int id=rs.getInt("student_id");
				String name=rs.getString("name");
				Blob blob=rs.getBlob("image");
				String email=rs.getString("email");
				String pwd=rs.getString("password");
				Long mobile=rs.getLong("mobile");
				java.sql.Date sdate=rs.getDate("dob");
				String dob=sdf.format(sdate);
				byte[] imageData=blob.getBytes(1, (int)blob.length());
				InputStream is=blob.getBinaryStream();
				profile = new StudentBean();
				profile.setIs(is);
				profile.setId(id);
				profile.setName(name);
				profile.setBlob(blob);
				profile.setEmail(email);
				profile.setPassword(pwd);
				profile.setMobile(mobile);
				profile.setDob(dob);
				profile.setImageData(imageData);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return profile;
	}
	public static int update(StudentBean sb){
		int status=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			con=DBConnection.getConnection();
			pst=con.prepareStatement(
					"update new_student set name=?,image=?,email=?,"
					+ "password=?,mobile=?,dob=? where student_id=?"
					);
			pst.setString(1, sb.getName());
			pst.setBinaryStream(2, sb.getIs());
			pst.setString(3, sb.getEmail());
			pst.setString(4, sb.getPassword());
			pst.setLong(5, sb.getMobile());
			pst.setString(6, sb.getDob());
			pst.setInt(7, sb.getId());
			status=pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

}
