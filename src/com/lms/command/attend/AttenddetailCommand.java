package com.lms.command.attend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.AttendDAO;
import com.lms.model.dao.CourseDAO;
import com.lms.model.vo.AttendVO;
import com.lms.model.vo.CourseVO;
import com.lms.model.vo.MemberVO;

public class AttenddetailCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AttenddetailCommand");

		String attendno = request.getParameter("attendno");
		String path = "index.jsp";

		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		// 1. 세션 체크
		if (msession == null) {
			return "index.jsp";
		}

		AttendVO vo = AttendDAO.attenddetail(attendno);
		CourseVO c = CourseDAO.coursedetail(vo.getCourseno());
		request.setAttribute("c", c); // 강의 정보
		request.setAttribute("attend", vo); // 수강 정보
		
		if (msession.getMemberlevel().equals("0")) {
			
			path = "attend/attenddetail.jsp";

		} else {
			path = "attend/memberAttendDetail.jsp";
		}
		return path;
	}

}
