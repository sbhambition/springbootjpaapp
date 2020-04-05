package com.subsharma.springboot.jpa.springbootjpaapp.dao;

import com.subsharma.springboot.jpa.springbootjpaapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoJpa implements IEmployeeDao{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Employee> findAll() {

        //create Query

        TypedQuery<Employee> query = entityManager.createQuery("from com.subsharma.springboot.jpa.springbootjpaapp.entity.Employee" , Employee.class);
        //execute Query

        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findEmployeeById(int id) {


        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee){

        Employee dbEmployee = entityManager.merge(employee);
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query query = entityManager.createQuery("DELETE from com.subsharma.springboot.jpa.springbootjpaapp.entity.Employee where id=:employeeId");
        query.setParameter("employeeId", theId);
        query.executeUpdate();
    }

}

