package edu.batchmanagement.exception;

public class InvalidEmployeeEmailOrPasswordException extends RuntimeException {

	private String message;

	public InvalidEmployeeEmailOrPasswordException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
