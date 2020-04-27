package com.itc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
