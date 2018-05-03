<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<jsp:include page="/include/head.jsp"/>
</head>
<body>
<div class="container-fluid">
	<jsp:include page="/include/header.jsp"/>
	
	<!-- nav -->
	<nav class="navbar navbar-expand-sm navbar-light">
<!-- 	<a class="navbar-brand" href=".">Navbar</a> -->
	
	<a class="navbar-brand" href=".">
    <img src="img/logo.jpg" width="100" height="40" alt="">
  	</a>
	
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="course?type=courselist">강의</a></li>
			<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
			<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
		 </ul>
		 </div>
	</nav>
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	  	</ol>
  		<div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="img/1.png" alt="First slide" height="460">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="img/2.png" alt="Second slide" height="460">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="img/3.png" alt="Third slide" height="460">
		    </div>
		    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
	  </div>
  </div> 


<%=request.getContextPath() %>
<%=request.getSession().getServletContext().getRealPath("/") %>
<c:set var="context" value="${pageContext.request.contextPath}" />
${context}
${pageContext.request.contextPath}
지금 수강신청 가능한 강의?


</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>