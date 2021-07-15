package com.assetmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetmanagement.bean.Employee;
import com.assetmanagement.excpection.EmployeAlreadyExistedException;
import com.assetmanagement.excpection.EmployeeNotFoundException;
import com.assetmanagement.model.EmployeeDTO;
import com.assetmanagement.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployes() {
		return employeeService.list();
	}

	@PostMapping("/create")
	public Employee createEmployee(@Valid @RequestBody EmployeeDTO employeDTO) throws EmployeAlreadyExistedException {
		return employeeService.createEmployee(employeDTO);
	}

	@GetMapping("/{Id}")
	public Employee getEmployee(@PathVariable Long Id) throws EmployeeNotFoundException {
		return employeeService.getEmployee(Id);
	}

	@PutMapping("/{Id}")
	public Employee updateEmployee(@RequestBody EmployeeDTO employee, @PathVariable Long Id)
			throws EmployeAlreadyExistedException, EmployeeNotFoundException {
		return employeeService.updateEmployee(employee, Id);
	}

	@PostMapping("/login")
	public Employee login(@RequestBody Employee employee) throws EmployeeNotFoundException {
		return employeeService.getEmployeByEmailAndPassword(employee.getEmail(), employee.getPassword());
	}

}
