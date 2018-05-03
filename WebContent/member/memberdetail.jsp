<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberdetail 회원관리상세</title>
<jsp:include page="/include/head.jsp"/>
<script>
$(function(){
	$('#memberlevel').val("${member.memberlevel}").prop("selected", true);
	
});
</script>
</head>
<body>
<div class="container">
	<jsp:include page="/include/header.jsp"/>



<form action="member?type=memberupdate" method="post">
	<div class="form-group row">
		<label for="id" class="col-sm-3 col-form-label">아이디</label>
		<div class="col-sm-9">
		  <input type="text" name="id" class="form-control" value="${member.id }" readonly>
		</div>
	</div>
	<div class="form-group row">
		<label for="name" class="col-sm-3 col-form-label">이름</label>
		<div class="col-sm-9">
		  <input type="text" name="name" class="form-control" value="${member.name }" readonly>
		</div>
	</div>
	<div class="form-group row">
		<label for="pw" class="col-sm-3 col-form-label">비밀번호</label> 
		<div class="col-sm-9">
			<input type="password" name="pw" class="form-control" placeholder="비밀번호">
		</div>
	</div>
	<div class="form-group row">
		<label for="pw2" class="col-sm-3 col-form-label">비밀번호 확인</label> 
		<div class="col-sm-9">
			<input type="password" name="pw2" class="form-control" placeholder="비밀번호 확인">
		</div>
	</div>
	<div class="form-group row">
		<label for="phone" class="col-sm-3 col-form-label">핸드폰 번호</label> 
		<div class="col-sm-9">
			<input type="text" name="phone" class="form-control" value="${member.phone }">
		</div>
	</div>
	<div class="form-group row">
		<label for="email" class="col-sm-3 col-form-label">이메일</label> 
		<div class="col-sm-9">
			<input type="email" name="email" class="form-control" value="${member.email }">
		</div>
	</div>
	<c:if test="${msession.memberlevel=='0'}">
	<div class="form-group row">
		<label for="memberlevel" class="col-sm-3 col-form-label">레벨</label> 
		<div class="col-sm-9">
			<select name="memberlevel" id="memberlevel">
				<option value="0">관리자</option>
				<option value="1">학생</option>
				<option value="2">강사</option>
				<option value="3">행정담당자</option>
			</select>
		</div>
	</div>
	</c:if>
<%-- 	레벨 <input type="text" name="memberlevel" value="${member.memberlevel }"> --%>

	<input type="hidden" name="memberno" value="${member.memberno }">
	<button type="submit" class="btn btn-primary mb-2">수정</button>
</form>
<c:if test="${msession.memberlevel=='0'}">
	<a href="member?type=memberdelete&memberno=${member.memberno}">삭제</a>
	<a href="member?type=memberlist" >목록</a>
</c:if>
</div>
</body>
</html>