package edu.batchmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.batchmanagement.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

	@Query("SELECT a.image FROM Attendance a WHERE a.id=:attendanceId")
	Image findByAttendanceId(int attendanceId);
	
}
