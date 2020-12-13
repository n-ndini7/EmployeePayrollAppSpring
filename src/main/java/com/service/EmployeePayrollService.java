package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.EmployeePayrollDTO;
import com.dto.ResponseDTO;
import com.exceptions.EmployeeNotFoundException;
import com.model.EmployeePayrollData;
import com.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	String status = null;
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	public ResponseDTO CreateEmpPayrollData(EmployeePayrollDTO empdto) {
		EmployeePayrollData empdata = new EmployeePayrollData(empdto);
		employeePayrollRepository.save(empdata);
		status = "Created Employee Payroll Data Successfully";
		return new ResponseDTO(status, empdata);
	}

	public ResponseDTO UpdateEmpPayrollData(EmployeePayrollDTO EmployeePayrollDTO, long id) {
		EmployeePayrollData employeePayroll = employeePayrollRepository.findById(id).get();
		if (employeePayroll.getEmployeeId() == id) {
			employeePayroll.setName(EmployeePayrollDTO.name);
			employeePayroll.setSalary(EmployeePayrollDTO.salary);
			employeePayroll.setDepartment(EmployeePayrollDTO.department);
			employeePayroll.setGender(EmployeePayrollDTO.gender);
			employeePayroll.setStartDate(EmployeePayrollDTO.startDate);
			employeePayroll.setNotes(EmployeePayrollDTO.notes);
			employeePayrollRepository.save(employeePayroll);
			status = "Updated Employee Payroll Data Successfully";
			return new ResponseDTO(status, employeePayroll);
		} else {
			throw new EmployeeNotFoundException("Employee not found!");
		}

	}

	public ResponseDTO deleteEmpPayrollData(Long id) {
		EmployeePayrollData empdata = employeePayrollRepository.findById(id).get();
		if (empdata.getName() != null) {
			employeePayrollRepository.deleteById(empdata.getEmployeeId());
			status = "Deleted Successfully, Deleted ID:" + id;
			return new ResponseDTO(status);
		} else {
			throw new EmployeeNotFoundException("Employee Not Found Exception thrown !! ");
		}
	}

	public List<EmployeePayrollData> getAllEmpPayroll() {
		return employeePayrollRepository.findAll().stream().collect(Collectors.toList());
	}

	public ResponseDTO getEmpPayrollByID(long id) {
		EmployeePayrollData empdata = employeePayrollRepository.findById(id).get();
		if (empdata.getName() != null) {
			status = "Get Call Success or Employee Payroll ID : " + id;
			return new ResponseDTO(status, empdata);
		} else {
			throw new EmployeeNotFoundException("Employee Not Found Exception thrown !! ");
		}
	}
}
