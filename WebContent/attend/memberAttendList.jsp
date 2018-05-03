<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberattendlist</title>
<jsp:include page="/include/head.jsp"/>
</head>
<body>
<div class="container">
	<jsp:include page="/include/header.jsp"/>
	<table class="table">
           <thead>
                <tr>
                  <th>수강번호</th>
                  <th>강의명</th>
                  <th>강사</th>
                  <th>승인여부</th>
                  <th>학점</th>
                  <th>상세</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach var="v" items="${list }">
				<tr>
					<td>${v.attendno }</td>
					<td>${v.coursename }</td>
					<td>${v.name }</td>
					<td>${v.allow }</td>
					<td>${v.grade }</td>
					<td>
						<a href="attend?type=attenddetail&attendno=${v.attendno}">상세</a>
					</td>
						
	
	
	<%-- ${v.courseno }, ${v.memberno },${v.coursename }
	<a href="attend?type=attenddelete&attendno=${v.attendno}">삭제</a>
	<c:if test="${msession.memberlevel=='0'}">
	관리 : 
	<a href="attend?type=attendupdate&attendno=${v.attendno}&courseno=${v.courseno}">승인</a>
	<a href="attend?type=attenddelete&attendno=${v.attendno}&courseno=${v.courseno}">삭제</a>
	</c:if> --%>
	
				</tr>
				</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>