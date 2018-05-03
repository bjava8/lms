<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
manageheader
<a href="manage/manage.jsp">관리자 메인</a>
<c:if test="${msession!=null}">
msession.memberno=${msession.memberno }, 
msession.name=${msession.name },
msession.memberlevel=${msession.memberlevel }
<a href="member?type=logout">로그아웃</a>
<a href="attend?type=attendlist&memberno=${msession.memberno }">attendlist</a>
</c:if>
<c:if test="${msession==null}">
<a href="member?type=login">로그인</a>
</c:if>


<c:if test="${msession.memberlevel=='0' || msession.memberlevel=='3'}">
관리
msession.memberlevel=='0'3
<a href="attend?type=attendlist">승인관리X</a>

</c:if>

</div>
