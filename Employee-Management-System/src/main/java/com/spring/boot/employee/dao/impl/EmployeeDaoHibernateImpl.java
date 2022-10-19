package com.spring.boot.employee.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.employee.dao.EmployeeDao;
import com.spring.boot.employee.entity.Employee;
import com.spring.boot.employee.exception.InvalidRequestException;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoHibernateImpl.class);
	
	/*
	 * @Autowired 
	 * private SessionFactory sessionFactory;
	 * 
	 */
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployees() {
		try {
			logger.info("Inside getEmployees() of Hibernate DAO Implementation.");
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Employee> queryString = currentSession.createQuery("from Employee", Employee.class);
			List<Employee> employeeList = queryString.getResultList();
			return employeeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidRequestException("Exception occured while getting the list of employees.");
		}
	}

	@Override
	public Employee getEmployee(Integer id) {
		try {
			logger.info("Inside getEmployee() of Hibernate DAO Implementation.");
			Session currentSession = entityManager.unwrap(Session.class);
			return currentSession.get(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidRequestException("Provided invalid id of employee. Id: " + id.toString());
		}
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		try {
			logger.info("Inside saveOrUpdateEmployee() of Hibernate DAO Implementation.");
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.saveOrUpdate(employee);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidRequestException("Exception occured while saving or updating the list of employees.");
		}
	}

	@Override
	public void deleteEmployee(Integer id) {
		try {
			logger.info("Inside deleteEmployee() of Hibernate DAO Implementation.");
			Session currentSession = entityManager.unwrap(Session.class);
			Employee employee = currentSession.get(Employee.class, id);
			currentSession.delete(employee);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidRequestException("Provided invalid id of employee. Id: " + id.toString());
		}
	}

}
