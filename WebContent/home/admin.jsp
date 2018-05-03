<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- TODO session.memberlevel 이 학생이 아니면 다른 홈으로 이동 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자홈</title>
	<jsp:include page="/include/head.jsp"/>
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
</head>
<body>
<%-- <jsp:include page="/include/header.jsp"/> --%>
<!-- 회원정보 -->
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">관리자</a>
      <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="member?type=logout">로그아웃</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="home?type=admin">
                  <span data-feather="home"></span>
                  관리자홈 <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="course?type=attendcourselist">
                  <span data-feather="file"></span>
                  수강관리
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="member?type=memberlist">
                  <span data-feather="shopping-cart"></span>
                  회원관리
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="course?type=courseinsertform">
                  <span data-feather="users"></span>
                  강의입력
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="course?type=courselist">
                  <span data-feather="bar-chart-2"></span>
                  강의관리
                </a>
              </li>
            </ul>

           
          </div>
        </nav>

          
      </div>
    </div>
</body>
</html>