package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ModeratorBean;
import com.dao.ModeratorDao;


@WebServlet("/UpdateModerator")
public class UpdateModerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String email=request.getParameter("email");
		String pwd=request.getParameter("password");
		ModeratorBean mb=new ModeratorBean(id,email,pwd);
		int updated=ModeratorDao.updateModerator(mb);
		String target="";
		PrintWriter out=response.getWriter();
		if(updated!=0){
			//out.println("<body><h3>Moderator with email "+email+" is updated</h3></body>");
			request.setAttribute("msg", "moderator with email "+email+" is updated");
			target="/admin.jsp";
		}
		else{
			//out.println("<body><h3>Moderator is not updated</h3></body>");
			request.setAttribute("msg", "moderator is not updated");
			target="/admin.jsp";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
	}

}
