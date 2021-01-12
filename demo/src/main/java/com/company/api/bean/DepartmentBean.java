package com.company.api.bean;

import org.springframework.data.annotation.Id;

public class DepartmentBean {
	@Id
	private Long id;
	private String departmentId;
	private String departmentName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "department [id=" + id + ", departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
}
