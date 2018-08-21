package com.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBConnection;

import oracle.sql.BLOB;


@WebServlet("/DisplayFileServlet")
public class DisplayFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out=response.getWriter();
		ServletOutputStream sos=response.getOutputStream();
		int id=Integer.parseInt(request.getParameter("id"));
		//out.println(id);
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String fname=null;
		String ftype=null;
		Blob blob=null;
		
		try {
			con=DBConnection.getConnection();
			pst=con.prepareStatement("select ArticleName,ArticleDesc,FileType from article where id=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				//sos.write(rs.getBytes("ArticleDesc"));
				fname=rs.getString("ArticleName");
				ftype=rs.getString("FileType");
				blob=rs.getBlob("ArticleDesc");
				
			}
			
			if(ftype.equals(".txt"))
			{
			response.setContentType("text/html");	
			response.addHeader("Content-Disposition", "attachment; filename="+fname+".txt");
			int blobLength=(int) blob.length();
			byte[] blobAsBytes=blob.getBytes(1, blobLength);
			sos.write(blobAsBytes);
			}
			if(ftype.equals(".doc"))
			{
			response.setContentType("application/msword");	
			response.addHeader("Content-Disposition", "attachment; filename="+fname+".doc");
			int blobLength=(int) blob.length();
			byte[] blobAsBytes=blob.getBytes(1, blobLength);
			sos.write(blobAsBytes);
			}

			if(ftype.equals(".pdf"))
			{
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename="+fname+".pdf");
			int blobLength=(int) blob.length();
			byte[] blobAsBytes=blob.getBytes(1, blobLength);
			sos.write(blobAsBytes);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
