/*
 * 관리자 전체
 * 강사 부분
 * 
 */
package com.lms.command.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.*;
import com.lms.model.vo.*;

public class CourseManageListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		
		CourseVO vo = new CourseVO();
		
		// 강사
		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		
		vo.setMemberno(msession.getMemberno());
		System.out.println("[CourselistCommand] " + vo);
		
		List<CourseVO> list = CourseDAO.courselist2(vo);
		request.setAttribute("list", list);
		
		return "course/courselist.jsp";
	}

}
