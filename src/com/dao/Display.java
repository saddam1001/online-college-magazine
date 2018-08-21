package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.ArticleBean;
import com.db.DBConnection;
public class Display {

	public static List<ArticleBean> viewArticles(){
		List<ArticleBean> list=new ArrayList<ArticleBean>();
		Connection con=null;
		String sql="select * from article";
		
		try {
			con=DBConnection.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
			
				int id=rs.getInt("id");
				String articleName=rs.getString("ArticleName");
				String articleType=rs.getString("ArticleType");
				String categoryType=rs.getString("CategoryType");
				String categoryName=rs.getString("CategoryName");
				String postDate=rs.getString("PostDate");
				
				ArticleBean ar=new ArticleBean();
				ar.setId(id);
				ar.setArtname(articleName);
				ar.setArttype(articleType);
				ar.setCattype(categoryType);
				ar.setCatname(categoryName);
				ar.setPostdate(postDate);
				list.add(ar);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
