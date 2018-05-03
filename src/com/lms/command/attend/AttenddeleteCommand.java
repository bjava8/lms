/**
 * 회원 - 수강신청 삭제
 * param : attendno
 */
package com.lms.command.attend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.AttendDAO;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.MemberVO;

public class AttenddeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AttenddeleteCommand");
		
		String attendno = request.getParameter("attendno");
		String courseno = request.getParameter("courseno");
		String memberno = "";
		String path = ".";
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("msession");
		if (vo.getMemberlevel().equals("1")) {
			memberno = vo.getMemberno();
		}
		
		if (attendno == null) {
			return ".";
		}
		
		if (attendno != null) {
			int n = AttendDAO.attenddelete(attendno);
			System.out.println("AttendDAO.attenddelete="+n);
			
		}
		
		if (!memberno.equals("")) {
			path = "attend?type=attendlist&memberno="+memberno; // 회원 자기신청목록
		} else if (courseno != null ) {
			path = "attend?type=attendlist&courseno="+courseno;  // 관리 - 코스별 수강신청목록
		}
		
		return path;
	}

}
