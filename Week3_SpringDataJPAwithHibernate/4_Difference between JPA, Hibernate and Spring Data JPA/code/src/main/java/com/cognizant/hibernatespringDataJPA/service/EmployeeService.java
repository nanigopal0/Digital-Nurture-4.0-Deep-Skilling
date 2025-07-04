package com.cognizant.hibernatespringDataJPA.service;

import com.cognizant.hibernatespringDataJPA.model.Employee;
import com.cognizant.hibernatespringDataJPA.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SessionFactory sessionFactory;

    public EmployeeService(EmployeeRepository employeeRepository, SessionFactory sessionFactory) {
        this.employeeRepository = employeeRepository;
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public int addEmployeeWithSpringDataJPA(Employee employee) {
        Employee saved = employeeRepository.save(employee);
        return saved.getId();
    }

    public int addEmployeeWithHibernate(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeId = -1;
        try {
            tx = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            log.error(e.getMessage());
        } finally {
            session.close();
        }
        return employeeId;
    }
}
