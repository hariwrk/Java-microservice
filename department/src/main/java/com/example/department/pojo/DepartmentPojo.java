package com.example.department.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DepartmentPojo {
    private long deptid;
    private String deptName;
    private List<EmployeePojo> allEmployees;

    
}
