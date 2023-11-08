package edu.batchmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.batchmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmployeeId(String empId);

	List<User> findByRole(String role);

	User findByEmailAndPassword(String email, String password);

	User findByPhone(long phone);

	User findByEmail(String email);

	@Query("SELECT u FROM User u JOIN u.batches b WHERE b.id = :batchId")
	User findByBatchId(int batchId);

}
