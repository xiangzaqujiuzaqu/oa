<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title>考勤管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
	</head>

	<body>
		<div class="container" style="width: 100%;padding: 25px 15px;">
			<div class="row clearfix">
				<div class="col-md-12 column" style="padding: 20px;">
					<div style="float: left;">
						
							<input type="button" class="btn btn-primary btn" value="签到" onclick="attendSignIn('${pageContext.request.contextPath}')" />
					
						<input type="button" class="btn btn-primary btn" value="签退" onclick="atttendSignOut('${pageContext.request.contextPath}')" />
					</div>
					<form action="${pageContext.request.contextPath}/attendance/list" method="post" id="attendForm" role="form" class="form-inline" style="float: right;margin-bottom: 10px;">
						<div class="form-group" style="margin-right: 20px;">
							<label for="exampleInputEmail1" style="margin-right: 10px;">签到时间</label><input type="text" class="form-control" id="signInStr" name="signInStr" placeholder="签到时间，如：2018-01-01" />
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" style="margin-right: 10px;">签到时间</label><input type="text" class="form-control" id="signOutStr" name="signOutStr" placeholder="签退时间，如：2018-01-02" />
						</div>
						<input type="hidden" id="pageNo" name="pageNum" value="">
						<button type="button" class="btn btn-primary btn" onclick="findAttend()">查询</button>
					</form>
					<table class="table table-bordered" style="margin-top: 20px;">
						<thead>
							<tr>
								<th style="width: 150px;">姓名</th>
								<th>签到时间</th>
								<th>签退时间</th>
								<th>IP</th>
							</tr>
						</thead>
						<tbody>
						     <c:forEach items="${page.list }" var="attendance">
							
								<tr class="success">
									<td>${user.account }</td>
									<td>${attendance.signIn}</td>
									<td>${attendance.signOut}</td>
									<td>${attendance.ip}</td>
								</tr>
							</c:forEach>
							<!--没有记录时-->
							<!--<c:if test="${attend.size() <= 0 }">
								<h1>${msg }</h1>
							</c:if>-->
						</tbody>
					</table>
					<!-- 分页 -->
					
					
					<span>共${page.totalRecords }条记录 共${page.totalPages }页 当前第${page.pageNo }页</span>
					<ul class="pagination" style="float: right;margin: 0;">
						<li><a href="javascript:void(0)" onclick="attendPage(${page.topPageNo})">首页</a></li>
								
								<c:choose>
								<c:when test="${page.pageNo==1 }">
									<li disabled="disabled"><a  href="javascript:void(0)" onclick="attendPage(${page.previousPageNo})">上一页</a></li>
								</c:when>
								<c:otherwise>
									<li ><a href="javascript:void(0)" onclick="attendPage(${page.previousPageNo})">上一页</a></li>
								</c:otherwise>
								</c:choose>
								
								<c:choose>
								<c:when test="${page.pageNo==page.totalPages }">
									<li><a href="javascript:void(0)" onclick="attendPage(${page.nextPageNo})">下一页</a></li>
								</c:when>
								<c:otherwise>
								<li><a href="javascript:void(0)" onclick="attendPage(${page.nextPageNo})">下一页</a></li>
								</c:otherwise>
								</c:choose>
							
								
						<li><a href="javascript:void(0)" onclick="attendPage(${page.bottomPageNo})">尾页</a></li>
					</ul>
					
					
				</div>
			</div>
		</div>
	</body>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/attendance.js"></script>

</html>