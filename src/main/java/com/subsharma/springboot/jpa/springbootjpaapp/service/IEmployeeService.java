package com.subsharma.springboot.jpa.springbootjpaapp.service;

import com.subsharma.springboot.jpa.springbootjpaapp.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    Employee findEmployeeById(int id);

    void save(Employee employee);

    void deleteById(int id);

}
