<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manage/manage.jsp</title>
</head>
<body>
<jsp:include page="/include/manageheader.jsp"/>
<h2>관리</h2> 관리자 로그인 하고 난뒤 메인 페이지
<ul>
<li><a href="member?type=memberlist">회원</a></li>
<li><a href="course?type=courselist">강의</a></li>
</ul>
</body>
</html>