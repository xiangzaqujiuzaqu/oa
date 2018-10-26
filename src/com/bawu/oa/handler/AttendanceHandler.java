package com.bawu.oa.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawu.oa.entity.Attendance;
import com.bawu.oa.entity.User;
import com.bawu.oa.service.AttendanceService;
import com.bawu.oa.utils.IdGeneratorUtil;
import com.bawu.oa.utils.Page;
import com.bawu.oa.utils.StringUtil;

@Controller
@RequestMapping("/attendance")
public class AttendanceHandler {


	@Autowired
	private AttendanceService attendanceService;
		
	@RequestMapping("/list")
	public String list(Map<String,Object> map
						,@RequestParam(value="signInStr",required=false) String signInStr
						,@RequestParam(value="signOutStr",required=false) String signOutStr
						,@RequestParam(value="pageNum",required=false) String pageNum) {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		
		/*
		String ipAddr = StringUtil.getIpAddr(request);
		System.out.println(ipAddr);
		*/
		List<Attendance> list = null;
		Page<Attendance> page = new Page<Attendance>();
		
		//获取当前页数
		int pageNo = pageNum==null?1:Integer.parseInt(pageNum);
		page.setPageNo(pageNo);
		int pageSize = 3;
		page.setPageSize(pageSize);
		
		long count = attendanceService.findCount(user.getId());
		page.setTotalRecords((int)count);
		
		int offset = page.countOffset(pageNo, pageSize);
		
		if(signInStr==null||signOutStr==null||"".equals(signInStr)||"".equals(signOutStr)) {
			
			list =  attendanceService.findAttendanceByUserId(user.getId(),offset,pageSize);
			
		}else {
			
			 String beginDateStr = signInStr+" 00:00:00";
			 String endDateStr  = signOutStr+" 23:59:59";
			 
			 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			 Date beginDate = null;
			 Date endDate = null;
			 
			 try {
				 beginDate = sdf1.parse(beginDateStr);
				 endDate = sdf1.parse(endDateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			list = attendanceService.findSignIn(beginDate, endDate, user.getId(),offset,pageSize);
		}
		
		page.setList(list);
		
		map.put("page", page);
		return "attendance/attendance";
	}
	
	
	/**
	 * 签到
	 * @return
	 */
	@RequestMapping("/signIn")
	@ResponseBody
	public String signIn(HttpServletRequest request) {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		//检查当天是否签到
		Attendance attendance =  checkSignIn(user.getId());
		if(attendance!=null) {
			return "2";//已经签到
		}
		
		try {
			attendance = new Attendance();
			
			attendance.setId(IdGeneratorUtil.generatorId());
			attendance.setIp(StringUtil.getIpAddr(request));
			attendance.setSignIn(new Date());
			attendance.setUserId(user.getId());
			
			attendanceService.save(attendance);
			//签到成功
			return "0";
		} catch (Exception e) {
			//签到失败
			return "1";
			//e.printStackTrace();
		}
		
	}

	/**
	 * 签退
	 */
	@RequestMapping("/signOut")
	
	public String signOut() {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		Attendance checkSignIn = checkSignIn(user.getId());
		if(checkSignIn==null) {
			return "2";//未签到不允许签退
		}
		
		try {
			checkSignIn.setSignOut(new Date());
			attendanceService.save(checkSignIn);
			//签退成功
			return "0";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//签退失败
			return "1";
		}
		
	
	}
	
	

	//检查当天是否签到
	public Attendance checkSignIn(String userId) {
	
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 
		 String today = sdf.format(new Date());
		 
		 String beginDateStr = today+" 00:00:00";
		 String endDateStr  = today+" 23:59:59";
		 
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 Date beginDate = null;
		 Date endDate = null;
		 try {
			 beginDate = sdf1.parse(beginDateStr);
			 endDate = sdf1.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		 List<Attendance> findSignIn = attendanceService.findSignIn(beginDate,endDate,userId,0,0); 
		 
		if(findSignIn.size()<=0) {
			return null;
		}else {
			return findSignIn.get(0);
		} 
		 
	}
	
}
