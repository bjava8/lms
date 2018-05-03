/**
 * [관리]
 */
package com.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.*;
import com.lms.command.manage.*;

@WebServlet("/manage")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("manage");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type = request.getParameter("type");
		String path = ".";
		
		Command cmd = null;
		
		if (type.equalsIgnoreCase("attendlist")) { // 관리 - 수강신청 관리
			cmd = new AttendlistCommand();
		} else if (type.equalsIgnoreCase("coursedetail")) { // 상세
			cmd = new CourseDetailCommand();
		}
		if (cmd != null) {
			path = cmd.exec(request, response);
		}
				
		request.getRequestDispatcher(path).forward(request, response);
	}

}
