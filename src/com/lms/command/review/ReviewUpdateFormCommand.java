package com.lms.command.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.ReviewDAO;
import com.lms.model.vo.ReviewVO;

public class ReviewUpdateFormCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String reviewno = request.getParameter("reviewno");	
		String rcontent = request.getParameter("rcontent");
		String courseno = request.getParameter("courseno");
		
		ReviewVO rvo = ReviewDAO.getOneList(reviewno);
		request.setAttribute("rvo", rvo);		
		
		return "course/reviewupdateform.jsp";
	}

}
