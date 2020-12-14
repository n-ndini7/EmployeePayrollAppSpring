package com.exceptions;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ResponseDTO> employeeNotFoundException(EmployeeNotFoundException e) {
		ResponseDTO status = new ResponseDTO(e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
	}

	@ExceptionHandler(SQLException.class)
	public final ResponseEntity<ResponseDTO> QueryException(SQLException e) {
		ResponseDTO status = new ResponseDTO("SQL exception thrown!!");
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<ResponseDTO> NoElementException(NoSuchElementException e) {
		ResponseDTO status = new ResponseDTO("Employee does not exist!!");
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseDTO> AnonymousException(Exception e) {
		ResponseDTO status = new ResponseDTO("Exception thrown!! \nCan't process your request.");
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO response = new ResponseDTO("Exception while processing REST request",errMsg);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
		log.error("Invalid Date Format",exception);
		ResponseDTO response = new ResponseDTO("Exception while processing REST request \n Should have Date in the format dd MM yyyy");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST);
	}
}