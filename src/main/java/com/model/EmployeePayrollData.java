package com.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

//Refactored employee payroll dto class to store gender , department , startdate and notes 
@Entity
@Table(name="Employee_Payroll_Data")
public class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;
	 private String name;
	    private double salary;
	    private String gender;
	    private String department;
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	    private Date startDate;
	    private String notes; 

	    public EmployeePayrollData() {
	    	
	    }
	    public EmployeePayrollData( EmployeePayrollDTO empdto) {
	    	this.employeeId = empdto.getEmployeeId();
	    	this.name = empdto.getName();
	    	this.salary = empdto.getSalary();
	    	this.gender = empdto.getGender();
	    	this.department = empdto.getDepartment();
	    	this.startDate = empdto.getStartDate();
	    	this.notes = empdto.getNotes();
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
		
		public long getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(long employeeId) {
			this.employeeId = employeeId;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
		}

}