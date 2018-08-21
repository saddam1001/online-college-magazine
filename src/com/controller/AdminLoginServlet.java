package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.dao.AdminDao;
import com.dao.StudentDAO;;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
     
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String password =request.getParameter("password");
			
		HttpSession session = request.getSession(true);
		String target="";
		AdminBean admin=new AdminBean(uname,password);

	boolean status=AdminDao.adminLogin(admin);	
	
	
	if(status){
		session.setAttribute("UserName", uname);
		request.setAttribute("msg", "Welcome, you are successfully logged in.");
		//response.sendRedirect("success.jsp");
		target="/admin.jsp";
	}
	else
	{
		request.setAttribute("error", "Please provide valid credentials!!!");
		//response.sendRedirect("error.jsp");
		target="/error.jsp";
	}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
		
	}

}
