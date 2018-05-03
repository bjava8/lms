/**
 * 삭제 후 리스트
 */
package com.lms.command.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.MemberVO;

public class MemberdeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String memberno = request.getParameter("memberno");
		
		int n = MemberDAO.memberdelete(memberno);
		
		List<MemberVO> list = MemberDAO.memberlist();
		request.setAttribute("list", list);
		
		return "member/memberlist.jsp";
	}

}
