package com.assetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assetmanagement.bean.Employee;


@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findByEmailAndPassword(String email, String password);
	
	public List<Employee> findByEmail(String email);
}
