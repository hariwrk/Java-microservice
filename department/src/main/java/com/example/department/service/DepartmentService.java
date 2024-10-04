package com.example.department.service;

import java.util.List;

import com.example.department.pojo.DepartmentPojo;

public interface DepartmentService {
    public List<DepartmentPojo> getAllDepartment();
    public DepartmentPojo getDepartment();
    public DepartmentPojo addDepartment();
    public DepartmentPojo updateDepartment();
    public void deleteDepartment();
}
