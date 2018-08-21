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

import com.dao.FacultyDAO;
import com.bean.FacultyBean;

@WebServlet("/FacultyRegServlet")
@MultipartConfig(maxFileSize = 1024*1024*16)
public class FacultyRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		
		Part filePart=request.getPart("image");
		
		InputStream is=filePart.getInputStream();
		
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		long mobile=Long.parseLong(request.getParameter("number"));
		String dob=request.getParameter("dob");
		
		PrintWriter out = response.getWriter();
		
		FacultyBean m=new FacultyBean(name,is,email,password,mobile,dob);
		int status=FacultyDAO.facultyRegistration(m);
		String target="";
		if(status!=0){
			
			request.setAttribute("msg", "<html><style>body {color:green;}</style><body><p>You are registered successfully, Now you can login</p></body></html>");
			target="/faculty_login.jsp";
		}
		else{
			request.setAttribute("msg", "There is some issue, Plz try again");
			target="/index.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.include(request, response);
	}

}
