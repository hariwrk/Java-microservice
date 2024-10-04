package com.example.department.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="dept_details")

public class Department {

    @Id
    @Column(name="dept_id")
    private Long deptid;

    @Column(name="dept_name")
    private String deptName;

    
}
