<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<jsp:include page="/include/head.jsp"/>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script>
$(function(){
	$("#memberinsertform").validate({
		debug: true,
		rules: {
			id:{required: true, minlength: 5, maxlength: 10, remote:"ajax?type=checkid"},
			name: {
				required: true,
				minlength: 2,
				maxlength: 3
			},
			pw: {
				required: true,
				minlength: 5,
				maxlength: 10
			},
			pw2: {
				required: true,
				minlength: 5,
				maxlength: 10,
				equalTo: "#pw"
			}
		},
		messages:{
			id:{required:"아이디를 입력하세요.", remote:"존재하는 아이디입니다."}
		}
		//success : function(data){alert(data);}
	});
});

/*
$(function(){
	$("body").on("click","#refreshimg",	function(){
		$.post("newsession.php");$("#captchaimage").load("image_req.php");return false;});
	$("#captchaform").validate({
		rules:{captcha:{required:true,remote:"process.php"}},
		messages:{captcha:"Correct captcha is required. Click the captcha to generate a new one"},
		submitHandler:function(){alert("Correct captcha!");},
		success:function(label){label.addClass("valid").text("Valid captcha!")},
				onkeyup:false});});
function checkid() {
	alert("checkid");
	
	$("#checkid").on("click", function(){
		$.ajax({
			url : "json?type=checkid",
			type : "post",
			data : {"id" : $("#id").val()}, // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
			//dataType : "json", //응답결과 데이타 형태
			success : function(data) {
				alert("success ["+data+"]");
			},
			error : function() {
				alert("fail ["+data+"]");
			}
		});
	});
}

*/
</script>
<style>

</style>
</head>
<body>
<div class="container">
<jsp:include page="/include/header.jsp"/>
<form action="member?type=memberinsert" method="post" id="memberinsertform">
	<div class="form-group row">
		<label for="id" class="col-sm-3 col-form-label">아이디</label>
		<div class="col-sm-9">
			<input type="text" name="id" class="form-control" placeholder="아이디">
<!-- 			pattern="[a-z0-9]{5,10} -->
<!-- 			<button id="checkid">아이디체크</button> -->
<!-- 		  <input type="text" name="id" minlength="5" maxlength="10" class="form-control" placeholder="아이디" required> -->
		</div>
	</div>
	<div class="form-group row">
		<label for="name" class="col-sm-3 col-form-label">이름</label>
		<div class="col-sm-9">
			<input type="text" name="name" class="form-control" placeholder="이름">
<!-- 		  <input type="text" name="name" minlength="2" maxlength="3" class="form-control" placeholder="이름" required> -->
		</div>
	</div>
	<div class="form-group row">
		<label for="pw" class="col-sm-3 col-form-label">비밀번호</label> 
		<div class="col-sm-9">
			<input type="password" name="pw" id="pw" class="form-control" placeholder="비밀번호">
		</div>
	</div>
	<div class="form-group row">
		<label for="pw2" class="col-sm-3 col-form-label">비밀번호 확인</label> 
		<div class="col-sm-9">
			<input type="password" name="pw2" id="pw2" class="form-control" placeholder="비밀번호 확인">
		</div>
	</div>
	<div class="form-group row">
		<label for="email" class="col-sm-3 col-form-label">이메일</label> 
		<div class="col-sm-9">
			<input type="email" name="email" class="form-control" placeholder="이메일">
		</div>
	</div>
	<div class="form-group row">
		<label for="phone" class="col-sm-3 col-form-label">핸드폰 번호</label> 
		<div class="col-sm-9">
			<input type="text" name="phone" class="form-control" placeholder="핸드폰 번호">
		</div>
	</div>
	<button type="submit" class="btn btn-primary mb-2">입력</button>
</form>
</div>
</body>
</html>