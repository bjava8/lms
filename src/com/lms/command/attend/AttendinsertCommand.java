/**
 * param : 강의 번호, 멤버 번호
 * 회원이 해당 강의를 이미 수강하는지 확인
 */
package com.lms.command.attend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.AttendDAO;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.AttendVO;
import com.lms.model.vo.MemberVO;

public class AttendinsertCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String path = ".";
		String courseno = request.getParameter("courseno");
		String memberno = request.getParameter("memberno");
		
		if (courseno == null) {
			System.out.println("courseno == null"); // http://localhost:8080/lms/attend?type=attendinsert
		}
		
		if ("".equals(courseno)) {
			System.out.println("\"\".equals(courseno)");
		}
		
		if (courseno != null && memberno != null) {
			if (!"".equals(courseno) && !"".equals(memberno)) {
				AttendVO vo = new AttendVO();
				vo.setCourseno(courseno);
				vo.setMemberno(memberno);
				
				int result = AttendDAO.attendcnt(vo); // 회원이 해당 강의를 이미 수강하는지 확인

				if (result == 0) {		

					int insertresult = AttendDAO.attendinsert(vo);
					System.out.println(insertresult);
					path = "attend?type=attendlist&memberno="+memberno;
				}
			}
		}

		return path;
	}

}
