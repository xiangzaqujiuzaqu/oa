package com.bawu.oa.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.bawu.oa.entity.User;
import com.bawu.oa.service.UserService;

public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	
	//授权的回调函数
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		return null;
	}

	//认证的回调函数	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			//AuthenticationToken 强转为 UserNamePasswordToken
				UsernamePasswordToken  upToken= (UsernamePasswordToken) token;
				
				//获取用户名
				String account = upToken.getUsername();
				
				
				//根据用户名查询数据库  获取user对象
				User user =  userService.getUserByAccount(account);
				
				 SecurityUtils.getSubject().getSession().setAttribute("user", user);
				
			     //shiro中密码的比对
			     //根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
			     //principal：用户的认证实体信息
			     Object principal = user.getAccount();
			     //用于的凭证信息
			     Object credentials = user.getPassword();
			 
			     //
			     ByteSource credentialsSalt = ByteSource.Util.bytes(user.getAccount());
			     
			     //realmName  realm的name，我们只需要调用其父类的getName()
			     String realmName = getName();
			     
			     SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,realmName);
				
			     return info;
			}

			public static void main(String[] args) {
				
				String hashAlgorithmName = "MD5";
				Object credentials = "123456";
				//使用盐值加密
				Object salt = "admin";
				int hashIterations = 1024;
				SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
				System.out.println(simpleHash);
	}

}
