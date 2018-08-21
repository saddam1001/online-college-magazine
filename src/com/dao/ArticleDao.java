package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import com.bean.ArticleBean;
import com.db.DBConnection;

public class ArticleDao {

	public static int insertArticle(ArticleBean arb){
		int inserted=0;
		Connection con=null;
		String sql="insert into article("
				+ "ArticleName,ArticleType,CategoryType,CategoryName,PostDate,"
				+ "ArticleDesc,FileType)"
				+ "values(?,?,?,?,?,?,?)";
		try {
			
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1, arb.getArtname());
			pst.setString(2, arb.getArttype());
			pst.setString(3, arb.getCattype());
			pst.setString(4, arb.getCatname());
			
			String date=arb.getPostdate();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udate=sdf.parse(date);
			long l=udate.getTime();
			java.sql.Date sdate=new java.sql.Date(l); 
			
			
			pst.setDate(5, sdate);
			
			pst.setBinaryStream(6, arb.getIs());
			pst.setString(7, arb.getExtension());
			
			inserted=pst.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inserted;
	}

	public static int delete(int id) {
		int status=0;
		Connection con=null;
		
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("delete from article where id=?");
			pst.setInt(1, id);
			status=pst.executeUpdate();
			con.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
}
