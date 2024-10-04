package com.example.department.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.department.dao.departnmentRepository;
import com.example.department.entity.Department;
import com.example.department.pojo.DepartmentPojo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl {
    
    @Autowired
    private departnmentRepository departnmentRepository;

    public List<DepartmentPojo> getAllDepartment(){
        List<Department> depRes = departnmentRepository.findAll();
        List<DepartmentPojo> pojoRes = new ArrayList<>();
        depRes.stream().forEach((obj) -> {
            DepartmentPojo curr = new DepartmentPojo();
            BeanUtils.copyProperties(obj, curr);
            pojoRes.add(curr);
        });

        return pojoRes;
    }

    public DepartmentPojo getDepartment(long id){
        Optional<Department> dep = departnmentRepository.findById(id);
        DepartmentPojo res = null;
        if(dep.isPresent()){
            res = new DepartmentPojo();
            BeanUtils.copyProperties(dep.get(), res);
        }
        return res;
    }

    public DepartmentPojo addDepartment(DepartmentPojo department){
        Department obj = new Department();
        BeanUtils.copyProperties(department, obj);
        departnmentRepository.saveAndFlush(obj);
        return department;
    }

    public DepartmentPojo updateDepartment(DepartmentPojo department){
        Department obj = new Department();
        BeanUtils.copyProperties(department, obj);
        departnmentRepository.saveAndFlush(obj);
        return department;
    }
    public void deleteDepartment(Long id){
        Optional<Department> res = departnmentRepository.findById(id);
        departnmentRepository.delete(res.get());
    }

}
