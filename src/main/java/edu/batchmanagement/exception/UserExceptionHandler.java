package edu.batchmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.batchmanagement.dto.ResponseStructure;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidEmployeeRoleException.class)
	public ResponseEntity<ResponseStructure<String>> catchInvalidEmployeeRoleException(InvalidEmployeeRoleException e) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>(HttpStatus.NO_CONTENT.value(), e.getMessage(),
				"Invalid credintials");
		return new ResponseEntity<>(responseStructure, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<ResponseStructure<String>> catchInvalidEmployeeIdException(InvalidEmployeeIdException e) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>(HttpStatus.NO_CONTENT.value(), e.getMessage(),
				"Invalid credintials");
		return new ResponseEntity<>(responseStructure, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(InvalidEmployeeEmailOrPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> catchInvalidEmployeeEmailOrPasswordException(InvalidEmployeeEmailOrPasswordException e) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>(HttpStatus.NO_CONTENT.value(), e.getMessage(),
				"Invalid credintials");
		return new ResponseEntity<>(responseStructure, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(EmployeeAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchInvalidEmployeeEmailOrPasswordException(EmployeeAlreadyExistException e) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>(HttpStatus.NO_CONTENT.value(), e.getMessage(),
				"Invalid credintials");
		return new ResponseEntity<>(responseStructure, HttpStatus.NO_CONTENT);
	}
}
