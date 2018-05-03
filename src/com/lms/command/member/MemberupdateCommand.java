package com.lms.command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.MemberVO;

public class MemberupdateCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberupdateCommand");
		String memberno = request.getParameter("memberno");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String memberlevel = request.getParameter("memberlevel");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String pw = request.getParameter("pw");
		
		// 비밀번호 변경이 아니면 pw를 널로 함.
		if (pw.equals("")) {
			System.out.println("[MemberupdateCommand] 비밀번호 변경 아님. ");
			pw = null;
		}
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setMemberno(memberno);
		vo.setPhone(phone);
		vo.setPw(pw);
		vo.setMemberlevel(memberlevel);
		vo.setId(id);
		vo.setName(name);
		
		int n = MemberDAO.memberupdate(vo);
		
		System.out.println(n);
		
		request.setAttribute("member", vo);
		return "member/memberdetail.jsp";
	}

}
