package com.example.department.dao;

import com.example.department.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departnmentRepository extends JpaRepository<Department,Long> {
    
}
