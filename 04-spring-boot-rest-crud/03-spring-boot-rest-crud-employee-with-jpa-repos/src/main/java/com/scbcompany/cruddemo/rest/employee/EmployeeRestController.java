package com.scbcompany.cruddemo.rest.employee;

import com.scbcompany.cruddemo.entity.Employee;
import com.scbcompany.cruddemo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employeeapi")
@RestController
public class EmployeeRestController {
    //injection employee service
    private final ApplicationService employeeService;

    public EmployeeRestController(@Qualifier("applicationServiceImpl") ApplicationService employeeService){
    this.employeeService=employeeService;
    }

    //get all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAllEmployee();
    }

    //get employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable("employeeId") int id){
        Employee employee=employeeService.findByIdEmployee(id);
        if(employee==null){
            throw new EmployeeExceptionImpl("Employee is not found -"+id+"-");
        }
        return employee;
    }

    //create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.saveEmployee(employee);
    }

    //update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    //delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String updateEmployee(@PathVariable int employeeId){
        Employee tempEmployee=employeeService.findByIdEmployee(employeeId);
        if(tempEmployee==null){
            throw new EmployeeExceptionImpl("Employee is not found -"+employeeId+"-");
        }
        employeeService.deleteEmployeeById(employeeId);
        return "DELETED!!!"+tempEmployee.toString();
    }
}
