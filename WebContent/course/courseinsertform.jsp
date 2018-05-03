<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>courseinsertform</title>
<jsp:include page="/include/head.jsp"/>

</head>
<body>
<!-- // 강사가 입력하면 강사 정보 넣기 -->
<c:if test="${msession.memberlevel=='2'}">
	 강사로그인
	 ${msession.memberno}
</c:if>
<div class="container">
<jsp:include page="/include/header.jsp"/>
<form action="course?type=courseinsertaction" method="post" id="memberinsertform" enctype="multipart/form-data">
	<div class="form-group row">
		<label for="memberno" class="col-sm-3 col-form-label">memberno</label>
		<div class="col-sm-9">
		  <input type="text" name="memberno" class="form-control" id="memberno">
		</div>
	</div>
	<div class="form-group row">
		<label for="name" class="col-sm-3 col-form-label">강사</label>
		<div class="col-sm-9">
		  <input type="text" name="name" class="form-control" id="name">
		</div>
	</div>
	<div class="form-group row">
		<label for="coursename" class="col-sm-3 col-form-label">강의</label> 
		<div class="col-sm-9">
			<input type="text" name="coursename" class="form-control" placeholder="강의" id="coursename">
		</div>
	</div>
	<div class="form-group row">
		<label for="content" class="col-sm-3 col-form-label">내용</label> 
		<div class="col-sm-9">
			<textarea class="form-control" name="content" id="content" rows="3"></textarea>
		</div>
	</div>
	<div class="form-group row">
		<label for="filename" class="col-sm-3 col-form-label">파일</label> 
		<div class="col-sm-9">
			<input type="file" name="filename" class="form-control-file">
		</div>
	</div>
	<input type="submit">
	
</form>
</div>

<script>
/* $(function(){
	var mlevel = ${msession.memberlevel};
	if (mlevel == 2) {
		
		$("#memberno").val("${member.memberno}");
		$("#name").val("${member.name}");
	}
	
});
 */

	var mlevel = ${msession.memberlevel};
	if (mlevel == 2) {
		
		$("#memberno").val("${msession.memberno}");
		$("#name").val("${msession.name}");
	
	}
	

</script>
</body>
</html>