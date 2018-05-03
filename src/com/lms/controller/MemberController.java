/**
 * 회원
 */
package com.lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.*;
import com.lms.command.member.*;



@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberCont");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type = request.getParameter("type");
		Command cmd = null;
		
		if (type.equalsIgnoreCase("memberlist")) {
			cmd = new MemberlistCommand();
		} else if (type.equalsIgnoreCase("memberdetail")) {
			cmd = new MemberdetailCommand();
		} else if (type.equalsIgnoreCase("memberinsert")) {
			cmd = new MemberinsertCommand();
		} else if (type.equalsIgnoreCase("memberupdate")) {
			cmd = new MemberupdateCommand();
		} else if (type.equalsIgnoreCase("memberdelete")) {
			cmd = new MemberdeleteCommand();
		} else if (type.equalsIgnoreCase("login")) {
			cmd = new LoginCommand();
		} else if (type.equalsIgnoreCase("logout")) {
			cmd = new LogoutCommand();
		} 
		
		String path = cmd.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
