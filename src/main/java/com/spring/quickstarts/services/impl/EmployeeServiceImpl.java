package com.spring.quickstarts.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.quickstarts.dao.EmployeeDao;
import com.spring.quickstarts.model.Employee;
import com.spring.quickstarts.services.EmployeeService;
 
@Service
//@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeDao dao;
     
    @Transactional(readOnly = true)
    public Employee findById(int id) {
        return dao.findById(id);
    }
 
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }
 
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }
 
}