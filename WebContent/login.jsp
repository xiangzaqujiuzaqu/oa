<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
	<style type="text/css">
		.myDiv {
			width: 336px;
			height: 290px;
			margin-top: 402px;
			margin-left: 806px;
			position: absolute;
			border-radius: 5px;
		}
		.inputText {
			border: 0px;
			border-bottom: 1px solid #8ad2a3;
			font-size: 18px;
		c	line-height: 50px;
			width: 100%;
			outline:none;
		}
		.inputBtn {
			margin-top: 30px;
			font-size: 24px;
			-moz-box-shadow: 0px 20px 30px #4de5a4; /* 老的 Firefox */
			box-shadow: 0px 20px 30px #4de5a4;
			background: linear-gradient(to right, #4de5a4 , #15a54d);
		}
	</style>
	<body style="background: url('${pageContext.request.contextPath}/img/login.png') no-repeat;">
		<div class="myDiv">
		<form method="post" action="${pageContext.request.contextPath }/user/login">
		<input type="text" class="inputText" name="account" id="account" placeholder="请输入账号" style="margin-top: 30px;"/><br>
		<input type="password" class="inputText" name="password" id="pwd" placeholder="请输入密码" style="margin-top: 60px;"/><br>
		<button type="submit" class="btn btn-success btn-lg btn-block inputBtn">登录</button>
		</form>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>
