<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attenddetail.jsp</title>
<jsp:include page="/include/head.jsp"/>
</head>
<body>
<div class="container">
<jsp:include page="/include/header.jsp"/>

강의번호 : ${c.courseno }
강의 : ${c.coursename }
강사 : ${c.name }

학생 : ${attend.memberno }

<form action="attend?type=attendupdate" method="post">
	수강번호 ${attend.attendno } <input type="hidden" name="attendno" value="${attend.attendno }">
	승인여부 ${attend.allow}
<%-- 	<input type="text" name="allow" value="${attend.allow }"> --%>
	<select name="allow" id="allow">
		<option>Y</option>
		<option>N</option>
	</select>
	학점 <input type="text" name="grade" value="${attend.grade }">
	<input type="submit" value="수정">
	<input type="submit" value="승인" id="btallow">
</form>
<c:if test="${msession.memberlevel=='0'}">
	<a href="attend?type=attendupdate&attendno=${v.attendno}&courseno=${v.courseno}">승인</a>
	<a href="attend?type=attenddelete&attendno=${v.attendno}&courseno=${v.courseno}">삭제</a>
</c:if>
<c:if test="${msession.memberlevel=='1'}">
	<a href="attend?type=attenddelete&attendno=${v.attendno}&courseno=${v.courseno}">삭제</a>
</c:if>
<c:if test="${msession.memberlevel=='3'}">
	<a href="attend?type=attendupdate&attendno=${v.attendno}&courseno=${v.courseno}">승인</a>
</c:if>
	</div>
<script>
/* $("#btallow").click(function(){
	$('#allow').val("Y");
}); */
$(function(){
// 	$('#allow').val("${attend.allow}").prop("selected", true);
	$("#allow").val("${attend.allow}");
});

$("#btallow").click(function(){
	$('#allow').val("Y");
});
</script>
</body>
</html>