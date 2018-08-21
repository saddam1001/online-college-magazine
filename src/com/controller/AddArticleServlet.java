package com.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.ArticleBean;
import com.dao.ArticleDao;

/**
 * Servlet implementation class AddArticleServlet
 */
@WebServlet("/AddArticleServlet")
@MultipartConfig( maxFileSize = 1024*1024*15 )
public class AddArticleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String artname=request.getParameter("artname");
		String arttype=request.getParameter("arttype");
		String cattype=request.getParameter("cattype");
		String catname=request.getParameter("catname");
		String postdate=request.getParameter("postdate");
		Part artdesc=request.getPart("artdesc");
		String extension=request.getParameter("extension");
		
		InputStream is=artdesc.getInputStream();
		PrintWriter out= response.getWriter();
		
	/*	String contenttype=artdesc.getContentType();
		String dname=artdesc.getName();
		long l=artdesc.getSize();
		String fname=artdesc.getSubmittedFileName();
		
		
		out.println("<html><body>"+artname+"<br>");
		out.println(arttype+"<br>");
		out.println(cattype+"<br>");
		out.println(catname+"<br>");
		out.println(postdate+"<br>");
		out.println(artdesc+"<br>");
		out.println(extension+"<br>");
		out.println(is+"<br>");
		out.println("Contenttype "+contenttype+"<br>");
		out.println("dname "+dname+"<br>");
		out.println("size "+l+"<br>");
		out.println(fname+"</body></html>");
		*/
		ArticleBean ar= new ArticleBean(artname,arttype,cattype,catname,
				postdate,is,extension);
		int status=ArticleDao.insertArticle(ar);
		String target="";
		if(status!=0){
			request.setAttribute("msg", "Article is posted successfully");
			target="/index.jsp";
		}
		else{
			request.setAttribute("error", "Article posting failed");
			target="/error.jsp";
		}
		//target="/articleViewServlet";
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
				
	}

}
