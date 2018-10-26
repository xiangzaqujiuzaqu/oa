function menuShow(path, roleId) {
	$.ajax({
		url: path + "/menu/manage/role/menu/auth.action",
		type: "POST",
		data: {roleId: roleId},
		dataType: "JSON",
		success: function(data) {
			$("#condition").html("");
			$("#authTr").html("");
			$("#menuAuthTr").html("");
			
			var roles = data.roles;
			var auths = data.auths;
			var menuAuths = data.menuAuths;
			
			// 遍历角色
			var roleHtml = '<select class="form-control" onchange="menuShow(\''+path+'\',$(this).val())" id="roleSel" style="display: inline-block;width: 200px;" >';
			$.each(roles, function(k, v){
				if (v.id != '1') {
					if (v.id == data.roleId) {
						roleHtml += '<option value="'+v.id+'" selected="selected">'+v.roleName+'</option>';
					} else {
						roleHtml += '<option value="'+v.id+'">'+v.roleName+'</option>';
					}
				}
			});
			roleHtml += '</select>';
			$("#condition").html(roleHtml);
			
			// 遍历权限
			var authHtml = '<th style="width: 280px;">菜单名称</th>';
			$.each(auths, function(k, v){
				authHtml += '<th>' + v.authName + '</th>';
			});
			$("#authTr").html(authHtml);
			// 遍历菜单
			$.each(menuAuths, function(k ,v){
				var menuHtml = '<tr>';
				menuHtml += '<td>' + v.menuName + '</td>';
				$.each(v.auths, function(ka, va){
					menuHtml += '<td><input type="checkbox" name="menuAuth" value="'+v.menuId+'-'+va.authId+'" '+va.isCheck+' '+va.disabled+'>'+va.authName+'</td>';
				});
				menuHtml += '</tr>';
				$("#menuAuthTr").html($("#menuAuthTr").html()+menuHtml);
			});
			
		}, error: function(data) {
			alert("获取菜单数据失败，请联系管理员！");
		}
	});
}

function menuSet(path) {
	var checks = $("#menuAuthTr").find("input[type='checkbox']");
	var menuAuths = new Array();
	$.each(checks, function(){
		if ($(this).prop("checked"))
			menuAuths.push($(this).val());
	});
	$.ajax({
		url: path + "/menu/manage/role/menu/auth/add.action",
		type: "POST",
		data: {roleId: $("#roleSel").val(),menuAuths: menuAuths},
		dataType: "JSON",
		success: function(data) {
			if (data.msg != '' && data.msg != undefined) {
				alert(data.msg);
			} else {
				alert("更新成功！");
				menuShow(path, data.roleId);
			}
		}, error: function(data) {
			alert("系统错误，请联系管理员");
		}
	});
}