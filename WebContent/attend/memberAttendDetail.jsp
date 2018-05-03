<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberattenddetail.jsp</title>
<jsp:include page="/include/head.jsp"/>
</head>
<body>
<div class="container">
	<jsp:include page="/include/header.jsp"/>
	<form action="attend?type=attenddelete" method="post">
	
	강의번호 : ${c.courseno }
강의명 : ${c.coursename }
강사 : ${c.name }

	
	
		강의번호 ${attend.attendno }
		강의명 ${attend.attendno }
		강사 ${attend.name}
		승인여부 ${attend.allow}
		학점 ${attend.grade }
		<input type="hidden" name="attendno" value="${attend.attendno }">
		<input type="submit" value="삭제">
	</form>
	<c:if test="${msession.memberlevel=='1'}">
		<a href="attend?type=attenddelete&attendno=${v.attendno}&courseno=${v.courseno}">삭제</a>
	</c:if>
	<c:if test="${msession.memberlevel=='3'}">
		<a href="attend?type=attendupdate&attendno=${v.attendno}&courseno=${v.courseno}">승인</a>
	</c:if>
</div>

</body>
</html>