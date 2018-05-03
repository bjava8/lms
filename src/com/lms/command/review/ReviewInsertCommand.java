package com.lms.command.review;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.ReviewDAO;
import com.lms.model.vo.ReviewVO;

public class ReviewInsertCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String courseno = request.getParameter("courseno");
		String writer = request.getParameter("writer");
		System.out.println("댓글: " + courseno);
		
		String rcontent = request.getParameter("rcontent");
		
		ReviewVO rvo = new ReviewVO();
		rvo.setCourseno(courseno);
		rvo.setWriter(writer);
		rvo.setRcontent(rcontent);
		
		ReviewDAO.reviewinsert(rvo);

		String path = "course?type=coursedetail&courseno="+courseno;
		
		return path;
		
	}
}
