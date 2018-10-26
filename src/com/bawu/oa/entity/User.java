package com.bawu.oa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 用户实体类
 * @author penry
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String account;
	private String password;
	private String	realName;
	private Integer	sex; //1 男性  0 女性
	private Integer	age;
	private String	mobile;
	private String	email;
	private Date birthday;
	private String 	identity;
	private Date entryTime;
	private Integer	status;  //0：试用期   1：正式员工    2：离职   默认：2
	private Date createTime;
	
	
	//关联的角色集合	
	private Set<Role> roles;
	private Set<Overtime> overs;
	
	
	public void setOvers(Set<Overtime> overs) {
		this.overs = overs;
	}
	
	
	public Set<Overtime> getOvers() {
		return overs;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", realName=" + realName
				+ ", sex=" + sex + ", age=" + age + ", mobile=" + mobile + ", email=" + email + ", birthday=" + birthday
				+ ", identity=" + identity + ", entryTime=" + entryTime + ", status=" + status + ", createTime="
				+ createTime + "]";
	}
	
}
