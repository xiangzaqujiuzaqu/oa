package com.bawu.oa.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * 角色实体类
 * 
 * @author penry
 *
 */

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String roleName;
	private String parentId;
	private String describe;

	// 关联的menu的属性集合
	private Set<Menu> menus;
	
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	public Set<Menu> getMenus() {
		return menus;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentId() {
		return parentId;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", parentId=" + parentId + ", describe=" + describe + "]";
	}

}
