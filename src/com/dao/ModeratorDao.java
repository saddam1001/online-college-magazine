package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.ModeratorBean;
import com.bean.StudentBean;
import com.db.DBConnection;

public class ModeratorDao {

	public static boolean login(ModeratorBean mb){
		boolean status=false;
		Connection con=null;
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select email,password"
					+ " from moderator where email=? and password=?");
			pst.setString(1, mb.getEmail());
			pst.setString(2, mb.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return status;
	}

	public static int addModerator(ModeratorBean mb) {
		int added = 0;
		Connection con=null;
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into "
					+ "moderator(email,password) values(?,?)");
			pst.setString(1, mb.getEmail());
			pst.setString(2, mb.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				added=1;
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return added;
	}

	public static ArrayList<ModeratorBean> viewAllModerators() {
		ArrayList<ModeratorBean> list=new ArrayList<ModeratorBean>();
		Connection con=null;
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from moderator order by id");
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String email=rs.getString("email");
				String password=rs.getString("password");
				ModeratorBean mb=new ModeratorBean();
				mb.setId(id);
				mb.setEmail(email);
				mb.setPassword(password);
				
				list.add(mb);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static ModeratorBean viewModeratorById(int id){
		ModeratorBean mb=null;
		Connection con=null;
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select * "
					+ "from moderator where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				mb=new ModeratorBean();
				mb.setId(rs.getInt("id"));
				mb.setEmail(rs.getString("email"));
				mb.setPassword(rs.getString("password"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mb;
	}

	public static int updateModerator(ModeratorBean mb) {
		int updated=0;
		Connection con=null;
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(
					"update moderator set email=?, password=? where id=?"
					);
			pst.setString(1, mb.getEmail());
			pst.setString(2, mb.getPassword());
			pst.setInt(3, mb.getId());
			updated=pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}
}
