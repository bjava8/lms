package com.lms.command.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.ReviewDAO;

public class ReviewDeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reviewno = request.getParameter("reviewno");
		String courseno = request.getParameter("courseno");
		
		ReviewDAO.reviewdelete(reviewno);
				
		return "course?type=coursedetail&courseno="+courseno;
	}

}
