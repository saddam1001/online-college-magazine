package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.AdminBean;
import com.db.DBConnection;

public class AdminDao {

	public static boolean adminLogin(AdminBean admin){
		boolean status=false;
		
		String sql="select username,password from admin"
				+ " where username=? and password=?";
		
		Connection con=null;
		try {
			
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, admin.getUname());
			pst.setString(2, admin.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){status=true;}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int checkPwd(String oldpwd,String newpwd){
		int status = 0;
		Connection con=null;
		String sql="select password from admin";
		PreparedStatement pst=null;
		try {
			
			con=DBConnection.getConnection();
			pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				String pwd=rs.getString("password");
				if(pwd==oldpwd||pwd.equals(oldpwd)){
					pst=con.prepareStatement("update admin set password=? where username='admin'");
					pst.setString(1, newpwd);
					status=pst.executeUpdate();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return status;
	}
	
}
