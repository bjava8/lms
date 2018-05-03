package com.lms.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.lms.model.vo.ReviewVO;
import com.lms.mybatis.DBService;

public class ReviewDAO {
private static SqlSession ss;
	
	private synchronized static SqlSession getSql() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}
		
		return ss;
	}
	
	// 댓글 목록 - 후기 가져오기(글번호)
	public static List<ReviewVO> getList(String courseno) {
		List<ReviewVO> list = getSql().selectList("reviewlist", courseno);
		return list;
	}
	
	//후기 가져오기(댓글번호)
	public static ReviewVO getOneList(String reviewno) {
		ReviewVO rvo = getSql().selectOne("reviewsearch", reviewno);
		return rvo;		
	}
	
	//후기 입력
	public static void reviewinsert(ReviewVO rvo) {
		getSql().insert("reviewinsert", rvo);
		ss.commit();
	}
	
	//후기 수정
	public static void reviewupdate(ReviewVO rvo) {
		getSql().update("reviewupdate", rvo);
		ss.commit();
	}

	//후기 삭제
	public static void reviewdelete(String reviewno) {
		getSql().delete("reviewdelete", reviewno);
		ss.commit();
	}          

	
}