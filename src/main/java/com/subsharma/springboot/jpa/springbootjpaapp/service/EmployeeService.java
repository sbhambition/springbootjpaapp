package com.subsharma.springboot.jpa.springbootjpaapp.service;

import com.subsharma.springboot.jpa.springbootjpaapp.dao.EmployeeDaoJpa;
import com.subsharma.springboot.jpa.springbootjpaapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeDaoJpa EmployeeDaoJpa;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return EmployeeDaoJpa.findAll();
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) {
        return EmployeeDaoJpa.findEmployeeById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        EmployeeDaoJpa.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        EmployeeDaoJpa.deleteById(id);
    }

}
