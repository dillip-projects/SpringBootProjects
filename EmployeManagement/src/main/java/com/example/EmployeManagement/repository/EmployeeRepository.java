package com.example.EmployeManagement.repository;

import com.example.EmployeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
