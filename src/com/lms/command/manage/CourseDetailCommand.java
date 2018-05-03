/**
 * 강의 상세, 댓글 목록
 */
package com.lms.command.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.*;
import com.lms.model.vo.*;

public class CourseDetailCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("");
		String courseno = request.getParameter("courseno");
		
		if (courseno == null || "".equals(courseno)) { // 강의번호가 없으면 강의목록으로
			return "course/courselist.jsp";
		}
		
		CourseVO vo = CourseDAO.coursedetail(courseno); // 강의 상세
		request.setAttribute("course", vo);
		System.out.println(vo);
		
		/*
		List<ReviewVO> rlist = ReviewDAO.getList(courseno); // 댓글 목록
		request.setAttribute("r_list", rlist);	
*/
		return "manage/courseDetail.jsp";
	}

}
