package edu.batchmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.batchmanagement.entity.Image;
import edu.batchmanagement.repository.ImageRepository;

@Repository
public class ImageDao {

	@Autowired
	private ImageRepository repository;

	public Image saveImage(Image image) {
		return repository.save(image);
	}

	public Image getImageById(int imageId) {
		Optional<Image> optionalImage = repository.findById(imageId);
		return optionalImage.isPresent() ? optionalImage.get() : null;
	}

	public Image getImageByAttendanceId(int attendanceId) {
		return repository.findByAttendanceId(attendanceId);
	}

}