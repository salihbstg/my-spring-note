package com.scbcompany.cruddemo.dao;

import com.scbcompany.cruddemo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee employee);
    void deleteById(int id);
}
