package edu.batchmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.batchmanagement.dto.ResponseStructure;

@ControllerAdvice
public class AttendanceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidAttendanceIdException.class)
	public ResponseEntity<ResponseStructure<String>> catchInvalidAttendanceIdException(InvalidAttendanceIdException e) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>(HttpStatus.NO_CONTENT.value(), e.getMessage(),
				null);
		return new ResponseEntity<>(responseStructure, HttpStatus.NO_CONTENT);
	}

}
