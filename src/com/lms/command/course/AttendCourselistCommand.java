/**
 * [관리자] 수강신청 된 강의 목록
 */
package com.lms.command.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.*;
import com.lms.model.vo.*;

public class AttendCourselistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AttendCourselistCommand");
		
		
		List<CourseVO> list = CourseDAO.attendcourselist();
		request.setAttribute("list", list);
		
		return "course/attendcourselist.jsp";
	}

}
