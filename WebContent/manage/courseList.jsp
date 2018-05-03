<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>courselist</title>
<jsp:include page="/include/head.jsp"/>
</head>
<body>
<div class="container">
<jsp:include page="/include/header.jsp"/>
       <table class="table">
           <thead>
                <tr>
                  <th>강의번호</th>
                  <th>강의명</th>
                  <th>강사</th>
                </tr>
              </thead>
              <tbody>

<c:forEach var="v" items="${list }">
				<tr>
					<td><a href="course?type=coursedetail&courseno=${v.courseno }"> ${v.courseno }</a></td>
					<td><a href="course?type=coursedetail&courseno=${v.courseno }"> ${v.coursename }</a></td>
					<td>${v.name }</td>
				</tr>
</c:forEach>
	</tbody>
</table>

<!-- 페이징 -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
<c:choose>
		<%-- 첫번째 블록인 경우 --%>
		<c:when test="${pvo.prevpage < pvo.block}">
			<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">이전</a></li>
		</c:when>
		<c:otherwise>
			<li><a class="page-link" href="course?type=courselist&page=${pvo.prevpage}">이전</a></li>
		</c:otherwise>
		</c:choose>
<c:forEach var="page" begin="${pvo.prevpage}" end="${pvo.nextpage}">
		<li class="page-item"><a class="page-link" href="course?type=courselist&page=${page}">${page}</a></li>
</c:forEach>
<c:choose>
		<%-- 마지막 블록인 경우--%>
		<c:when test="${pvo.nextpage == pvo.totalPage}">
			<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">다음</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="course?type=courselist&page=${pvo.nextpage}">다음</a></li>
		</c:otherwise>
		</c:choose>
		  </ul>
</nav>


</div>
<script>
	$(".page-item").each(function(){
		if ($(this).children(".page-link").text() == ${pvo.nowpage}) {
            $(this).addClass("active");
        }
	});
</script>
</body>
</html>