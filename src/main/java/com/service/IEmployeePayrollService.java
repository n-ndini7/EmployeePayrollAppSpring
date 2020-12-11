package com.service;

import java.util.List;

import com.dto.EmployeePayrollDTO;
import com.dto.ResponseDTO;
import com.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	ResponseDTO CreateEmpPayrollData(EmployeePayrollDTO empdto);
	ResponseDTO UpdateEmpPayrollData(EmployeePayrollDTO EmployeePayrollDTO,long id);
	ResponseDTO deleteEmpPayrollData(Long id);
	List<EmployeePayrollData> getAllEmpPayroll();
	ResponseDTO getEmpPayrollByID(long id);
}
