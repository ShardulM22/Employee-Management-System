package com.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired 
	EmployeeRepository employeerepository;

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeerepository.findAll();

	}

	@Override
	public void addEmployee(Employee employee) {
		employeerepository.save(employee);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteById(int id) {
		employeerepository.deleteById(id);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		return employeerepository.findById(id).get();
	}

	@Override
	public void updateExistingEmployee(Employee emp) {
	    employeerepository.updateEmployee(emp.getId(), emp.getName(), emp.getAge(), emp.getSalary(), emp.getDept());
	}
		
}
