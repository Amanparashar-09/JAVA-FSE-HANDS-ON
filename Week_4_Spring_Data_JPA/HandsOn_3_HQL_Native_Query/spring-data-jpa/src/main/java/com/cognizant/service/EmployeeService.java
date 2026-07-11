package com.cognizant.service;

import com.cognizant.entity.Employee;
import com.cognizant.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional
    public List<Employee> getAllPermanentEmployeesNative() {
        return employeeRepository.getAllPermanentEmployeesNative();
    }
}
