package com.microservice.employee.dao;

import java.util.List;

import com.microservice.employee.entity.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<employee,Long> {
    List<employee> findByEmpDeptId(long deptId);
}
