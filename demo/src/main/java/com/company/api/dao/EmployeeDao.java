package com.company.api.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.api.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

	List<Employee> findAll(Specification<Employee> specification);

}
