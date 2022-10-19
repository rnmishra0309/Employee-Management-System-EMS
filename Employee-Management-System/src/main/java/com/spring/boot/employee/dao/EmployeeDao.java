package com.spring.boot.employee.dao;

import java.util.List;

import com.spring.boot.employee.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(Integer id);
	
	public void saveOrUpdateEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);
	
}
