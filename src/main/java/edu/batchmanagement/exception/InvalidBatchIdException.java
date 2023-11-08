package edu.batchmanagement.exception;

public class InvalidBatchIdException extends RuntimeException {

	private String message;

	public InvalidBatchIdException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
