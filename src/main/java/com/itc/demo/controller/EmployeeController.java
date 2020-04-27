package com.itc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.demo.exception.EmployeeNotFound;
import com.itc.demo.model.Employee;
import com.itc.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
	List<Employee>	emp = service.getAllEmployees();
	
	return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	
	
	}
	@PostMapping("/save")
	public ResponseEntity<Employee> createOrUpdate(@RequestBody Employee employee){
		
		Employee emp = service.createOrUpdateEmployee(employee);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)throws EmployeeNotFound{
		
	Employee emp =	service.getEmployeeById(id);
		
	return new ResponseEntity<Employee>(emp,HttpStatus.FOUND);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") Integer id)throws EmployeeNotFound{
		
		Employee emp = service.deleteEmployeeById(id);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
}
