package com.model;

import com.dto.EmployeePayrollDTO;

public class EmployeePayrollData {

	private int employeeId;
	 public String name;
	    public double salary;

	    public EmployeePayrollData(int employeeId , EmployeePayrollDTO empdto) {
	    	this.setEmployeeId(employeeId);
	    	this.name = empdto.getName();
	    	this.salary = empdto.getSalary();
	    }
	    
	    public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	    
		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}
		
		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

}
