package com.scbcompany.cruddemo.rest;

import com.scbcompany.cruddemo.entity.Employee;
import com.scbcompany.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class EmployeeRestController {
    //injection employee service
    private final EmployeeService employeeService;

    public EmployeeRestController(@Qualifier("employeeServiceImpl") EmployeeService employeeService){
    this.employeeService=employeeService;
    }

    //get all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //get employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable("employeeId") int id){
        Employee employee=employeeService.findById(id);
        if(employee==null){
            throw new EmployeeExceptionImpl("Employee is not found -"+id+"-");
        }
        return employee;
    }

    //create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    //update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    //delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String updateEmployee(@PathVariable int employeeId){
        Employee tempEmployee=employeeService.findById(employeeId);
        if(tempEmployee==null){
            throw new EmployeeExceptionImpl("Employee is not found -"+employeeId+"-");
        }
        employeeService.deleteById(employeeId);
        return "DELETED!!!"+tempEmployee.toString();
    }
}
