package com.company.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.api.bean.DepartmentBean;
import com.company.api.bean.EmployeeBean;
import com.company.api.bean.EmployeeDetail;
import com.company.api.service.DepartmentService;
import com.company.api.service.EmployeeService;
import com.company.api.util.StringUtil;

@RestController
@RequestMapping("/api/company")
public class Controller {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	private StringUtil stringUtil;

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.GET, produces = "application/json")
	public void saveEmployee(HttpServletRequest req) {
		String name = (String) req.getAttribute("name");
		String employeeId = (String) req.getAttribute("employeeId");
		String departmentId = (String) req.getAttribute("departmentId");
		String sex = (String) req.getAttribute("sex");
		String phone = (String) req.getAttribute("phone");
		String address = (String) req.getAttribute("address");
		Integer age = (Integer) req.getAttribute("age");
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setName(name);
		employeeBean.setEmployeeId(employeeId);
		employeeBean.setDepartmentId(departmentId);
		employeeBean.setSex(sex);
		employeeBean.setPhone(phone);
		employeeBean.setAddress(address);
		employeeBean.setAge(age);
		employeeService.save(employeeBean);
    }
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET, produces = "application/json")
	public void deleteEmployee(HttpServletRequest req) {
		String employeeId = (String) req.getAttribute("employeeId");
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployeeId(employeeId);
		List<EmployeeBean> employeeBeanList = employeeService.get(employeeBean);
		
		employeeBeanList.stream().forEach(bean ->{
			employeeService.delete(bean.getId());
		});
    }
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET, produces = "application/json")
	public void updateEmployee(HttpServletRequest req) {
		String name = (String) req.getAttribute("name");
		String employeeId = (String) req.getAttribute("employeeId");
		String departmentId = (String) req.getAttribute("departmentId");
		String sex = (String) req.getAttribute("sex");
		String phone = (String) req.getAttribute("phone");
		String address = (String) req.getAttribute("address");
		Integer age = (Integer) req.getAttribute("age");
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployeeId(employeeId);
		List<EmployeeBean> employeeBeanList = employeeService.get(employeeBean);
		
		employeeBeanList.stream().forEach(bean ->{
			bean.setName(name);
			bean.setDepartmentId(departmentId);
			bean.setSex(sex);
			bean.setPhone(phone);
			bean.setAddress(address);
			bean.setAge(age);
			employeeService.update(bean);
		});
    }
	
	@RequestMapping(value = "/saveDepartment", method = RequestMethod.GET, produces = "application/json")
	public void saveDepartment(HttpServletRequest req) {
		String departmentName = (String) req.getAttribute("departmentName");
		String departmentId = (String) req.getAttribute("departmentId");
		
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartmentName(departmentName);
		departmentBean.setDepartmentId(departmentId);
		departmentService.save(departmentBean);
    }
	
	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET, produces = "application/json")
	public void deleteDepartment(HttpServletRequest req) {
		String departmentId = (String) req.getAttribute("departmentId");
		
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartmentId(departmentId);
		List<DepartmentBean> departmentBeanList = departmentService.get(departmentBean);
		
		departmentBeanList.stream().forEach(bean ->{
			departmentService.delete(bean.getId());
		});
    }
	
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.GET, produces = "application/json")
	public void updateDepartment(HttpServletRequest req) {
		String departmentName = (String) req.getAttribute("departmentName");
		String departmentId = (String) req.getAttribute("departmentId");
		
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartmentId(departmentId);
		List<DepartmentBean> departmentBeanList = departmentService.get(departmentBean);
		
		departmentBeanList.stream().forEach(bean ->{
			departmentBean.setDepartmentName(departmentName);
			departmentBean.setDepartmentId(departmentId);
			departmentService.update(bean);
		});
    }
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public List<EmployeeDetail> get(HttpServletRequest req) {
		String name = (String) req.getAttribute("name");
		String employeeId = (String) req.getAttribute("employeeId");
		Integer age = (Integer) req.getAttribute("age");
		String departmentName = (String) req.getAttribute("departmentName");
		String departmentId = null;
		
		List<EmployeeDetail> employeeDetailList = new ArrayList<>();
		
		List<DepartmentBean> departmentBeanList = new ArrayList<>();
		if (stringUtil.isNotEmpty(departmentName)) {
			DepartmentBean departmentBean = new DepartmentBean();
			departmentBean.setDepartmentName(departmentName);
			departmentBeanList = departmentService.get(departmentBean);
			departmentId = departmentBeanList.stream().findFirst().get().getDepartmentId();
		}
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployeeId(employeeId);
		employeeBean.setName(name);
		employeeBean.setAge(age);
		employeeBean.setDepartmentId(departmentId);
		List<EmployeeBean> employeeBeanList = employeeService.get(employeeBean);
		employeeBeanList.stream().forEach(bean -> {
			EmployeeDetail employeeDetail = new EmployeeDetail();
			BeanUtils.copyProperties(bean, employeeDetail);
			
			DepartmentBean departmentBean = new DepartmentBean();
			departmentBean.setDepartmentId(bean.getDepartmentId());
			employeeDetail.setDepartmentName(departmentService.get(departmentBean).get(0).getDepartmentName());
			employeeDetailList.add(employeeDetail);
		});
		
		return employeeDetailList;
    }
}
