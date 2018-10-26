<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title>加班管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
		<script type="text/javascript">
			//条件查询
			function findOver() {
				var realName = $("#realName").val();
				$("#userForm").submit();
			}
			//分页查询
			function overPage(page) {
				$("#pageNo").val(page);
				findOver();

			}
		</script>
	</head>

	<body>
		<div class="container" style="width: 100%;padding: 25px 15px;">
			<div class="row clearfix">
				<div class="col-md-12 column" style="padding: 20px;">
					<div style="float: left;">
							<input type="button" class="btn btn-primary btn" value="添加" onclick="overtimeHTML('${pageContext.request.contextPath}', 'add');" />
					</div>
					<form action="${pageContext.request.contextPath}/overtime/list" method="post" id="overForm" role="form" class="form-inline" style="float: right;margin-bottom: 10px;">
						<div class="form-group" style="margin-right: 20px;">
							<label for="exampleInputEmail1" style="margin-right: 10px;">姓名</label><input type="text" class="form-control" id="realName" name="realName" placeholder="姓名" />
						</div>
						<input type="hidden" id="pageNo" name="pageNum" value="${page.pageNo}">
						<button type="button" class="btn btn-primary btn" onclick="findOver()">查询</button>
					</form>
					<table class="table table-bordered" style="margin-top: 20px;">
						<thead>
							<tr>
								<th style="display:none">ID</th>
								<th>姓名</th>
								<th>申请时间</th>
								<th>开始时间</th>
								<th>结束时间</th>
								<th>加班时长</th>
								<th>描述</th>
								<th>审批状态</th>
								<th style="width: 150px;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.list }" var="overtime">
                                <tr class="success">
                            
                                <td style="display:none">${overtime.id }</td>
                                <td>${overtime.user.account }</td>
                                <td>${overtime.applicationTime }</td>
                                <td>${overtime.startTime }</td>
                                <td>${overtime.endTime }</td>
                                <td>${overtime.duration }小时</td>
                                <td>${overtime.des }</td>
                                <td>
                                	<c:choose>
                                		<c:when test="${overtime.status==0 }">
                                			未审核
                                		</c:when>
                                		<c:when test="${overtime.status==1 }">
                                			审核成功
                                		</c:when>
                                		<c:otherwise>
                                			审核失败
                                		</c:otherwise>
                                	</c:choose>
                                </td>
                                <td>
                                  <a href="javascript:void(0);" onclick="delOvertime('/OA', 'e72ce48da6904956b3421d74ef5c0dff')" class="btn btn-primary btn">删除</a>
                                  <a href="javascript:void(0);" onclick="detailOvertime('/OA', 'e72ce48da6904956b3421d74ef5c0dff')" class="btn btn-primary btn">修改</a>
                                </td>
                            </tr>
							</c:forEach>
						</tbody>
					</table>
					
					
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/overtime.js"></script>

</html>