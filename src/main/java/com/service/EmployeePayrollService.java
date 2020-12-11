package com.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.EmployeePayrollDTO;
import com.dto.ResponseDTO;
import com.exceptions.DataMissingException;
import com.exceptions.EmployeeNotFoundException;
import com.model.EmployeePayrollData;
import com.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	String status = null;
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	public ResponseDTO CreateEmpPayrollData(EmployeePayrollDTO empdto) {
		if (empdto.name != null) {
			EmployeePayrollData empdata = new EmployeePayrollData(empdto);
			employeePayrollRepository.save(empdata);
			status = "Created Employee Payroll Data Successfully";
			return new ResponseDTO(status, empdata);
		}
		throw new DataMissingException("Invalid Data Exception thrown!!");
	}

	public ResponseDTO UpdateEmpPayrollData(EmployeePayrollDTO EmployeePayrollDTO , long id) {
		EmployeePayrollData employeePayroll = employeePayrollRepository.findById(id)
				.get();
		if(EmployeePayrollDTO.getName() ==null) {
			throw new DataMissingException("Invalid Data Exception thrown!!");
		}else {
		if (employeePayroll != null && employeePayroll.getEmployeeId()==id) {
			if (Objects.nonNull(EmployeePayrollDTO.name)) {
				employeePayroll.setName(EmployeePayrollDTO.name);
			}
			if (Objects.nonNull(EmployeePayrollDTO.salary)) {
				employeePayroll.setSalary(EmployeePayrollDTO.salary);
			}
			if (Objects.nonNull(EmployeePayrollDTO.department)) {
				employeePayroll.setDepartment(EmployeePayrollDTO.department);
			}
			if (Objects.nonNull(EmployeePayrollDTO.gender)) {
				employeePayroll.setGender(EmployeePayrollDTO.gender);
			}
			if (Objects.nonNull(EmployeePayrollDTO.startDate)) {
				employeePayroll.setStartDate(EmployeePayrollDTO.startDate);
			}
			if (Objects.nonNull(EmployeePayrollDTO.notes)) {
				employeePayroll.setNotes(EmployeePayrollDTO.notes);
			}
			employeePayrollRepository.save(employeePayroll);
			status = "Updated Employee Payroll Data Successfully";
			return new ResponseDTO(status, employeePayroll);
		}
		else {
			throw new EmployeeNotFoundException("Employee Not Found Exception thrown !! ");
		} 
		}
	}

	public ResponseDTO deleteEmpPayrollData(Long id) {
		EmployeePayrollData empdata = employeePayrollRepository.findById(id)
				.get();
		if(empdata.getName()!=null) {
			employeePayrollRepository.deleteById(empdata.getEmployeeId());
			status = "Deleted Successfully, Deleted ID:" + id;
			return new ResponseDTO(status);
		}
		else {
			throw new EmployeeNotFoundException("Employee Not Found Exception thrown !! ");
		}
	}

	public List<EmployeePayrollData> getAllEmpPayroll() {
		return employeePayrollRepository.findAll().stream().collect(Collectors.toList());
	}
	
	public ResponseDTO getEmpPayrollByID(long id) {
		EmployeePayrollData empdata = employeePayrollRepository.findById(id)
				.get();
		if(empdata.getName()!=null) {
		status = "Get Call Success or Employee Payroll ID : "+id;
		return new ResponseDTO(status, empdata);
		}
		else
		{
			throw new EmployeeNotFoundException("Employee Not Found Exception thrown !! ");
		}
	}
}
