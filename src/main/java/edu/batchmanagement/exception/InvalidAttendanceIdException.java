package edu.batchmanagement.exception;

public class InvalidAttendanceIdException extends RuntimeException {
	private String message;

	public InvalidAttendanceIdException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}

