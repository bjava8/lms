/**
 * [학생] 내 강의 목록
 * 세션멤버번호 - [학생] 내수강신청목록 MemberAttendList
 */
package com.lms.command.attend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.AttendDAO;
import com.lms.model.vo.AttendVO;
import com.lms.model.vo.MemberVO;


public class MemberAttendListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberAttendListCommand");
		String path = "index.jsp";

		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		
		// 1. 세션 체크
		if (msession == null) {
			return path; // return "index.jsp";
		}
		
		// 2. 학생 체크
		if (msession.getMemberlevel().equals("1")) { // member 회원 자기 수강 신청 보기
			
			System.out.println("[MemberAttendListCommand] msession.getMemberno = "+ msession.getMemberno());
			List<AttendVO> list = AttendDAO.memberAttendList(msession.getMemberno());
			request.setAttribute("list", list);
			path = "attend/memberAttendList.jsp";
		} 

		return path;
	}

}
