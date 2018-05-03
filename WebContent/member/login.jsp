<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<jsp:include page="/include/head.jsp"/>
	<link href="css/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<jsp:include page="/include/header.jsp"/>
	<div class="text-center">
	<form action="member?type=login" method="post" class="form-signin">
		<h1 class="h3 mb-3 font-weight-normal">로그인</h1>
		<label for="id" class="sr-only">아이디</label> 
		<input type="text" name="id" id="id" class="form-control" placeholder="아이디" required autofocus>
		<label for="pw" class="sr-only">비밀번호</label>
		<input type="password" name="pw" id="pw" class="form-control" placeholder="비밀번호" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
	</form>
	
	회원가입
	</div>
</div>
</body>
</html>