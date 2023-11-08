package edu.batchmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.batchmanagement.dto.ResponseStructure;
import edu.batchmanagement.entity.User;
import edu.batchmanagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@GetMapping("/user/{employeeId}")
	public ResponseEntity<ResponseStructure<User>> findUserByEmployeeId(@PathVariable String employeeId) {
		return service.findUserByEmployeeId(employeeId);
	}

	@GetMapping("/userbybatch/{batchId}")
	public ResponseEntity<ResponseStructure<User>> findUserByBatchId(@PathVariable int batchId) {
		return service.findUserByBatchId(batchId);
	}
}