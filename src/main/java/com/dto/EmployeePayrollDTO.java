package com.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.Data;

// Refactored employee payroll dto class to store gender , department , startdate and notes 
@Data
public class EmployeePayrollDTO {

	@Id
	private long employeeId;
	@NotNull
	public String name;
	public double salary;
	public String gender;
	public String department;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public Date startDate;
	public String notes;

	final static String NAME_PATTERN = "^[A-Z]{1}[a-zA-Z]{2,}";

	public EmployeePayrollDTO(String name, double salary, String gender, String department, Date startDate,
			String notes) {

		if (validate(name, salary, gender, department, startDate)) {
			this.name = name;
			this.salary = salary;
			this.gender = gender;
			this.department = department;
			this.startDate = startDate;
			this.notes = notes;
		}
	}

	public static boolean validate(String name, double salary, String gender, String department, Date startDate) {
		boolean b1 = Pattern.matches(NAME_PATTERN, name);
		boolean b2 = (salary >= 400000 && salary <= 500000) ? true : false;
		boolean b3 = (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("male")) ? true : false;
		boolean b4 = department.contains("HR") || department.contains("sales") || department.contains("Engineering")
				|| department.contains("Marketing");
		Date current = Date.valueOf(LocalDate.now());
		boolean b5 = (startDate.before(current)) ? true : false;

		return b1 && b2 && b3 && b4 && b5;
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

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long id) {
		this.employeeId = id;
	}

	@Override
	public String toString() {
		return "name: " + name + ",salary: " + salary + ",gender: " + gender + ",department: " + department
				+ ",startDate: " + startDate + ",notes: " + notes;
	}

}
