/**
 * 관리자 - 회원입력
 * 일반 - 회원가입
 */

package com.lms.command.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.MemberVO;

public class MemberinsertCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String path = "";
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String memberlevel = request.getParameter("memberlevel");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String pw = request.getParameter("pw");
		
		
		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		
		
		if (id == null) {
			return "member/memberinsert.jsp";
		}
		System.out.println("insert");
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setId(id);
		vo.setMemberlevel(memberlevel);
		vo.setName(name);
		vo.setPhone(phone);
		vo.setPw(pw);
		int n = MemberDAO.memberinsert(vo);
		System.out.println(n);
		//path = "index.jsp?n="+n;
		
		
		// 관리자면 회원입력 후 회원목록 이동
		if (msession != null && "0".equals(msession.getMemberlevel())) {
			System.out.println("[MemberinsertCommand] 관리자");
			path = "member?type=memberlist";
			
			//response.sendRedirect("member/memberlist");
			
		}
		System.out.println("[MemberinsertCommand] END");
		return path;
	}

}
