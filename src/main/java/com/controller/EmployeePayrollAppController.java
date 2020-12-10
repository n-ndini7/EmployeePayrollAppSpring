package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeePayrollDTO;
import com.dto.ResponseDTO;
import com.model.EmployeePayrollData;
import com.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollAppController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	EmployeePayrollData empdata = null;
	String status = null;
	ResponseDTO responsedto = null;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO responsedto = new ResponseDTO("Get Call Successfull", empDataList);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeeePayrollData(@PathVariable("empId") int empId) {
		empdata = employeePayrollService.getEmployeePayrollDataById(empId);
		status = "Get Call for ID Successfull";
		responsedto = new ResponseDTO(status, empdata);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empdto) {
		empdata = employeePayrollService.createEmployeePayrollData(empdto);
		status = "Created Employee Payroll Data Successfully";
		responsedto = new ResponseDTO(status, empdata);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO empdto) {
		empdata = employeePayrollService.updateEmployeePayrollData(empId, empdto);
		status = "Updated Employee Payroll Data Successfully";
		responsedto = new ResponseDTO(status, empdata);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollDataById(empId);
		status = "Deleted Successfully, Deleted ID:" + empId;
		responsedto = new ResponseDTO(status, empdata);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}
}