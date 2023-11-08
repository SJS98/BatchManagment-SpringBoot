package edu.batchmanagement.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private T data;
	
}
