package com.assetmanagement.service;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.assetmanagement.bean.Employee;
import com.assetmanagement.excpection.EmployeAlreadyExistedException;
import com.assetmanagement.excpection.EmployeeNotFoundException;
import com.assetmanagement.model.EmployeeDTO;

@Repository
@Transactional
public interface EmployeeService {

	public Employee createEmployee(EmployeeDTO employeeDTo) throws EmployeAlreadyExistedException;

	public Employee getEmployee(Long Id) throws EmployeeNotFoundException;

	public List<Employee> list();

	public Employee updateEmployee(EmployeeDTO employee, Long Id) throws EmployeeNotFoundException;
	
	public Employee getEmployeByEmailAndPassword(String email, String password) throws EmployeeNotFoundException;
	
}
