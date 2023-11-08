package edu.batchmanagement.service;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.batchmanagement.dao.UserDao;
import edu.batchmanagement.dto.ResponseStructure;
import edu.batchmanagement.entity.User;
import edu.batchmanagement.exception.EmployeeAlreadyExistException;
import edu.batchmanagement.exception.InvalidBatchIdException;
import edu.batchmanagement.exception.InvalidEmployeeEmailOrPasswordException;
import edu.batchmanagement.exception.InvalidEmployeeIdException;
import edu.batchmanagement.exception.InvalidEmployeeRoleException;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {

		boolean isUserExist = false;

		if (userDao.getUserByEmail(user.getEmail()) != null) 
			isUserExist = true;

		if (userDao.getUserByPhone(user.getPhone()) != null) 
			isUserExist = true;

		if (isUserExist)
			throw new EmployeeAlreadyExistException("Employee already exist");
		
		user = userDao.saveUser(user);

		ResponseStructure<User> responseStructure = new ResponseStructure<User>(HttpStatus.CREATED.value(), "success", user);

		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {

		user = userDao.saveUser(user);

		ResponseStructure<User> responseStructure = new ResponseStructure<User>(HttpStatus.OK.value(), "success", user);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<User>> findUserByEmployeeId(String employeeId) {

		User user = userDao.getUserByEmployeId(employeeId);

		if (user == null)
			throw new InvalidEmployeeIdException("No employee found of Employee ID : " + employeeId);

		ResponseStructure<User> responseStructure = new ResponseStructure<User>(HttpStatus.OK.value(), "success", user);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<User>>> findUserByRole(String role) {

		boolean isValidRole = role.equals("HR") || role.equals("Manage") || role.equals("Trainer");

		if (!isValidRole)
			throw new InvalidEmployeeRoleException("No employee found of role : " + role);

		List<User> users = userDao.getUserByRole(role);

		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>(HttpStatus.OK.value(), "success",
				users);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<User>> findUserByEmailAndPassword(String email, String password) {

		User user = userDao.getUserByEmailAndPassword(email, password);

		if (user == null)
			throw new InvalidEmployeeEmailOrPasswordException("Incorrect user email or password");

		ResponseStructure<User> responseStructure = new ResponseStructure<User>(HttpStatus.OK.value(), "success", user);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<User>> findUserByBatchId(int batchId) {

		User user = userDao.getUserByBatchId(batchId);
		
		if (user == null)
			throw new InvalidBatchIdException("No employee found of Batch ID : " + batchId);

		ResponseStructure<User> responseStructure = new ResponseStructure<User>(HttpStatus.OK.value(), "success", user);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
}
