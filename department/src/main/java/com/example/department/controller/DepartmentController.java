package com.example.department.controller;

import java.util.List;

import com.example.department.pojo.DepartmentPojo;
import com.example.department.pojo.EmployeePojo;
import com.example.department.service.DepartmentServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    
    @Autowired
    private DepartmentServiceImpl depservice;

    public static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/departments")
    public List<DepartmentPojo> getAllDepartment(){
        LOG.info("in getAlldepartment");
        return depservice.getAllDepartment();
    }

    @GetMapping("/departments/{id}")
    @CircuitBreaker(name="ciremp", fallbackMethod = "fallbackEmployee")
    public DepartmentPojo getDepartment(@PathVariable Long id){
        LOG.info("in getDepartment");
        DepartmentPojo deptPojo = depservice.getDepartment(id);
        RestClient restClient = RestClient.create();
        List<EmployeePojo> allEmps = restClient.get().uri("http://localhost:8082/api/employees/departments/"+id)
            .retrieve()
            .body(List.class);
        deptPojo.setAllEmployees(allEmps);
        return deptPojo;
    }
    
    public DepartmentPojo fallbackEmployee(){
        return new DepartmentPojo(0,"fallback",null);
    }

    public String fallbackEmployee(Exception e) {
		return "employee-service failed...";
	 }


    @PostMapping("/departments")
    public DepartmentPojo addDepartment(@RequestBody DepartmentPojo department){
        LOG.info("in addDepartment");
        return depservice.addDepartment(department);
    }

    @PutMapping("/departments")
    public DepartmentPojo updateDepartment(@RequestBody DepartmentPojo department){
        LOG.info("in updateDepartment");
        return depservice.updateDepartment(department);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") Long id){
        LOG.info("in deleteDepartment");
        depservice.deleteDepartment(id);
    }


}
