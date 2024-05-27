package com.yusuf.erdogan.service;

import com.yusuf.erdogan.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void deleteById(int id);
}
