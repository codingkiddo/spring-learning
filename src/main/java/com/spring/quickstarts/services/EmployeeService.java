package com.spring.quickstarts.services;

import java.util.List;

import com.spring.quickstarts.model.Employee;

 
public interface EmployeeService {
 
    Employee findById(int id);
     
    void saveEmployee(Employee employee);
     
    List<Employee> findAllEmployees(); 
     
}