/**
 * 삭제 후 리스트
 */
package com.lms.command.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.MemberVO;

public class LoginCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id="+id);
		String path = ".";
		
		
		if (id == null) { 		// 1. 로그인 폼
			return "member/login.jsp";
		} 
		
		// 2. 로그인 처리
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		MemberVO vo = MemberDAO.login(map);
		//request.setAttribute("member", vo);
		
		
		// 로그인 실패 : 다시 로그인 폼 return fail 
		if (vo == null) {
			return "member/login.jsp";
		}
		
		// 로그인 성공
		HttpSession session = request.getSession();
		session.setAttribute("msession", vo);
		
					
		//path = "manage/manage.jsp";
		
		
		/*
		 * memberlevel
		 * 0 : 관리자 admin
		 * 1 : 학생 student
		 * 2 : 강사 teacher
		 * 3 : 행정담당자 school
		 */
		if (vo.getMemberlevel().equals("0")) { // 관리자는 관리자 메인 페이지로 이동
			path = "home/admin.jsp";
		} else if (vo.getMemberlevel().equals("1")) {
			path = "home/student.jsp";
		} else if (vo.getMemberlevel().equals("2")) {
			path = "home/teacher.jsp";
		} else if (vo.getMemberlevel().equals("3")) {
			path = "home/school.jsp";
		}
			
		

		return path;
	}

}
