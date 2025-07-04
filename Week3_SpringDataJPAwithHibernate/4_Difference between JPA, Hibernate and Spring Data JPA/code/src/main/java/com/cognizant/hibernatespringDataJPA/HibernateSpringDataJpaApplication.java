package com.cognizant.hibernatespringDataJPA;

import com.cognizant.hibernatespringDataJPA.model.Employee;
import com.cognizant.hibernatespringDataJPA.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HibernateSpringDataJpaApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateSpringDataJpaApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HibernateSpringDataJpaApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        int empId1 = employeeService.addEmployeeWithSpringDataJPA(new Employee( "John Doe", 90102));
        LOGGER.info("Employee added with Spring Data JPA! Employee id: {}", empId1);
        int empId2 = employeeService.addEmployeeWithHibernate(new Employee("Bob", 80102));
        LOGGER.info("Employee added with Hibernate! Employee id: {}", empId2);
    }

}
