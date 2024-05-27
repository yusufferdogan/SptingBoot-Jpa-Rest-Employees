package com.yusuf.erdogan.rest;

import com.yusuf.erdogan.entity.Employee;
import com.yusuf.erdogan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee =  employeeService.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }
        return employee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        //force to save new item
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.update(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
    }
}
