<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manage/attendlist</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<h2>수강신청관리</h2>
<form action="manage?type=attendlist" method="get">
	<input type="text" name="coursename">
</form>
<c:forEach var="v" items="${list }">
	<a href="course?type=coursedetail&courseno=${v.courseno }">
	
	${v.attendno },
	${v.courseno }, ${v.memberno }, ${v.allow },</a><br>
</c:forEach>
<a href="course?type=courseinsert">입력</a>
</body>
</html>