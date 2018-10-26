function menu(path) {
	//mock数据模拟
	$.post(path+"/user/menus",{"time":new Date()},function(data){
		
		$("#main-nav").html('');
		$.each(data, function(k, v){
			var $li = $('<li></li>');
			var $menuOne_a = $('<a href="#systemSetting'+k+'" onclick="menuCss(this)" class="nav-header collapsed" data-toggle="collapse"></a>');
			var $menuOne_i = $('<i class="'+v.icon+'"></i>');
			var $menuOne_text = $('<span style="display: inline-block;margin-left: 20px;">'+v.menuName+'</span>');
			var $menuOne_sapn = $('<span class="pull-right glyphicon glyphicon-chevron-down"></span>');
			$menuOne_i.appendTo($menuOne_a);
			$menuOne_text.appendTo($menuOne_a);
			$menuOne_sapn.appendTo($menuOne_a);
			var $ul = $('<ul id="systemSetting'+k+'" class="nav nav-list collapse secondmenu" style="heigth: 0px;padding-left:2px;padding-right: 3px;"></ul>');
			$.each(v.mbs, function (k2, v2){
				var $menuTow = $('<li><a href="' + path + v2.menuUrl + '" onclick="menuCss(this)" target="content" style="padding-left:25px;">' + v2.menuName + '</a></li>');
				$menuTow.appendTo($ul);
			});
			
			$menuOne_a.appendTo($li);
			$ul.appendTo($li);
			$li.appendTo($("#main-nav"));
			
		});
	},"json");
	
	
	
	
/*	$.ajax({
		url: path + "/login/menu.action",
		type: "POST",
		dataType: "JSON",
		success: function(data) {
			$("#main-nav").html('');
			$.each(data, function(k, v){
				var $li = $('<li></li>');
				var $menuOne_a = $('<a href="#systemSetting'+k+'" onclick="menuCss(this)" class="nav-header collapsed" data-toggle="collapse"></a>');
				var $menuOne_i = $('<i class="'+v.icon+'"></i>');
				var $menuOne_text = $('<span style="display: inline-block;margin-left: 20px;">'+v.menuName+'</span>');
				var $menuOne_sapn = $('<span class="pull-right glyphicon glyphicon-chevron-down"></span>');
				$menuOne_i.appendTo($menuOne_a);
				$menuOne_text.appendTo($menuOne_a);
				$menuOne_sapn.appendTo($menuOne_a);
				var $ul = $('<ul id="systemSetting'+k+'" class="nav nav-list collapse secondmenu" style="heigth: 0px;padding-left:2px;padding-right: 3px;"></ul>');
				$.each(v.menuList, function (k2, v2){
					var $menuTow = $('<li><a href="' + path + v2.menuUrl + '" onclick="menuCss(this)" target="content" style="padding-left:25px;">' + v2.menuName + '</a></li>');
					$menuTow.appendTo($ul);
				});
				
				$menuOne_a.appendTo($li);
				$ul.appendTo($li);
				$li.appendTo($("#main-nav"));
				
			});
		},error: function(data) {
			alert("菜单获取失败");
		}
	});*/
}

/**
 * 设置菜单样式
 * @param t
 */
function menuCss(t) {
	if ($(t).next().length > 0) {
		$(t).parent().siblings().removeClass("active");
		$(t).parent().siblings().children("a").children("span").css("color", "");
		$(t).parent().addClass("active");
		$(t).children("span").css("color", "#fff");
	} else {
		$(t).parent().parent().parent().siblings().removeClass("active");
		var clazz = $(t).parent().parent().parent().attr("class");
		if (clazz != 'active') {
			$(t).parent().parent().parent().addClass("active");
		}
		$(t).parent().parent().parent().parent().children("li").children("ul").children("li").removeClass("lia");
		$(t).parent().addClass("lia");
		$(t).parent().parent().parent().siblings().children("a").children("span").css("color", ""); 
		$(t).parent().parent().parent().children("a").children("span").first().css("color", "#fff"); 
	}
}
