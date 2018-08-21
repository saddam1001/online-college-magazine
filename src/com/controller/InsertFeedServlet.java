package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.FeedBean;
import com.dao.FeedDao;


@WebServlet("/InsertFeedServlet")
public class InsertFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String feedback=request.getParameter("feedback");
		PrintWriter out=response.getWriter();
		
		FeedBean fb=new FeedBean(fname,lname,email,feedback);
		String target="/index.jsp";
		int status=FeedDao.insertFeed(fb);
		if(status != 0){
			//out.println("<body><h3>your feedback has been posted successfully</h3></body>");
			request.setAttribute("msg", "your feedback has been posted successfully");
		}
		else{
			//out.println("<body><h3>feedback posting is failed</h3></body>");
			request.setAttribute("msg", "feedback posting is failed");
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
	}

}
