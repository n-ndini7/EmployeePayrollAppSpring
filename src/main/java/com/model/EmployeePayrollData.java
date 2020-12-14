package com.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

//Refactored employee payroll dto class to store gender , department , startdate and notes 
@Entity
@Table(name="employee_payroll_data")
public @Data class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employee_id")
	private long employeeId;
	@Column(name="employee_name")
	 private String name;
	    private double salary;
	    private String gender;
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	    private Date startDate;
	    private String notes; 
	    private String profilePic;
	    @ElementCollection
	    @CollectionTable(name="employee_department", joinColumns = @JoinColumn(name="id"))
	    @Column(name="department")
	    private List<String> departments;
	    
	    public EmployeePayrollData() {
	    	
	    }
	    public EmployeePayrollData( EmployeePayrollDTO empdto) {
	    	this.employeeId = empdto.employeeId;
	    	this.name = empdto.name;
	    	this.salary = empdto.salary;
	    	this.gender = empdto.gender;
	    	this.departments = empdto.department;
	    	this.startDate = empdto.startDate;
	    	this.profilePic = empdto.profilePic;
	    	this.notes = empdto.notes;
	    }
}