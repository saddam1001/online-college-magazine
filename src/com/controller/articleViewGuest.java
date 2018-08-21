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

import com.bean.ArticleBean;
import com.dao.Display;


@WebServlet("/articleViewGuest")
public class articleViewGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ArticleBean> list=Display.viewArticles();
		
		String target=null;
		
		if(list!=null){
			//out.println("I have something");
			request.setAttribute("result", list);
			target="/result.jsp";
		}
		
		else{
			request.setAttribute("msg", "No info available right now!!!");
			target="/fail.jsp";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

}
