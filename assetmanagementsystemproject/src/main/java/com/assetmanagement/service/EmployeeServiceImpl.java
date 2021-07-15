package com.assetmanagement.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.bean.Employee;
import com.assetmanagement.excpection.EmployeAlreadyExistedException;
import com.assetmanagement.excpection.EmployeeNotFoundException;
import com.assetmanagement.model.EmployeeDTO;
import com.assetmanagement.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee createEmployee(EmployeeDTO employeeDTO) throws EmployeAlreadyExistedException {
		List<Employee> employees = employeeRepository.findByEmail(employeeDTO.getEmail());
		if (employees.isEmpty()) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeDTO, employee);
			employee.setPassword(Base64.getEncoder().encodeToString(employee.getPassword().getBytes()));
			return employeeRepository.save(employee);
		}else {
			throw new EmployeAlreadyExistedException("Employee Alredy Existed with email "+employeeDTO.getEmail());
		}
	}
	@Override
	public Employee getEmployee(Long id) throws EmployeeNotFoundException {

		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee Deatils Not Found for Id " + id);
		} else {
			return employee.get();
		}
	}

	@Override
	public List<Employee> list() {

		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(EmployeeDTO employeeDto, Long id) throws EmployeeNotFoundException {

		Optional<Employee> emOptional = employeeRepository.findById(id);
		Employee employee = getEmployeDetails(emOptional);
		
		if(null != employeeDto.getFirstName()) {
			employee.setFirstName(employeeDto.getFirstName());
		}
		if(null != employeeDto.getLastName()) {
			employee.setLastName(employeeDto.getLastName());
		}
		if(null != employeeDto.getEmail()) {
			employee.setEmail(employeeDto.getEmail());
		}
		if(null != employeeDto.getPassword()) {
			employee.setPassword(employeeDto.getPassword());
		}
//		if(null != employeeDto.getRole()) {
//			employee.setRole(employeeDto.getRole());
//		}
		System.out.println(employee+"updated");
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeByEmailAndPassword(String email, String password) throws EmployeeNotFoundException {
		
	    String pwd = Base64.getEncoder().encodeToString(password.getBytes());	
		List<Employee> employees = employeeRepository.findByEmailAndPassword(email, pwd);
		Optional<Employee> empOptional = employees.stream().findFirst();

		return getEmployeDetails(empOptional);
	}

	private Employee getEmployeDetails(Optional<Employee> employeeOptional) throws EmployeeNotFoundException {
		if (employeeOptional.isPresent()) {
			return employeeOptional.get();
		} else {
			throw new EmployeeNotFoundException("Employee Details not found ");
		}
	}
	
	public void updateEmployee(Employee employee, Long Id) {
		
		 employeeRepository.save(employee);
		 System.out.println(employee);
		 
	}

	
}
