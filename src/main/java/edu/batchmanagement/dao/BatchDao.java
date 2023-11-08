package edu.batchmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.batchmanagement.entity.Batch;
import edu.batchmanagement.repository.BatchRepository;

@Repository
public class BatchDao {

	@Autowired
	private BatchRepository repository;
	
	public Batch saveBatch(Batch batch) {
		return repository.save(batch);
	} 

	public Batch updateBatch(Batch batch) {
		return repository.save(batch);
	} 
	
	public void deleteBatch(Batch batch) {
		repository.delete(batch);
	} 

	public void deleteBatchById(int batchId) {
		repository.deleteById(batchId);
	} 
	
	public Batch getBatchById(int batchId) {
		Optional<Batch> optionalBatch = repository.findById(batchId);
		return optionalBatch.isPresent()?optionalBatch.get():null;
	}
	
	public List<Batch> getBatchesByEmployeeId(String employeeId) {
		return repository.findByEmployeeId(employeeId);
	}


}