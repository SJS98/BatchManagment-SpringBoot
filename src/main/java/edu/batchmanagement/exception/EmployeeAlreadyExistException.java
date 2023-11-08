package edu.batchmanagement.exception;

public class EmployeeAlreadyExistException extends RuntimeException {

	private String message;

	public EmployeeAlreadyExistException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
