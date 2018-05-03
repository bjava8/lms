/**
 * 관리자 - 회원입력
 * 일반 - 회원가입
 */

package com.lms.command.course;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.command.Command;
import com.lms.model.dao.CourseDAO;
import com.lms.model.dao.MemberDAO;
import com.lms.model.vo.CourseVO;
import com.lms.model.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CourseinsertActionCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CourseinsertActionCommand");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		ServletContext context = request.getSession().getServletContext();
		
		String path = context.getRealPath("/upload");
		System.out.println(path);
	
		MultipartRequest mr;
		try {
			mr = new MultipartRequest(
					request, //MultipartRequest에서 request 정보 사용
					path, //실제 파일을 저장하기 위한 위치 정보
					10 * 1024 * 1024, //10MB-파일 업로드 최대 용량(byte 단위)
					"UTF-8", //인코딩 처리
					new DefaultFileRenamePolicy() //파일이름 중복처리
					);
			
			String memberno = mr.getParameter("memberno");
			String name = mr.getParameter("name");
			String coursename = mr.getParameter("coursename");
			String content = mr.getParameter("content");
			String filename = mr.getFilesystemName("filename");
			
			
			if (filename == null) {
				filename = "";
			}
			System.out.println(filename);
			
			
			 
			
			CourseVO vo = new CourseVO();
			vo.setCoursename(coursename);
			vo.setMemberno(memberno);
			vo.setName(name);
			vo.setContent(content);
			vo.setFilename(filename);
			System.out.println(vo);
			
			int result = CourseDAO.courseinsert(vo);
			System.out.println("courseinsert = " + result);
			
			
			request.setAttribute("course", vo);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		path = "course/courseDetail.jsp";
		
		return path;
	}

}
