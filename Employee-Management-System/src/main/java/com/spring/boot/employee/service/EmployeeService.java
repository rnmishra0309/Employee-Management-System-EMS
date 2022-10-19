package com.spring.boot.employee.service;

import java.util.List;
import java.util.Optional;

import com.spring.boot.employee.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee getEmployee(Integer id);

	public void saveOrUpdateEmployee(Employee employee);

	public void deleteEmployee(Integer id);
	
	// Below are the methods declarations for Spring Data JPA Service.
	
	public List<Employee> findAll();
	
	public Optional<Employee> findById(Integer id);

	public void save(Employee employee);

	public void deleteById(Integer id);

}
