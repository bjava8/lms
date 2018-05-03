package com.lms.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lms.model.vo.AttendVO;
import com.lms.model.vo.MemberVO;
import com.lms.mybatis.*;

public class AttendDAO {

	private static SqlSession ss;
	
	private static SqlSession getSql() {
		ss = DBService.getFactory().openSession();
		return ss;
	}

	// [학생] 내수강신청(회원)
	public static List<AttendVO> attendlist(AttendVO vo) {
		List<AttendVO> list = getSql().selectList("attendlist", vo);
		return list;
	}
	
	// [학생] 내 강의 목록(회원)
	public static List<AttendVO> memberAttendList(String memberno) {
		List<AttendVO> list = getSql().selectList("memberAttendList", memberno);
		return list;
	}
	
	// [관리자] 강의 별 수강신청 학생 목록
	public static List<AttendVO> attendlist(String courseno) {
		List<AttendVO> list = getSql().selectList("attendlistm", courseno);
		return list;
	}
	
	// 수강신청 상세
	public static AttendVO attenddetail(String attendno) {
		AttendVO vo = getSql().selectOne("attenddetail", attendno);
		return vo;
	}
		
	// 수강신청여부
	public static int attendcnt(AttendVO vo) {
		int result = getSql().selectOne("attendcnt", vo);
		return result;
	}
	
	public static int attendinsert(AttendVO vo) {
		int n = getSql().insert("attendinsert", vo);
		ss.commit();
		return n;
	}
	
	// 수강신청 수정 : 승인(allow='Y'), 학점 입력
	public static int attendupdate(AttendVO vo) {
		int n = getSql().update("attendupdate", vo);
		ss.commit();
		return n;
	}
	
	// 수강신청 삭제
	public static int attenddelete(String attendno) {
		int n = getSql().delete("attenddelete", attendno);
		ss.commit();
		return n;
	}

}
