/*
 * 전체강의목록
 * 
 * 
 */
package com.lms.command.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.*;
import com.lms.model.vo.*;

public class CourselistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CourselistCommand");
		String page = request.getParameter("page"); // 현재 페이지
		int nowpage = 1;
		if (page != null && !"".equals(page)) {
			nowpage = Integer.parseInt(page);
		}

		Paging p = new Paging();
		p.setTotalCount(CourseDAO.getTotalCount()); // 전체 글수
		p.setNowpage(nowpage);
		p.setTotalPage(); // 전체 페이지 수 = 전체 게시물수 / block		
		p.setStartnum(); // (nowpage - 1) * num + 1
		p.setEndnum(); // startnum + num - 1
		p.setPrevpage(); // prevpage = nowpage - block;
		p.setNextpage(); // nowpage + block;
		
		System.out.println(p);
		
		
		// 전체 게시물 수 23
		// 전체 페이지 수 23/5 4+1 = 5
		// nowPage 현재페이지 prevPage 이전 페이지 nextPage 다음 페이지
		// 시작번호 startNo 끝번호
		
		// 현재 페이지 1
		// 현재 페이지의 게시물 번호 구하기
		
		// start :이전 페이지 - 1 * articlePerPage + 1
		// end : start + articlePerPage - 1
		
		// 이전 페이지 = 현재 페이지 - pagePerPage
		
		// 다음 페이지 = 현제 페이지 + pagePerPage
		
	
		request.setAttribute("pvo", p);
		
		// 강사
		/*
		HttpSession session = request.getSession();
		MemberVO msession = (MemberVO)session.getAttribute("msession");
		
		vo.setMemberno(msession.getMemberno());
		System.out.println("[CourselistCommand] " + vo);
		*/
		//CourseVO vo = new CourseVO();
		//List<CourseVO> list = CourseDAO.courselist(vo);
		Map<String, Integer> map = new HashMap<>();
		map.put("start", p.getStartnum());
		map.put("end", p.getEndnum());
		List<CourseVO> list = CourseDAO.courselist(map);
		request.setAttribute("list", list);
		
		return "course/courselist.jsp";
	}

}
