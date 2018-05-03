<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
	<jsp:include page="/include/head.jsp"/>
	<link href="css/dashboard.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<jsp:include page="/include/header.jsp"/>

	
        <table class="table">
           <thead>
                <tr>
                  <th>회원번호</th>
                  <th>아이디</th>
                  <th>이름</th>
                  <th>이메일</th>
                  <th>핸드폰</th>
                  <th>상세</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="m" items="${list }">
              	<tr>
					<td><a href="member?type=memberdetail&memberno=${m.memberno }">${m.memberno }</a></td>
	                <td><a href="member?type=memberdetail&memberno=${m.memberno }">${m.id }</a></td>
	                <td><a href="member?type=memberdetail&memberno=${m.memberno }">${m.name }</a></td>
	                <td>${m.email}</td>
	                <td>${m.phone}</td>
	                <td><a href="member?type=memberdetail&memberno=${m.memberno }">상세</a></td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
         
</div>
<a href="member?type=memberinsert">입력</a>
</body>
</html>