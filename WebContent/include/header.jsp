<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<a href="course?type=courselist">전체강의목록</a>

<!-- 일반(비회원/로그인 전 회원) -->
<c:if test="${msession==null}">
	<a href=".">홈</a>
	<a href="member?type=login">로그인</a>
	<a href="member?type=memberinsert">회원가입</a>
</c:if>

<!-- 회원(로그인 후) -->
<c:if test="${msession!=null}">
	${msession.name} (${msession.memberlevel})
	<a href="member?type=logout">로그아웃</a>
	<a href="member?type=memberdetail">회원정보</a>
	
	<!-- 관리자 -->
	<c:if test="${msession.memberlevel=='0'}">
		<a href="home?type=admin">관리자홈</a>
		<a href="course?type=courselist">강의관리</a>
		<a href="member?type=memberlist">회원관리</a>
	</c:if>
	
	<!-- 학생 -->
	<c:if test="${msession.memberlevel=='1'}">
	
		<a href="home?type=student">학생홈</a>
		
	</c:if>
	
	<!-- 강사 -->
	<c:if test="${msession.memberlevel=='2'}">
	
		<a href="home?type=teacher">강사홈</a>
		
	</c:if>
	
	<c:if test="${msession.memberlevel=='3'}">
	
		<a href="home?type=school">행정홈</a>
		
	</c:if>
	
	
<!-- <a href="attend?type=attendlist">수강관리</a> -->

</c:if>
</div>