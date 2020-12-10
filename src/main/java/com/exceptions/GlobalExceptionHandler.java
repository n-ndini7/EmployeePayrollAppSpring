package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dto.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ResponseDTO> employeeNotFoundException(EmployeeNotFoundException e) {
		ResponseDTO status = new ResponseDTO(e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
	}

	@ExceptionHandler(DataMissingException.class)
	public final ResponseEntity<ResponseDTO> dataMissingException(DataMissingException e) {
		ResponseDTO status = new ResponseDTO(e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
	}
}