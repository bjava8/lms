/**
 * [관리자]
 * 코스넘버 - 관리자 : 신청학생목록 attendlist
 */
package com.lms.command.attend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.AttendDAO;
import com.lms.model.dao.CourseDAO;
import com.lms.model.vo.AttendVO;
import com.lms.model.vo.CourseVO;
import com.lms.model.vo.MemberVO;


public class AttendlistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AttendlistCommand");
		String path = "index.jsp";
		
		String courseno = request.getParameter("courseno");
		
		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		
		// 1. 세션 체크
		if (msession == null) {
			return path; // return "index.jsp";
		}
		

		if (msession.getMemberlevel().equals("0") && courseno != null) { 	//관리자
			System.out.println("[AttendlistCommand] 관리자 - 신청학생목록");
			
			CourseVO c = CourseDAO.coursedetail(courseno); // 강의 정보
			
			//vo.setCourseno(courseno);
			
			List<AttendVO> list = AttendDAO.attendlist(courseno);
			request.setAttribute("c", c);
			request.setAttribute("list", list);
			path = "attend/attendlist.jsp";
		}

		return path;
	}

}
