package com.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.*;
import com.lms.command.member.*;

//@WebServlet("/")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IndexCont");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//String type = request.getParameter("type");
		String path = "index.jsp";
		
		
		/*
		if (type.equalsIgnoreCase("admin")) {
			path = "home/admin.jsp";
		} else if (type.equalsIgnoreCase("student")) {
			path = "home/student.jsp";
		} else if (type.equalsIgnoreCase("teacher")) {
			path = "home/teacher.jsp";
		} else if (type.equalsIgnoreCase("school")) {
			path = "home/school.jsp";
		} 
*/
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
