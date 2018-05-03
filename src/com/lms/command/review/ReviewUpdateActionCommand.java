package com.lms.command.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.ReviewDAO;
import com.lms.model.vo.ReviewVO;

public class ReviewUpdateActionCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String reviewno = request.getParameter("reviewno");		
		String rcontent = request.getParameter("rcontent");
		String courseno = request.getParameter("courseno");
		System.out.println("댓글:"+reviewno+rcontent+courseno);
		
		ReviewVO rvo = new ReviewVO();
		rvo.setReviewno(reviewno);
		rvo.setRcontent(rcontent);
		
		ReviewDAO.reviewupdate(rvo);		
		
		String path = "course?type=coursedetail&courseno="+courseno;
		
		return path;		
		
	}

}
