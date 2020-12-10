package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.EmployeePayrollDTO;
import com.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	public EmployeePayrollData getEmployeePayrollDataById(int empid) {
		return employeePayrollList.get(empid-1);
	}

	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empdto) {
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(employeePayrollList.size()+1,empdto);
		employeePayrollList.add(empdata);
		return empdata;
	}

	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empdto) {
		EmployeePayrollData empdata = this.getEmployeePayrollDataById(empId);
		empdata.setName(empdto.name);
		empdata.setSalary(empdto.salary);
		empdata.setGender(empdto.gender);
		empdata.setDepartment(empdto.department);
		empdata.setStartDate(empdto.startDate);
		empdata.setNotes(empdto.notes);
		employeePayrollList.set(empId-1, empdata);
		return empdata;
	}

	public void deleteEmployeePayrollDataById(int empid) {
		employeePayrollList.remove(empid-1);
	}

}
