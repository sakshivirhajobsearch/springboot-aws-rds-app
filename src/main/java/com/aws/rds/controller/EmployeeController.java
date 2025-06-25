package com.aws.rds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aws.rds.model.Employee;
import com.aws.rds.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/")
	public String viewEmployees(Model model) {
		List<Employee> list = repository.getAllEmployees();
		model.addAttribute("employees", list);
		return "employees";
	}
}
