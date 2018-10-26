<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>菜单</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css" />
	</head>
	<body>
		<div class="container-fluid" style="padding: 0;">
			<div class="row-fluid">
				<div class="col-md-12" style="padding: 0;">
					<ul id="main-nav" class="nav nav-tabs nav-stacked">
						
					</ul>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>
	<script type="text/javascript">
		$(function(){
			menu("${pageContext.request.contextPath }");
		});
	</script>

</html>
