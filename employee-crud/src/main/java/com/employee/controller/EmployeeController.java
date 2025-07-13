package com.employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.serviceImpl.EmployeeServiceImpl;


@Controller
public class EmployeeController  { 
	
	@Autowired
	EmployeeServiceImpl employeeservice ;
	

	@GetMapping("/")
	public String openRegistrationPage() {
		return "home";
	}
	
	
//	@PostMapping("/login")
//	public String (@ModelAttribute Employee employee) {
//		employeeservice.addEmployee(employee);
//		return "redirect:/home";
//	}
	
	@GetMapping("/home")
	public String getAllEmployee(Model model ) {
		List<Employee>getAllEmployee= employeeservice.getAllEmployee();
		model.addAttribute("getAllEmployee", getAllEmployee);
		return "EmployeeList";
		
		
		
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
	    // Add any necessary model attributes if needed
	    return "AddNewEmployee"; // Assuming "addEmployee.html" is your registration page template
	}

	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee) {
		employeeservice.addEmployee(employee);
		return "redirect:/home";
	}
	
	
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id) {
	    employeeservice.deleteById(id);
	    return "redirect:/home"; // Make sure you have a "/home" endpoint in your application
	}
	
	@GetMapping("/openUpdateForm/{id}")
	public String openUpdateForm(Model model,@PathVariable("id") int id) {
		Employee employee= employeeservice.findEmployeeById(id);
		System.out.println(employee);
		model.addAttribute("employee",employee);
		return "UpdateForm";		
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute Employee updatedEmployee) {
	    int id = updatedEmployee.getId();
	    Employee existingEmployee = employeeservice.findEmployeeById(id);

	    if (existingEmployee != null) {
	        // Update the existing employee's information with the new data
	        existingEmployee.setName(updatedEmployee.getName());
	        existingEmployee.setEmail(updatedEmployee.getEmail());
	        // Update other fields as needed

	        // Save the updated employee
	        employeeservice.updateExistingEmployee(existingEmployee);

	        return "redirect:/home"; // Redirect to the home page after successful update
	    } else {
	        // Handle the case where the employee with the given ID is not found
	        // You can display an error message or handle it as needed
	        return "error"; // Redirect to an error page or handle it accordingly
	    }
	}

	
	
	
	
//	@PostMapping("/updateEmployee")
//	public String updateExistingEmployee(@ModelAttribute Employee employee) {
//		System.out.println("new employee" +employee);
//		int id=employee.getId();
//		System.out.println(id);
//		//System.out.println("new employee" +employee);
//		Employee emp = employeeservice.findEmployeeById(id);
////		System.out.println(emp);
//		employeeservice.updateExistingEmployee(emp);
//		
//		return "redirect:/home";
//	}
	
	
	
	
//	@GetMapping("/login")
//    public String login(Model model) {
//        return "login";
//    }

	


	
	
	
	
}
