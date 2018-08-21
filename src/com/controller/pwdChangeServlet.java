package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;


@WebServlet("/pwdChangeServlet")
public class pwdChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpwd=request.getParameter("oldpwd");
		String newpwd=request.getParameter("newpwd");
		String target="";
		
		int status=AdminDao.checkPwd(oldpwd,newpwd);
		if(status!=0){
			request.setAttribute("status", "admin your password is changed successfully");
			target="/admin.jsp";
		}
		else{
			request.setAttribute("status", "password is not changed!!! ");
			target="/admin.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
	}

}
