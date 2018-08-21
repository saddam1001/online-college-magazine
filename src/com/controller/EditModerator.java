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


@WebServlet("/EditModerator")
public class EditModerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		ModeratorBean mb =ModeratorDao.viewModeratorById(id);
		String target="";
		if(mb!=null){
			request.setAttribute("mb", mb);
			target="/edit_moderator.jsp";
		}
		else{
			request.setAttribute("error", "Unable to edit");
			target="/admin.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
	}


}
