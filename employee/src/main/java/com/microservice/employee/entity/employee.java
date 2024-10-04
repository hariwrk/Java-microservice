package com.microservice.employee.entity;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee_details")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class employee {
    
	@Id
	private long empId;
	private String empName;
	private String empDesignation;
	private long empDeptId;

    
}
