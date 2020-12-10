package com.controller;

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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollAppController {
	

	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",5000));
		ResponseDTO responsedto = new ResponseDTO("Get Call Successfull",empdata);
		return new ResponseEntity<ResponseDTO>(responsedto,HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeeePayrollData(@PathVariable("empId") int empId){
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",5000));
		ResponseDTO responsedto = new ResponseDTO("Get Call for ID Successfull",empdata);
		return new ResponseEntity<ResponseDTO>(responsedto,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empdto){
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(1,empdto);
		ResponseDTO responsedto = new ResponseDTO("Created Employee Payroll Data Successfully",empdata);
		return new ResponseEntity<ResponseDTO>(responsedto,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empdto){
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(1,empdto);
		ResponseDTO responsedto = new ResponseDTO("Updated EmployeePayroll Data Successfully",empdata);
		return new ResponseEntity<ResponseDTO>(responsedto,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
		ResponseDTO responsedto = new ResponseDTO("Deleted Successfully, Deleted ID:"+empId);
		return new ResponseEntity<ResponseDTO>(responsedto,HttpStatus.OK);
	}
}


