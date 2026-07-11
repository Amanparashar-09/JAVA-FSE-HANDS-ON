package com.cognizant;

import com.cognizant.entity.Employee;
import com.cognizant.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        testGetAllPermanentEmployees();
        testGetAllPermanentEmployeesNative();
    }

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);
        employees.forEach(e -> LOGGER.debug("Skills: {}", e.getSkillList()));
        LOGGER.info("End");
    }

    private static void testGetAllPermanentEmployeesNative() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployeesNative();
        LOGGER.debug("Permanent Employees (Native): {}", employees);
        LOGGER.info("End");
    }
}
