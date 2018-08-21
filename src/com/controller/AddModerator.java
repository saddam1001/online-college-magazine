package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ModeratorBean;
import com.dao.ModeratorDao;

@WebServlet("/AddModerator")
public class AddModerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pwd=request.getParameter("password");
		ModeratorBean mb=new ModeratorBean(email,pwd);
		int added=ModeratorDao.addModerator(mb);
		String target="";
		if(added==1){
			request.setAttribute("added",email+" is added as new moderator");
			target="/admin.jsp";
		}
		else{
			request.setAttribute("added", "moderator is not added");
			target="/admin.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
	}

}
