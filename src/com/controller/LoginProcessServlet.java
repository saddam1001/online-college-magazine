package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDAO;


@WebServlet("/LoginProcessServlet")
public class LoginProcessServlet extends HttpServlet {
     
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		
		String target="";

	boolean status=StudentDAO.Login(email,password);	
	
	if(status){
		session.setAttribute("email_id", email);
		request.setAttribute("msg", "Welcome, you are successfully logged in.");
		//response.sendRedirect("success.jsp");
		target="/student.jsp";
	}
	else
	{
		request.setAttribute("error", "Please provide valid credentials!!!");
		//response.sendRedirect("error.jsp");
		target="/error.jsp";
	}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

}
