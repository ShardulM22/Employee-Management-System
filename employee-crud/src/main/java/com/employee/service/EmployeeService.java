package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

public interface EmployeeService {
	public List<Employee> getAllEmployee();

	public void addEmployee(Employee employee);

	void deleteById(int id);

	Employee findEmployeeById(int id);

	void updateExistingEmployee(Employee emp);
	
	
	
	
	
}
