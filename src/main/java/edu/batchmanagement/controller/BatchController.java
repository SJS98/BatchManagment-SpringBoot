package edu.batchmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.batchmanagement.dto.ResponseStructure;
import edu.batchmanagement.entity.Batch;
import edu.batchmanagement.service.BatchService;

@RestController
@RequestMapping("/batches")
public class BatchController {

	@Autowired
	private BatchService service;

	@PostMapping("/batch/{empId}")
	public ResponseEntity<ResponseStructure<Batch>> saveBatch(@RequestBody Batch batch, @PathVariable String empId) {
		return service.addBatchToEmployee(batch, empId);
	}

	@PutMapping("/batch")
	public ResponseEntity<ResponseStructure<Batch>> updateBatch(@RequestBody Batch batch) {
		return service.updateBatch(batch);
	}

	@GetMapping("/batchbyid/{batchId}")
	public ResponseEntity<ResponseStructure<Batch>> findBatchByBatchId(@PathVariable int batchId) {
		return service.findBatchById(batchId);
	}	

	@GetMapping("/batchbyempid/{employeeId}")
	public ResponseEntity<ResponseStructure<List<Batch>>> findBatchsByEmployeeId(@PathVariable String employeeId) {
		return service.findBatchesByEmployeeId(employeeId);
	}
}