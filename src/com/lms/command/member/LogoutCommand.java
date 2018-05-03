/**
 * 로그아웃 Command
 */
package com.lms.command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.vo.MemberVO;

public class LogoutCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("LogoutCommand");
		
		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		
		if (msession == null) {
			return "index.jsp";
		}
		
		
		System.out.println("[LogoutCommand] vo.getMemberno="+msession.getMemberno());
			
		session.removeAttribute("msession"); // 세션 삭제
		session.invalidate(); // 세션 종료
		
		return "index.jsp";
	}

}
