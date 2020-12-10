package com.service;

import java.util.List;

import com.dto.EmployeePayrollDTO;
import com.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollDataById(int empid);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empdto);
	
	EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empdto);
	
	void deleteEmployeePayrollDataById(int empid);
}
