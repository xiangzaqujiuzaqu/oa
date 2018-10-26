<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
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
		line-height: 50px;
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
	
	
	<body style="background: url('img/title.png') no-repeat;overflow: hidden;">
		<div style="width: 100%;text-align: right;line-height: 74px;padding-right: 20px;color: #FFFFFF;">
			<span style="color: #32394d;font-size: 18px;">admin你好，今天是2018年12月12日</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="password.html" class="btn btn-sm btn_a" target="content">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/user/logout" class="btn btn-sm btn_a" target="_top" onclick="">退出</a>
		</div>
	</body>
</html>
