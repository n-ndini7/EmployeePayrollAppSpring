package com.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeePayrollDTO {

    public String name;
    public double salary;
    public String gender;
    public String department;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public Date startDate;
    public String notes; 
    

    public EmployeePayrollDTO(String name, double salary,String gender , String department , Date startDate , String notes) {
    	this.name = name;
    	this.salary = salary;
    	this.gender = gender;
    	this.department = department;
    	this.startDate = startDate;
    	this.notes = notes;
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

	@Override
	public String toString() {
		return "name: " + name + ",salary: " + salary+",gender: "+gender+",department: "+department+",startDate: "+startDate+",notes: "+notes;
	}

}
