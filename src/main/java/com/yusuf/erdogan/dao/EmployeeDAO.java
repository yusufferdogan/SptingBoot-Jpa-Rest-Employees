package com.yusuf.erdogan.dao;

import com.yusuf.erdogan.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void deleteById(int id);
    void delete(Employee employee);
}
