package edu.batchmanagement.exception;

public class InvalidImageIdException extends RuntimeException {
	private String message;

	public InvalidImageIdException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}

