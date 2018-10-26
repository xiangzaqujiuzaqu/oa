<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<frameset rows="76, *" frameborder="no" border="0" framespacing="0">
		<frame src="top.jsp" name="top" style="border: 1px solid #8ad2a3;border-bottom: 5px solid #8ad2a3;">
		<frameset cols="16.66666667%, *" frameborder="no" border="0" framespacing="0">
				<frame src="menu.jsp" name="menu" style="border: 1px solid #8ad2a3;border-right: 5px solid #8ad2a3;">
				<frame src="content.jsp" name="content" style="border: 1px solid #8ad2a3;">
		</frameset>
		<noframes>

			<body>
				<h1>您的浏览器无法处理框架！</h1>
			</body>
		</noframes>
	</frameset>

</html>