package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ModeratorBean;
import com.dao.ModeratorDao;


@WebServlet("/ViewModerators")
public class ViewModerators extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ModeratorBean> list=ModeratorDao.viewAllModerators();
		
		String target="";
		if(list!=null){
			request.setAttribute("list", list);
			target="/view_moderator.jsp";
		}
		else{
			request.setAttribute("msg", "moderators info is not available");
			target="/error.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
	}


}
