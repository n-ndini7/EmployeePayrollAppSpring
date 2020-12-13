package com.dto;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

// Refactored employee payroll dto class to store gender , department , startdate and notes 
public @Data class EmployeePayrollDTO {

	@Id
	private long employeeId;
	@NotEmpty(message="Employee name cannot be null")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}",message="Employee Name Invalid")
	public String name;
	@Min(value=400000,message="Salary should be more than 400000")
	@Max(value=500000,message="Salary should be more than 500000")
	public double salary;
	public String gender;
	public String department;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public Date startDate;
	public String notes;

	public EmployeePayrollDTO(String name, double salary, String gender, String department, Date startDate,
			String notes) {

		if (validate(gender, department, startDate)) {
			this.gender = gender;
			this.department = department;
			this.startDate = startDate;
			this.notes = notes;
		}
	}

	public static boolean validate(String gender, String department, Date startDate) {
		boolean b3 = (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("male")) ? true : false;
		boolean b4 = department.contains("HR") || department.contains("sales") || department.contains("Engineering")
				|| department.contains("Marketing");
		Date current = Date.valueOf(LocalDate.now());
		boolean b5 = (startDate.before(current)) ? true : false;

		return b3 && b4 && b5;
	}
}
