package edu.batchmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.batchmanagement.dto.ResponseStructure;
import edu.batchmanagement.entity.Attendance;
import edu.batchmanagement.service.AttendanceService;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

	@Autowired
	private AttendanceService service;

	@PostMapping("/attendance/{batchId}")
	public ResponseEntity<ResponseStructure<Attendance>> saveAttendance(@RequestBody Attendance attendance,
			@PathVariable int batchId) {
		return service.addAttendanceToBatch(attendance, batchId);
	}

	@GetMapping("/attendancebyid/{attendanceId}")
	public ResponseEntity<ResponseStructure<Attendance>> findAttendanceById(@PathVariable int attendanceId) {
		return service.findAttendanceById(attendanceId);
	}

	@GetMapping("/attendancebybatchid/{batchId}")
	public ResponseEntity<ResponseStructure<List<Attendance>>> findAttendancesByBatchId(@PathVariable int batchId) {
		return service.findAttendanceByBatchId(batchId);
	}
}