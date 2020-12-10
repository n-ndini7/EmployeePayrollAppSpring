package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.EmployeePayrollDTO;
import com.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> empList = new ArrayList<>();
		empList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000)));
		return empList;
	}

	public EmployeePayrollData getEmployeePayrollDataById(int empid) {
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
		return empdata;
	}

	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empdto) {
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(1,empdto);
		return empdata;
	}

	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empdto) {
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(1,empdto);
		return empdata;
	}

	public void deleteEmployeePayrollDataById(int empid) {

	}

}
