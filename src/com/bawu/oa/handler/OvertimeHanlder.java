package com.bawu.oa.handler;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bawu.oa.entity.Overtime;
import com.bawu.oa.entity.User;
import com.bawu.oa.service.OvertimeService;
import com.bawu.oa.utils.Page;

@Controller
@RequestMapping("/overtime")
public class OvertimeHanlder {

	@Autowired
	private OvertimeService overtimeService;
	
	
	@RequestMapping("/list")
	public String list(Map<String,Object> map
						,@RequestParam(value="pageNum",required=false) String pageNum
						,@RequestParam(value="realName",required=false) String realName) {
		
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		
		int pageNo = pageNum==null?1:Integer.parseInt(pageNum);
		
		int pageSize = 3;
		
		Page<Overtime> page = overtimeService.findOvertimePage(user,pageNo,pageSize);
		map.put("page", page);
		return "attendance/overtime";
	}
	
	
	
	
}
