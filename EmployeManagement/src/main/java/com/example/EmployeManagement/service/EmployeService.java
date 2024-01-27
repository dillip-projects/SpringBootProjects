package com.example.EmployeManagement.service;

import com.example.EmployeManagement.model.Employee;
import com.example.EmployeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id){

        Optional<Employee> optional=employeeRepository.findById(id);
        Employee employee=null;
        if(optional.isPresent()){
            employee=optional.get();
        }
        else{
            throw new RuntimeException("Employee not found");
        }

        return employee;
    }
    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }

}
