package edu.batchmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.batchmanagement.entity.User;
import edu.batchmanagement.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		
		//Generate New Employee ID
		
		
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public void deleteUser(User user) {
		repository.delete(user);
	}

	public User getUserById(int id) {
		Optional<User> optionalUser = repository.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	public User getUserByEmployeId(String empId) {
		return repository.findByEmployeeId(empId);
	}

	public List<User> getUserByRole(String role) {
		return repository.findByRole(role);
	}

	public User getUserByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}

	public User getUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	public User getUserByPhone(long phone) {
		return repository.findByPhone(phone);
	}

	public User getUserByBatchId(int batchId) {
		return repository.findByBatchId(batchId);
	}
}
