package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.EmployeePayrollDTO;
import com.exceptions.DataMissingException;
import com.exceptions.EmployeeNotFoundException;
import com.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	public EmployeePayrollData getEmployeePayrollDataById(int empid) {
		EmployeePayrollData empdata = null;
		for (EmployeePayrollData emp : employeePayrollList) {
			if (emp.getEmployeeId() == empid) {
				empdata = emp;
			} else {
				throw new EmployeeNotFoundException("Employee Not Found!");
			}
		}
		return empdata;
	}

	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empdto) {
		if (empdto.name != null) {
			EmployeePayrollData empdata = null;
			empdata = new EmployeePayrollData(employeePayrollList.size() + 1, empdto);
			employeePayrollList.add(empdata);
			return empdata;
		} else {
			throw new DataMissingException("Invalid data!");
		}
	}

	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empdto) {
		if (empdto.getName() != null) {
			EmployeePayrollData empdata = this.getEmployeePayrollDataById(empId);
			empdata.setName(empdto.name);
			empdata.setSalary(empdto.salary);
			empdata.setGender(empdto.gender);
			empdata.setDepartment(empdto.department);
			empdata.setStartDate(empdto.startDate);
			empdata.setNotes(empdto.notes);
			employeePayrollList.set(empId - 1, empdata);
			return empdata;
		} else {
			throw new DataMissingException("Invalid data!");
		}
	}

	public void deleteEmployeePayrollDataById(int empid) {
		for (EmployeePayrollData emp : employeePayrollList) {
			if (emp.getEmployeeId() == empid) {
				employeePayrollList.remove(empid - 1);
			} else {
				throw new EmployeeNotFoundException("Employee Not Found!");
			}
		}
	}
}
