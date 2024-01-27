package com.example.EmployeManagement.controller;

import com.example.EmployeManagement.model.Employee;
import com.example.EmployeManagement.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeService employeService;

    //displaying the list of employees.

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listemployee",employeService.getAllEmployees());

        return "index";

    }

    @GetMapping("/ShowNewEmployeeForm")
    public String showNewEmployeeForm(Model model){

        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeService.addEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){

        model.addAttribute("employee",employeService.getEmployeeById(id));
        return "update_Employee";
    }
    @GetMapping("/DeleteEmployee/{id}")
    public String deleteEmp(@PathVariable(value = "id") long id) {
        this.employeService.deleteEmployee(id);
        return "redirect:/";
    }
}
