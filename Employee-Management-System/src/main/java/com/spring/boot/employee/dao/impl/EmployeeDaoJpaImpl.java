package com.spring.boot.employee.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.employee.dao.EmployeeDao;
import com.spring.boot.employee.entity.Employee;
import com.spring.boot.employee.exception.InvalidRequestException;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoJpaImpl.class);
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployees() {
		try {
			logger.info("Inside getEmployees() of JPA DAO Implementation.");
			TypedQuery<Employee> queryString = entityManager.createQuery("from Employee", Employee.class);
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
			logger.info("Inside getEmployee() of JPA DAO Implementation.");
			return entityManager.find(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidRequestException("Provided invalid id of employee. Id: " + id.toString());
		}
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		try {
			logger.info("Inside saveOrUpdateEmployee() of JPA DAO Implementation.");
			entityManager.merge(employee);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidRequestException("Exception occured while saving or updating the list of employees.");
		}
	}

	@Override
	public void deleteEmployee(Integer id) {
		try {
			logger.info("Inside deleteEmployee() of JPA DAO Implementation.");
			Employee employee = entityManager.find(Employee.class, id);
			entityManager.remove(employee);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidRequestException("Provided invalid id of employee. Id: " + id.toString());
		}
	}

}
