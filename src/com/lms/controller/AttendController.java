/**
 * 수강신청
 */
package com.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.*;
import com.lms.command.attend.*;

@WebServlet("/attend")
public class AttendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AttendCont");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type = request.getParameter("type");
		String path = ".";
		
		Command cmd = null;
		
		if (type.equalsIgnoreCase("attendlist")) { // 관리 - 강의별 수강신청 학생 목록
			cmd = new AttendlistCommand();
		} else if (type.equalsIgnoreCase("attenddetail")) {
			cmd = new AttenddetailCommand();
		} else if (type.equalsIgnoreCase("attendinsert")) {
			cmd = new AttendinsertCommand();
		} else if (type.equalsIgnoreCase("attendupdate")) {
			cmd = new AttendupdateCommand();
		} else if (type.equalsIgnoreCase("attenddelete")) {
			cmd = new AttenddeleteCommand();
		} else if (type.equalsIgnoreCase("memberAttendList")) { // [학생] 내수강목록
			cmd = new MemberAttendListCommand();
		} 
		
		if (cmd != null) {
			path = cmd.exec(request, response);
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
