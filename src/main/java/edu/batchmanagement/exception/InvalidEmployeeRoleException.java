package edu.batchmanagement.exception;

public class InvalidEmployeeRoleException extends RuntimeException {

	private String message;

	public InvalidEmployeeRoleException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
