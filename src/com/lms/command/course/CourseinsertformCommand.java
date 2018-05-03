/**
 * 관리자 - 회원입력
 * 일반 - 회원가입
 */

package com.lms.command.course;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.MemberVO;

public class CourseinsertformCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("CourseinsertformCommand");
	
		
		
		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		
		if (msession == null) {
			return ".";
		}
		
	
		return "course/courseinsertform.jsp";
		
		
	}

}
