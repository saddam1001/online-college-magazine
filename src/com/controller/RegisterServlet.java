package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.StudentDAO;
import com.bean.StudentBean;
import com.bean.StudentBean;

@WebServlet("/RegisterServlet")
@MultipartConfig(maxFileSize = 1024*1024*16)
public class RegisterServlet extends HttpServlet {
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
	/*	
		out.println(name);
		out.println(is);
		out.println(email);
		out.println(password);
		out.println(mobile);
		out.println(dob);
	*/	
		StudentBean m=new StudentBean(name,is,email,password,mobile,dob);
		int status=StudentDAO.memberRegistration(m);
		if(status!=0){
			out.println("Strored Successfully");
		}
		else{
			out.print("Failed");
		}
	}

}
