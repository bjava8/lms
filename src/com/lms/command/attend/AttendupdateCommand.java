/**
 * Manage - 수강신청 승인
 * param : attendno
 * 
 * 승인 : allow = 'Y'
 */
package com.lms.command.attend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.command.Command;
import com.lms.model.dao.AttendDAO;
import com.lms.model.vo.AttendVO;

public class AttendupdateCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AttendupdateCommand");
		
		String attendno = request.getParameter("attendno");
		String courseno = request.getParameter("courseno"); // 목록에서 승인할때 필요..
		String allow = request.getParameter("allow"); // 승인여부
		String grade = request.getParameter("grade"); // 학점

		System.out.println("[AttendupdateCommand] allow="+allow);
		
		
		String path = ".";
		if (attendno == null) {
			System.out.println("[AttendupdateCommand] NO attendno");
			return ".";
		}
		
		AttendVO vo = new AttendVO();
		vo.setAttendno(attendno);
		vo.setAllow(allow);
		vo.setGrade(grade);		
		System.out.println("[AttendupdateCommand] SET = "+vo);
		int n = AttendDAO.attendupdate(vo);
		System.out.println("[AttendupdateCommand] AttendDAO.attendupdate="+n);
			
		// 수강목록에서 승인했을 때 목록으로 감
		if (courseno != null && !"".equals(courseno)) {
			return  "attend?type=attendlist&courseno="+courseno;
		}
		// 수강상세에서 수정하면 상세로 감
		return "attend?type=attenddetail&attendno="+attendno;

	}

}
