package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.StudentBean;
import com.dao.StudentDAO;


@WebServlet("/EditStudent")
@MultipartConfig(maxFileSize = 1024*1024*16)
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		
		Part filePart=request.getPart("image");
		
		InputStream is=filePart.getInputStream();
		
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		long mobile=Long.parseLong(request.getParameter("number"));
		String dob=request.getParameter("dob");
		
		PrintWriter out = response.getWriter();
		String target="";
		StudentBean m=new StudentBean(id,name,is,email,password,mobile,dob);
		int status=StudentDAO.update(m);
		if(status!=0){
			request.setAttribute("status", "your profile is updated");
			//out.println("your profile is updated");
			//response.sendRedirect("success.jsp");
			target="/success.jsp";
		}
		else{
			request.setAttribute("error", "Failed to Update Profile");
			//out.print("your profile is not updated");
			//request.setAttribute("error", ""your profile is not updated");
			//response.sendRedirect("error.jsp");
			target="/error.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
	}

	}


