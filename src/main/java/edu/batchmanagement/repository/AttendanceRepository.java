package edu.batchmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.batchmanagement.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

	@Query("SELECT b.attendances FROM Batch b WHERE b.id=:batchId")
	List<Attendance> findByBatchId(int batchId);
	
}
