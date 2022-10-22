package com.spring.boot.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.spring.boot.employee.entity.Employee;
import com.spring.boot.employee.service.EmployeeService;

@Controller
public class EmployeeWebController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String redirectHome() {
		return "redirect:employees";
	}
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", employeeService.getEmployees());
		return "employees";
	}
	
	@PostMapping("/employees")
	public String addEmployee(Employee employee) {
		employeeService.save(employee);
		return "redirect:/";
	}
	
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("employee", employeeService.getEmployee(id));
		return "redirect:/";
	}
	
	@PutMapping(value="/update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println("Errors Detected" + bindingResult.toString());
			return "redirect:/";
		}
		employeeService.save(employee);
		return "redirect:/";
	}
	
	
}
