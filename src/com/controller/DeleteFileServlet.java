package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ArticleDao;

@WebServlet("/DeleteFileServlet")
public class DeleteFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		int status=ArticleDao.delete(id);
		String target="";
		if(status != 0){
			PrintWriter out=response.getWriter();
			out.println("deleted successfully");
			
		}
		target="/articleViewServlet";
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

}
