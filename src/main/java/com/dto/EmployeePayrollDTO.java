package com.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

// Refactored employee payroll dto class to store gender , department , startdate and notes 
public @ToString class EmployeePayrollDTO {

	@Id
	public long employeeId;
	@NotEmpty(message="Employee name cannot be null/invalid")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}",message="Employee Name Invalid")
	public String name;
	@Min(value=400000,message="Salary should be more than 400000")
	@Max(value=500000,message="Salary should be more than 500000")
	public double salary;
	@NotEmpty(message="Employee gender cannot be null/invalid")
	@Pattern(regexp="male|female|Female|Male",message="Gender Invalid")
	public String gender;
	@NotEmpty(message="Employee department cannot be null/Invalid")
	public List<String> department;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@PastOrPresent(message="StartDate should not be past or todays date")
	public Date startDate;
	@NotBlank(message="Profile Pic cannot be blank")
	public String profilePic;
	@NotBlank(message="Notes cannot be blank")
	public String notes;
}
