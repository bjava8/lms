package com.lms.model.dao;

import java.util.Map;
import java.util.List;


import org.apache.ibatis.session.SqlSession;

import com.lms.model.vo.CourseVO;

import com.lms.mybatis.*;

public class CourseDAO {

	private static SqlSession ss;
	
	private static SqlSession getSql() {
		ss = DBService.getFactory().openSession();
		return ss;
	}
	
	public static int getTotalCount() {
		int n = getSql().selectOne("getTotalCount");
		return n;
	}
	
	// 전체 강의 목록
	public static List<CourseVO> courselist(Map<String, Integer> map) {
		List<CourseVO> list = getSql().selectList("courselist", map);
		return list;
	}
	
	public static List<CourseVO> courselist2(CourseVO vo) {
		List<CourseVO> list = getSql().selectList("courselist2", vo);
		return list;
	}
	
	public static CourseVO coursedetail(String courseno) {
		CourseVO v = getSql().selectOne("coursedetail", courseno);
		return v;
	}
	
	// 수강신청된 강의 목록
	public static List<CourseVO> attendcourselist() {
		List<CourseVO> list = getSql().selectList("attendcourselist");
		return list;
	}
	
	// 강의 입력
	public static int courseinsert(CourseVO vo) {
		int n = getSql().insert("courseinsert", vo);
		ss.commit();
		return n;
	}
	
	// 강의 수정
	public static void update(CourseVO cvo) {
		getSql().update("courseUpdate", cvo);
		ss.commit();
	}
	
	// 강의 삭제
	public static void delete(String courseno) {
		getSql().delete("courseDelete", courseno);
		ss.commit();
	}
}
