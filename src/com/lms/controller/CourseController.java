/**
 * 강의
 */
package com.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.*;
import com.lms.command.course.*;



@WebServlet("/course")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CourseCont");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type = request.getParameter("type");
		String path = ".";
		
		Command cmd = null;
		
		if (type.equalsIgnoreCase("courselist")) { // 목록
			cmd = new CourselistCommand();
		} else if (type.equalsIgnoreCase("coursedetail")) { // 상세
			cmd = new CourseDetailCommand();
		} else if (type.equalsIgnoreCase("attendcourselist")) { // 수강 강의 목록
			cmd = new AttendCourselistCommand();
		} else if (type.equalsIgnoreCase("courseinsertform")) { // 입력폼
			cmd = new CourseinsertformCommand();
		} else if (type.equalsIgnoreCase("courseinsertaction")) { // 입력
			cmd = new CourseinsertActionCommand();
		} else if (type.equalsIgnoreCase("courseupdate")) { // 수정
			cmd = new CourseUpdateCommand();
		} else if (type.equalsIgnoreCase("coursedelete")) { // 삭제
			cmd = new CourseDeleteCommand();
		} 
		
		if (cmd != null) {
			path = cmd.exec(request, response);
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
