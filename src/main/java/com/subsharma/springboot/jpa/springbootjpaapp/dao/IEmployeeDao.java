package com.subsharma.springboot.jpa.springbootjpaapp.dao;

import com.subsharma.springboot.jpa.springbootjpaapp.entity.Employee;

import java.util.List;

public interface IEmployeeDao {

     List<Employee> findAll();

     Employee findEmployeeById(int id);

    void save(Employee employee);

    void deleteById(int id);

}
