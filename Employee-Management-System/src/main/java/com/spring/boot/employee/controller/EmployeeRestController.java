package com.spring.boot.employee.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.employee.entity.Employee;
import com.spring.boot.employee.exception.InvalidRequestException;
import com.spring.boot.employee.model.ResponseMessage;
import com.spring.boot.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") Integer id) {
		Employee employee = employeeService.getEmployee(id);
		if(employee == null) {
			throw new InvalidRequestException("Provided invalid id of employee. Id: " + id.toString());
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdateEmployee(employee);
		ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), "Employee successfully added.", System.currentTimeMillis());
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdateEmployee(employee);
		ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), "Employee successfully updated.", System.currentTimeMillis());
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Integer id) {
		employeeService.deleteEmployee(id);
		ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), "Employee successfully deleted.", System.currentTimeMillis());
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
	
	/* 
	 * 
	 * Following are the code for Spring Data JPA Service Impl code.
	 * The api to test for Spring Data JPA will prefixed by /api/spring-data-jpa
	 * 
	 */
	
	@GetMapping("/spring-data-jpa/employees")
	public List<Employee> findAllEmployees() {
		logger.info("From Spring Data JPA - findAll()");
		return employeeService.findAll();
	}
	
	@GetMapping("/spring-data-jpa/employees/{employeeId}")
	public Optional<Employee> findByIdEmployee(@PathVariable("employeeId") Integer id) {
		logger.info("From Spring Data JPA - findById()");
		Optional<Employee> employee = employeeService.findById(id);
		if(employee == null) {
			throw new InvalidRequestException("Spring Data JPA - Provided invalid id of employee. Id: " + id.toString());
		}
		return employee;
	}
	
	@PostMapping("/spring-data-jpa/employees")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		logger.info("From Spring Data JPA - save()");
		employeeService.save(employee);
		ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), 
				"Spring Data JPA - Employee successfully added.", System.currentTimeMillis());
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
	@PutMapping("/spring-data-jpa/employees")
	public ResponseEntity<?> mergeOrUpdateEmployee(@RequestBody Employee employee) {
		logger.info("From Spring Data JPA - save() to Update.");
		employeeService.save(employee);
		ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), 
				"Spring Data JPA - Employee successfully updated.", System.currentTimeMillis());
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/spring-data-jpa/employees/{employeeId}")
	public ResponseEntity<?> deleteByIdEmployee(@PathVariable("employeeId") Integer id) {
		logger.info("From Spring Data JPA - deleteById()");
		employeeService.deleteById(id);
		ResponseMessage message = new ResponseMessage(HttpStatus.OK.value(), 
				"Spring Data JPA - Employee successfully deleted.", System.currentTimeMillis());
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
}
