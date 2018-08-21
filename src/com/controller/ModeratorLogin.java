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

import com.bean.ModeratorBean;
import com.dao.ModeratorDao;


@WebServlet("/ModeratorLogin")
public class ModeratorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pwd=request.getParameter("password");
		ModeratorBean mb=new ModeratorBean(email,pwd);
		boolean status=ModeratorDao.login(mb);
		HttpSession session=request.getSession(true);
		//PrintWriter out=response.getWriter();
		//out.println(status);
		//out.println(email+"  "+pwd);
		String target="";
		if(status){
			session.setAttribute("email", email);
			request.setAttribute("msg", "You are successfully Logged in as a moderator");
			target="moderator.jsp";
		}
		else{
			request.setAttribute("error", "Invalid Credentials");
			target="error.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

}
