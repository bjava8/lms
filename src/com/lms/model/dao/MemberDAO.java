package com.lms.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lms.model.vo.MemberVO;
import com.lms.mybatis.*;

public class MemberDAO {

	private static SqlSession ss;
	
	private static SqlSession getSql() {
		ss = DBService.getFactory().openSession();
		return ss;
	}
	
	public static List<MemberVO> memberlist() {
		List<MemberVO> list = getSql().selectList("memberlist");
		return list;
	}

	public static MemberVO memberdetail(String memberno) {
		MemberVO v = getSql().selectOne("memberdetail", memberno);
		return v;
	}
	
	public static int memberinsert(MemberVO vo) {
		int n = getSql().insert("memberinsert", vo);
		ss.commit();
		return n;
	}
	
	public static int memberupdate(MemberVO vo) {
		int n = getSql().update("memberupdate", vo);
		ss.commit();
		return n;
	}
	
	public static int memberdelete(String memberno) {
		int n = getSql().delete("memberdelete", memberno);
		ss.commit();
		return n;
	}
	
	public static MemberVO login(Map map) {
		MemberVO v = getSql().selectOne("login", map);
		return v;
	}
	
	// 아이디 검증
	public static int checkid(String id) {
		int n = getSql().selectOne("checkid", id);
		return n;
	}
}
