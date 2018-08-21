package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.dao.StudentDAO;


@WebServlet("/viewStudentServlet")
public class viewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StudentBean> list=StudentDAO.getAllStudentInfo();
		
		//PrintWriter out=response.getWriter();
		//out.println(list);
		String target="";
		if(list!=null){
			request.setAttribute("student", list);
			target="/viewstudent.jsp";
		}
		else{
			request.setAttribute("error", "No student info available");
			target="/error.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
	}

}
