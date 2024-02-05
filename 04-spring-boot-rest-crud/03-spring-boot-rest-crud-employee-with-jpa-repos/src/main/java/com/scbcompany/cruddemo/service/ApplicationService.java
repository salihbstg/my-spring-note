package com.scbcompany.cruddemo.service;

import com.scbcompany.cruddemo.entity.Cars;
import com.scbcompany.cruddemo.entity.Employee;

import java.util.List;

public interface ApplicationService {
    List<Employee> findAllEmployee();
    Employee findByIdEmployee(int theId);
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(int id);
    List<Cars> findAllCars();
    Cars findByIdCar(int theId);
    Cars saveCar(Cars theCar);
    void deleteCarById(int id);
}
