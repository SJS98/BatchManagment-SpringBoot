package edu.batchmanagement.exception;

public class InvalidEmployeeIdException extends RuntimeException {

	private String message;

	public InvalidEmployeeIdException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
