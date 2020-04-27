package com.itc.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.demo.exception.EmployeeNotFound;
import com.itc.demo.model.Employee;
import com.itc.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	public List<Employee> getAllEmployees(){
		
	List<Employee>	emp = repository.findAll();
	
	if(emp.isEmpty()) {
		
		return new ArrayList<Employee>();
	}
	else {
		return emp;
	}
		
	}
	
	public Employee createOrUpdateEmployee(Employee employee) {
		
	Optional<Employee>	opObj = repository.findById(employee.getEmpNo());
	
	if(opObj.isPresent()) {
		
		Employee empObj = opObj.get();
		empObj.setEmpNo(employee.getEmpNo());
		empObj.setDesignation(employee.getDesignation());
		empObj.setEmpName(employee.getEmpName());
		empObj.setSalary(employee.getSalary());
		
		return repository.save(empObj);
		
	}
	else {
		
		return repository.save(employee);
	}
		
	}
	
	public Employee getEmployeeById(Integer id)throws EmployeeNotFound {
		
		Optional<Employee> opObj=  repository.findById(id);
		
		if(opObj.isPresent()) {
			
			return opObj.get();
		}
		else {
			
			throw new EmployeeNotFound("Employee Not Found with this id");
		}
	}
	
	public Employee deleteEmployeeById(Integer id)throws EmployeeNotFound {
		
		 Optional<Employee> opObj =repository.findById(id);
		 
		 if(opObj.isPresent()) {
			 
			 repository.deleteById(id);
			 return opObj.get();
		 }
		 else {
			 
			 throw new EmployeeNotFound("Employee id Not Found can not delete");
		 }
		
	}
	
}
