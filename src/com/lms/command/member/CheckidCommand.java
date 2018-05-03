/**
 * 회원 상세
 * 
 * 회원관리(관리자용) - param : memberno
 * 회원 - param : session
 */
package com.lms.command.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.MemberDAO;


public class CheckidCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("CheckidCommand");
		
		
		String id = request.getParameter("id"); 
		
		if (id == null || "".equals(id)) {
			request.setAttribute("result", "error1");
		}
		System.out.println("[CheckidCommand] id [" + id + "]");
		
		
		int countid = MemberDAO.checkid(id);
		
		System.out.println("[CheckidCommand] countid [" + countid + "]");
		/*
		boolean bl = false;
		if (result == 0) {
			bl = true;
		} 
		String json = "{\"checkid\":["
		 + "{\"result\":\"" + bl + "]}";
		request.setAttribute("checkid", json);
		*/
		String checkid = "false";
		if (countid == 0) { // 중복 아이디가 없음
			checkid = "true";
		}

		System.out.println("[CheckidCommand] checkid [" + checkid + "]");
		return checkid;
	}

}
