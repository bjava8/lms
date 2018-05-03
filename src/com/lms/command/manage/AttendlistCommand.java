/**
 * Manage - 수강신청 관리
 * param : 멤버번호
 */
package com.lms.command.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.AttendDAO;
import com.lms.model.vo.AttendVO;


public class AttendlistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String path = ".";
		
		path = "manage/attendlist.jsp";
		/*
		String memberno = request.getParameter("memberno");
		String courseno = request.getParameter("courseno");
		
		AttendVO vo = new AttendVO();
		
		if (memberno != null) { // member 회원 자기 수강 신청 보기
			vo.setMemberno(memberno);
			List<AttendVO> list = AttendDAO.attendlist(vo);
			request.setAttribute("list", list);
			path = "attend/attendlist.jsp";
		} else if (courseno != null) {
			System.out.println("attendlist 2 : 관리 - 수강");
			vo.setCourseno(courseno);
			List<AttendVO> list = AttendDAO.attendlist(vo);
			request.setAttribute("list", list);
			path = "attend/attendlist.jsp";
		}
*/
		return path;
	}

}
