package edu.batchmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.batchmanagement.dao.BatchDao;
import edu.batchmanagement.dao.UserDao;
import edu.batchmanagement.dto.ResponseStructure;
import edu.batchmanagement.entity.Batch;
import edu.batchmanagement.entity.User;
import edu.batchmanagement.exception.InvalidBatchIdException;
import edu.batchmanagement.exception.InvalidEmployeeIdException;

@Service
public class BatchService {

	@Autowired
	private BatchDao batchDao;

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Batch>> saveBatch(Batch batch) {

		batch = batchDao.saveBatch(batch);

		ResponseStructure<Batch> responseStructure = new ResponseStructure<Batch>(HttpStatus.CREATED.value(), "success", batch);

		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Batch>> updateBatch(Batch batch) {

		batch = batchDao.saveBatch(batch);

		ResponseStructure<Batch> responseStructure = new ResponseStructure<Batch>(HttpStatus.OK.value(), "success", batch);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Batch>> findBatchById(int batchId) {

		Batch batch = batchDao.getBatchById(batchId);

		if (batch == null)
			throw new InvalidBatchIdException("No batch found of ID : " + batchId);

		ResponseStructure<Batch> responseStructure = new ResponseStructure<Batch>(HttpStatus.OK.value(), "success", batch);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<Batch>>> findBatchesByEmployeeId(String empId) {


		List<Batch> batch = batchDao.getBatchesByEmployeeId(empId);

		System.out.println(batch);
		if (batch == null)
			throw new InvalidEmployeeIdException("No Employee found of ID : " + empId);

		ResponseStructure<List<Batch>> responseStructure = new ResponseStructure<List<Batch>>(HttpStatus.OK.value(), "success",
				batch);

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Batch>> addBatchToEmployee(Batch batch, String empId) {

		User employee = userDao.getUserByEmployeId(empId);
		
		if (employee == null)
			throw new InvalidEmployeeIdException("No employee of ID : " + empId);

		batch = batchDao.saveBatch(batch);
		
		List<Batch> existingBatches = employee.getBatches();
		
		existingBatches.add(batch);
		
		employee.setBatches(existingBatches);

		userDao.updateUser(employee);
		
		ResponseStructure<Batch> responseStructure = new ResponseStructure<Batch>(HttpStatus.OK.value(), "success", batch);
		
		return new ResponseEntity<ResponseStructure<Batch>>(responseStructure, HttpStatus.OK);
	}
}
