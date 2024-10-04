package com.microservice.employee.controller;

import java.util.List;

import com.microservice.employee.dao.employeeRepository;
import com.microservice.employee.entity.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class employeeController {
    
    employeeRepository empRepo;
	
	@Autowired
	public employeeController(employeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	@GetMapping("/employees")
	public List<employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	@GetMapping("/employees/departments/{did}")
	public List<employee> getAllEmployeesByDepartment(@PathVariable long did){
		return empRepo.findByEmpDeptId(did);
	}
	
	@PostMapping("/employees")
	public employee addEmployee(@RequestBody employee newEmp) {
		return empRepo.saveAndFlush(newEmp);
	}
}
