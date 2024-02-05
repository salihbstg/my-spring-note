package com.scbcompany.cruddemo.repository;

import com.scbcompany.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeRepository {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee employee);
    void deleteById(int id);
}
