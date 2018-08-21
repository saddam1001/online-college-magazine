package com.controller;

import java.io.IOException;
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


@WebServlet("/articleViewServlet")
public class articleViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List<ArticleBean> list=Display.viewArticles();
		//PrintWriter out=response.getWriter();
		//out.print(session);
		
		String target=null;
		if(list != null){
			request.setAttribute("result", list);
			target="/admin_article.jsp";
		}
		
		else{
			request.setAttribute("msg", "No info available right now!!!");
			target="/fail.jsp";
		
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}

}
