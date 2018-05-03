/**
 * 회원 상세
 * 
 * 회원관리(관리자용) - param : memberno
 * 회원 - param : session
 */
package com.lms.command.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.MemberVO;

public class MemberdetailCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		
		String memberno = request.getParameter("memberno"); // 관리자용 회원관리에서만 받음
		
		// 1. 세션 체크
		if (msession == null) {
			System.out.println("[MemberdetailCommand] msession == null");
			return "."; // index.jsp??
		}
		
		// 2-1. 관리자의 회원관리면
		if (memberno != null && msession.getMemberlevel().equals("0")) { // memberno 라는 이름의 파라미터가 있으면

			/*
			if (!memberno.equals("")) { // memberno가 비어있지 않으면
				//memberno.isEmpty();
			 */
				
			if (memberno.equals("")) { // memberno가 비어있으면
				System.out.println("[MemberdetailCommand] 관리자 - memberno empty");
				// 회원 목록 이동
				//return "member/memberlist.jsp";
				try {
					response.sendRedirect("member/memberlist");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else { // 2-2. 회원정보 보기면
			memberno = msession.getMemberno(); // 세션에서 멤버번호 가져옴
			System.out.println("[MemberdetailCommand] 로그인한 회원의 정보");
		}		
		
		MemberVO vo = MemberDAO.memberdetail(memberno);
		request.setAttribute("member", vo);
		
		return "member/memberdetail.jsp";
	}

}
