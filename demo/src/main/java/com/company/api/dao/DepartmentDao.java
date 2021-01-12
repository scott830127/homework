package com.company.api.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.api.entity.Department;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Long> {

	List<Department> findAll(Specification<Department> specification);

}
