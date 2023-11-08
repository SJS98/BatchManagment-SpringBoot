package edu.batchmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.batchmanagement.dao.AttendanceDao;
import edu.batchmanagement.dao.BatchDao;
import edu.batchmanagement.dto.ResponseStructure;
import edu.batchmanagement.entity.Attendance;
import edu.batchmanagement.entity.Batch;
import edu.batchmanagement.exception.InvalidAttendanceIdException;
import edu.batchmanagement.exception.InvalidBatchIdException;
import edu.batchmanagement.exception.InvalidEmployeeIdException;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceDao attendanceDao;

	@Autowired
	private BatchDao batchDao;

	public ResponseEntity<ResponseStructure<Attendance>> saveAttendance(Attendance attendance) {

		// save Image first

		attendance = attendanceDao.saveAttendance(attendance);

		ResponseStructure<Attendance> responseStructure = new ResponseStructure<Attendance>(HttpStatus.CREATED.value(),
				"success", attendance);

		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Attendance>> updateAttendance(Attendance attendance) {

		attendance = attendanceDao.saveAttendance(attendance);

		ResponseStructure<Attendance> responseStructure = new ResponseStructure<Attendance>(HttpStatus.OK.value(), "success",
				attendance);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Attendance>> findAttendanceById(int attendanceId) {

		Attendance attendance = attendanceDao.getAttendanceById(attendanceId);

		if (attendance == null)
			throw new InvalidAttendanceIdException("No attendance found of ID : " + attendanceId);

		ResponseStructure<Attendance> responseStructure = new ResponseStructure<Attendance>(HttpStatus.OK.value(), "success",
				attendance);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Attendance>>> findAttendanceByBatchId(int batchId) {

		List<Attendance> attendance = attendanceDao.getAttendanceByBatchId(batchId);

		if (attendance == null)
			throw new InvalidEmployeeIdException("No batch found of ID : " + batchId);

		ResponseStructure<List<Attendance>> responseStructure = new ResponseStructure<List<Attendance>>(HttpStatus.OK.value(),
				"success", attendance);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Attendance>> addAttendanceToBatch(Attendance attendance, int batchId) {

		Batch batch = batchDao.getBatchById(batchId);

		if (batch == null)
			throw new InvalidBatchIdException("No batch found of ID: " + batchId);

		attendance = attendanceDao.saveAttendance(attendance);
		
		List<Attendance> attendances = batch.getAttendances();
		
		attendances.add(attendance);

		batch.setAttendances(attendances);
		
		batchDao.updateBatch(batch);
		
		ResponseStructure<Attendance> responseStructure = new ResponseStructure<Attendance>(HttpStatus.OK.value(), "success",
				attendance);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
}