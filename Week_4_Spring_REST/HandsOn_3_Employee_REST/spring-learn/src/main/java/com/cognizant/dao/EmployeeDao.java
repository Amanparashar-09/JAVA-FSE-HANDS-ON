package com.cognizant.dao;

import com.cognizant.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeDao {

    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>(Arrays.asList(
        new Employee(1, "Alice", "Engineering", Arrays.asList("Java", "Spring")),
        new Employee(2, "Bob", "HR", Arrays.asList("Recruiting", "Onboarding")),
        new Employee(3, "Charlie", "Engineering", Arrays.asList("React", "Node.js")),
        new Employee(4, "Diana", "Finance", Arrays.asList("Excel", "SAP"))
    ));

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public Employee getEmployeeById(int id) {
        return EMPLOYEE_LIST.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
