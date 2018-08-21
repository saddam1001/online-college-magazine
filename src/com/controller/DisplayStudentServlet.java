package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDAO;


@WebServlet("/DisplayStudentServlet")
public class DisplayStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/gif");
		HttpSession session=request.getSession(false);
		String email=(String)session.getAttribute("email_id");
		byte[] bytes=(byte[]) StudentDAO.viewImage(email);
		
		ServletOutputStream sos=response.getOutputStream();
		//PrintWriter out=response.getWriter();
		
		try{
			//sos.println("<body><form>");
			sos.write(bytes);
			//sos.println("</form></body>");
			sos.flush();
			sos.close();
		}catch(Exception e){e.printStackTrace();}
		//RequestDispatcher rd=request.getRequestDispatcher("/success.jsp");
		//rd.include(request, response);
		
		
		/*
		
		out.println(email);
		out.println(bytes);
		*/
}
}