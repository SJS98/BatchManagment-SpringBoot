package edu.batchmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.batchmanagement.entity.Attendance;
import edu.batchmanagement.repository.AttendanceRepository;

@Repository
public class AttendanceDao {

	@Autowired
	private AttendanceRepository repository;
	
	public Attendance saveAttendance(Attendance attendance) {
		return repository.save(attendance);
	}
	
	public Attendance updateAttendance(Attendance attendance) {
		return repository.save(attendance);
	}

	public void deleteAttendance(Attendance attendance) {
		repository.delete(attendance);
	} 

	public void deleteAttendanceById(int attendanceId) {
		repository.deleteById(attendanceId);
	} 
	
	public Attendance getAttendanceById(int attendanceId) {
		Optional<Attendance> optionalAttendance = repository.findById(attendanceId);
		return optionalAttendance.isPresent()?optionalAttendance.get():null;
	}
	
	public List<Attendance> getAttendanceByBatchId(int batchId) {
		return repository.findByBatchId(batchId);
	}


}