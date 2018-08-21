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

import com.bean.FacultyBean;
import com.dao.FacultyDAO;;


@WebServlet("/FacultyLoginServlet")
public class FacultyLoginServlet extends HttpServlet {
     
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password =request.getParameter("password");
			
		HttpSession session = request.getSession(true);
		String target="";
		FacultyBean faculty=new FacultyBean(email,password);

	boolean status=FacultyDAO.Login(faculty);	
	
	
	if(status){
		session.setAttribute("UserEmail", email);
		request.setAttribute("msg", "Welcome, you are successfully logged in.");
		//response.sendRedirect("success.jsp");
		target="/faculty_success.jsp";
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
