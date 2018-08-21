package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.FeedBean;
import com.dao.FeedDao;

@WebServlet("/ViewFeed")
public class ViewFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String target=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FeedBean> fb=FeedDao.viewAllFeeds();
		if(fb!=null){
			request.setAttribute("feeds", fb);
			target="/viewfeed.jsp";
		}
		else{
			request.setAttribute("error", "No information available");
			target="/error.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
