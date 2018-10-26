package com.bawu.oa.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bawu.oa.entity.Menu;
import com.bawu.oa.entity.Role;
import com.bawu.oa.entity.User;

@Controller
@RequestMapping("/user")
public class UserHandler {
	
	
	@RequestMapping(value="/menus",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String menus() {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		
		if(user==null) {
			return "error";   
		}
		
		Set<Role> roles = user.getRoles();
		Set<Menu> menus = new LinkedHashSet<Menu>();
		//菜单去重
		for (Role role : roles) {
			Set<Menu> menus2 = role.getMenus();
			menus.addAll(menus2);
		}
		
		//返回菜单实体json
		List<Menu> mbs = new ArrayList<>();
		for (Menu menuParent:menus){
			//找到父菜单下的子菜单
			//找到所有父菜单 parentId==0代表父菜单
			if("0".equals(menuParent.getParentId())) {
				
				//二级菜单列表
				Set<Menu> mblis2= new HashSet<>();
				for (Menu menu2:menus) {
					//找到父菜单下的子菜单
					if(!menuParent.getId().equals(menu2.getId())&&menuParent.getId().equals(menu2.getParentId())) {
						mblis2.add(menu2);
					}
					
				}
				menuParent.setMbs(mblis2);
				mbs.add(menuParent);
			}
			
		}
		
		String mbsJson = JSON.toJSONString(mbs,SerializerFeature.WriteMapNullValue);
		
		return mbsJson;
	}
	
	
	@RequestMapping("/logout")
	public String logout() {
		Subject user = SecurityUtils.getSubject();
		user.logout();     
		return "redirect:/login.jsp";
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("account") String account,
						@RequestParam("password") String password,
						Map<String,Object> map) {
		
		//获取Subject对象(当前用户)
		Subject user = SecurityUtils.getSubject();
		
		if(isLogin(user)){
			return "redirect:/index.jsp";
		}else {
			String result  = shiroLogin(user,account,password);
			if("succ".equals(result)) {
				return "redirect:/index.jsp";
			}else {
				return "redirect:/login.jsp";
			}
		}
		
	}

	private boolean isLogin(Subject user) {
		if(user.isAuthenticated()) {
			return true;
		}else {
			return false;
		}
	}
	
	private String shiroLogin(Subject user,String account,String password) {
	
		
		
		//将用户名和密码封装为UsernamePasswordToken
		UsernamePasswordToken upt = new UsernamePasswordToken(account,password);
		
		////记住我
		upt.setRememberMe(true);
        try {
        	//执行登录操作
        	//System.out.println(upt.hashCode());
        	
            user.login(upt);
            
        } catch (UnknownAccountException uae) {
        	//用户名不存在
        	System.out.println("用户名不存在");
        	//map.put("msg", "用户名不存在");
        	return "error";
        } catch (IncorrectCredentialsException ice) {
        	//密码有误
        	System.out.println("密码错误");
        	//map.put("msg", "密码错误");
        	return "error";
        } catch (LockedAccountException lae) {
        	System.out.println("用户被锁定");
        	//map.put("msg", "用户被锁定");
        	return "error";
        }
        catch (AuthenticationException ae) {
        	System.out.println("系统异常，请联系管理员........");
        	//map.put("msg", "系统异常，请联系管理员........");
        	return "error";
        }
        
        return "succ";
				
	}
	
	

}
