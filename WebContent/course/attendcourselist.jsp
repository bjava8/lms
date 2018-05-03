<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attendcourselist</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
수강신청 강의 목록
<table class="table table-striped table-sm">
           <thead>
                <tr>
                  <th>강의번호</th>
                  <th>강의명</th>
                  <th>강사</th>
                  <th>신청자목록</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach var="v" items="${list }">
				<tr>
					<td>${v.courseno }</td>
					<td>${v.coursename }</td>
					<td>${v.name }</td>
					<td><a href="attend?type=attendlist&courseno=${v.courseno }">신청자목록</a></td>
					
<%-- 	<a href="course?type=coursedetail&courseno=${v.courseno }">, </a>
	
	${v.coursename }</a>, ${v.memberno }, ${v.name } --%>
				</tr>
				</c:forEach>
</tbody>
</table>
<a href="course?type=courseinsert">입력</a>
</body>
</html>