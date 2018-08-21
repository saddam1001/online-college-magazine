package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.StudentBean;
import com.dao.StudentDAO;

@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String email=(String)session.getAttribute("email_id");
		String target=null;
		StudentBean profile=StudentDAO.viewProfile(email);
		//PrintWriter out=response.getWriter();
		//out.println(email);
		//out.println(profile);
		
		if(profile != null){
			request.setAttribute("profile", profile);
			target="/student_profile.jsp";
		}
		else{
			request.setAttribute("error", "No profile info available");
			target="/error.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
		
	}

}
