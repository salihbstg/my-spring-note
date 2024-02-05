package com.scbcompany.cruddemo.service;

import com.scbcompany.cruddemo.dao.CarsRepository;
import com.scbcompany.cruddemo.dao.EmployeeRepository;
import com.scbcompany.cruddemo.entity.Cars;
import com.scbcompany.cruddemo.entity.Employee;
import com.scbcompany.cruddemo.rest.employee.EmployeeExceptionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final EmployeeRepository employeeRepository;
    private final CarsRepository carsRepository;

    @Autowired
    public ApplicationServiceImpl(EmployeeRepository employeeRepository, CarsRepository carsRepository) {
        this.employeeRepository = employeeRepository;
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByIdEmployee(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new EmployeeExceptionImpl("Employee is not found -" + theId + "-");
        }
        return theEmployee;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Cars> findAllCars() {
        return carsRepository.findAll();
    }

    @Override
    public Cars findByIdCar(int theId) {
        Optional<Cars> result = carsRepository.findById(theId);
        Cars theCars = null;
        if (result.isPresent()) {
            theCars = result.get();
        } else {
            throw new EmployeeExceptionImpl("Cars is not found -" + theId + "-");
        }
        return theCars;
    }

    @Override
    public Cars saveCar(Cars theCar) {
        return carsRepository.save(theCar);
    }

    @Override
    public void deleteCarById(int id) {
        carsRepository.deleteById(id);
    }
}
