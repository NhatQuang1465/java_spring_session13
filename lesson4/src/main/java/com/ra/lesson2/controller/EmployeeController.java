package com.ra.lesson2.controller;

import com.ra.lesson2.model.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @GetMapping
    public List<Employee> getEmployees(){
        return List.of(
                new Employee(1, "Nguyen Van A", 1500),
                new Employee(2, "Nguyen Van B", 2000),
                new Employee(3, "Nguyen Van C", 2500)
        );
    }
}
