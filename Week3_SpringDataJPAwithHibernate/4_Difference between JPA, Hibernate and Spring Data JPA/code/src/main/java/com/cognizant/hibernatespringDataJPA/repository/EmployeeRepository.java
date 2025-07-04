package com.cognizant.hibernatespringDataJPA.repository;

import com.cognizant.hibernatespringDataJPA.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
