package edu.batchmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.batchmanagement.entity.Batch;


@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer>{

	@Query("SELECT u.batches FROM User u WHERE u.employeeId=:employeeId")
	List<Batch> findByEmployeeId(String employeeId);
	
}
