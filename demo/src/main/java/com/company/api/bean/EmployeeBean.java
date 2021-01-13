package com.company.api.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class EmployeeBean {
	private Long id;
	private String name;
	private String employeeId;
	private String departmentId;
	private String sex;
	private String phone;
	private String address;
	private Integer age;
	private Date insertDate;
	private Date updateDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", employeeId=" + employeeId + ", departmentId=" + departmentId
				+ ", sex=" + sex + ", phone=" + phone + ", address=" + address + ", age=" + age + ", insertDate="
				+ insertDate + ", updateDate=" + updateDate + "]";
	}
}
