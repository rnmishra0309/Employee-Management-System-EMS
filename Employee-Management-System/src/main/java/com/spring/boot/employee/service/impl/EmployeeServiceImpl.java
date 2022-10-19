package com.spring.boot.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.employee.dao.EmployeeDao;
import com.spring.boot.employee.dao.EmployeeDaoSpringDataJpaRepository;
import com.spring.boot.employee.entity.Employee;
import com.spring.boot.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	/*
	 * @Autowired
	 * @Qualifier("employeeDaoHibernateImpl") 
	 * private EmployeeDao employeeDao;
	 * 
	 */
	
	@Autowired
	@Qualifier("employeeDaoJpaImpl")
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeDaoSpringDataJpaRepository employeeDaoSpringDataJpaRepository;

	@Transactional
	public List<Employee> getEmployees() {
		try {
			return employeeDao.getEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public Employee getEmployee(Integer id) {
		try {
			return employeeDao.getEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void saveOrUpdateEmployee(Employee employee) {
		try {
			employeeDao.saveOrUpdateEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteEmployee(Integer id) {
		try {
			employeeDao.deleteEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 * 
	 * Following are the code for Spring Data JPA Service Impl code.
	 * 
	 *  
	 */

	public List<Employee> findAll() {
		try {
			return employeeDaoSpringDataJpaRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Optional<Employee> findById(Integer id) {
		try {
			return employeeDaoSpringDataJpaRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Employee employee) {
		try {
			employeeDaoSpringDataJpaRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {
		try {
			employeeDaoSpringDataJpaRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
