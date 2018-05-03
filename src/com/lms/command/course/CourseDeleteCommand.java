/**
 * 강의 삭제
 */

package com.lms.command.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.CourseDAO;

public class CourseDeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CourseDeleteCommand");
		
		String courseno = request.getParameter("courseno");
		CourseDAO.delete(courseno);
		
		return "course?type=courselist";
	}

}
