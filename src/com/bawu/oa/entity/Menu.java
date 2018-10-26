package com.bawu.oa.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Transient;

/**
 * 菜单实体类
 * 
 * @author penry
 *
 */
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String menuName;
	private String parentId;// 一级菜单时为0
	
	
	private String menuUrl;
	private Integer menuSort;
	private Integer status;// 0：禁用 1：启用 默认：0
	private String icon;
	
	
	//以下属性没有和数据表关联
	//二级菜单关联   二级菜单该属性为空
	private Set<Menu> mbs;
	
	
	public void setMbs(Set<Menu> mbs) {
		this.mbs = mbs;
	}
	
	//@Transient注解代表该属性不会跟数据表做映射关系
	@Transient
	public Set<Menu> getMbs() {
		return mbs;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", parentId=" + parentId + ", menuUrl=" + menuUrl
				+ ", menuSort=" + menuSort + ", status=" + status + ", mbs=" + mbs + "]";
	}

}
