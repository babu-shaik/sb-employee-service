package com.itc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeService")
public class Employee {
	
	@Id
	@Column(name="empnumber")
	private int empNo;
	@Column(name="empname")
	private String empName;
	@Column(name="empdesig")
	private String designation;
	@Column(name="salary")
	private double salary;
	public Employee() {
		super();
	}
	public Employee(int empNo, String empName, String designation, double salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.designation = designation;
		this.salary = salary;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
	
	

}
