<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- TODO session.memberlevel 이 학생이 아니면 다른 홈으로 이동 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사홈</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
로그아웃
회원정보
-----

<a href="course?type=courselist">전체강의목록</a>
<a href="course?type=courselist">내강의관리</a>
<a href="course?type=courseinsertform">새강의입력</a>

</body>
</html>