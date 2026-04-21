package com.college.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.college.taskmanager.model.Employee;
import com.college.taskmanager.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee add(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }
}