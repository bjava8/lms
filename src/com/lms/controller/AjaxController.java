/**
 * checkid 아이디체크
 */
package com.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.*;
import com.lms.command.member.*;

@WebServlet("/ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JsonCont");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type = request.getParameter("type");

		Command cmd = null;
		
		if (type.equalsIgnoreCase("checkid")) {
			cmd = new CheckidCommand();
			String result = cmd.exec(request, response);
			
			PrintWriter out = response.getWriter();
			out.println(result);
		} 	
	}

}
