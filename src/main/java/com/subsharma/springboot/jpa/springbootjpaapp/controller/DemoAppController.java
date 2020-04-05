package com.subsharma.springboot.jpa.springbootjpaapp.controller;

import com.subsharma.springboot.jpa.springbootjpaapp.entity.Employee;
import com.subsharma.springboot.jpa.springbootjpaapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoAppController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/employees")
    public List<Employee> addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employeeService.findAll();
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

         employeeService.save(employee);
         return employee;

    }

    @DeleteMapping("/employees/{employeeId}")
    public List<Employee> deleteEmployee(@PathVariable int  employeeId){

        employeeService.deleteById(employeeId);
        return employeeService.findAll();
    }
}
