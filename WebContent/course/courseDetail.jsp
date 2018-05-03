<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>courseDetail</title>
<jsp:include page="/include/head.jsp"/>
<style>
[class*="col-"] {
  padding-top: 1rem;
  padding-bottom: 1rem;
  background-color: rgba(86, 61, 124, .15);
  border: 1px solid rgba(86, 61, 124, .2);
}
</style>
</head>
<body>
<div class="container">
	<jsp:include page="/include/header.jsp"/>
<a href="course?type=courselist" >목록</a>
<form action="member?type=memberupdate" method="post">
	<div class="row">
		<div class="col-4">강의번호</div>
        <div class="col-8">${course.courseno }</div>
	</div>
	<div class="row">
		<div class="col-4">강의명</div>
        <div class="col-8">${course.coursename }</div>
	</div>
	<div class="row">
		<div class="col-4">강사</div>
        <div class="col-8">${course.name }</div>
	</div>
	<div class="row">
		<div class="col-4">내용</div>
        <div class="col-8">${course.content }</div>
	</div>
	<div class="row">
		<div class="col-4">첨부파일</div>
        <div class="col-8">${course.filename }</div>
	</div>
</form>

<c:if test="${msession!=null}">
<!-- 학생만 수강 가능 -->
	<c:if test="${msession.memberlevel=='1'}">
	<a href="attend?type=attendinsert&courseno=${course.courseno }&memberno=${msession.memberno}">수강</a>
	</c:if>
</c:if>
<c:if test="${msession==null}">
<a href="member?type=login">수강(로그인)</a>
</c:if>

<c:if test="${msession.memberlevel=='0' || msession.memberlevel=='3'}">
관리 : 
<a href="attend?type=attendlist&courseno=${course.courseno }">수강 관리</a>
</c:if>

<!-- 해당글 강의평 가져오기 -->	
<c:forEach var="r" items="${r_list}">
<form action="review?type=reviewiupdateform" method="post" id="reviewlist">
	<div class="form-group row">
		<label for="name" class="col-sm-3 col-form-label">작성자</label>
		<div class="col-sm-9">
		  ${r.writer}
		  <input type="hidden" name="writer" class="form-control" id="writer" value="${r.writer}">
		</div>
	</div>	
	<div class="form-group row">
		<label for="name" class="col-sm-3 col-form-label">작성날짜</label>
		<div class="col-sm-9">
		  ${r.writedate.substring(0,16)}
	</div>
	</div>	
	<div class="form-group row">
		<label for="content" class="col-sm-3 col-form-label">내용</label> 
		<div class="col-sm-9">
			<pre>${r.rcontent}</pre>
		</div>
	</div>	
		<input type="submit" value="수정" onclick="rv_update(this.form)">
		<input type="submit" value="삭제" onclick="rv_delete(this.form)">
		<input type="hidden" name="courseno" value="${r.courseno}"> 
		<input type="hidden" name="reviewno" value="${r.reviewno}">	
</form>
	<hr>
</c:forEach>
</div>
</body>
</html>