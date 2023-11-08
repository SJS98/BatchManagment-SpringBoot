package edu.batchmanagement.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.batchmanagement.dao.AttendanceDao;
import edu.batchmanagement.dao.ImageDao;
import edu.batchmanagement.dto.ResponseStructure;
import edu.batchmanagement.entity.Attendance;
import edu.batchmanagement.entity.Image;
import edu.batchmanagement.exception.InvalidAttendanceIdException;
import edu.batchmanagement.exception.InvalidImageIdException;

@Service
public class ImageService {

	@Autowired
	private ImageDao imageDao;

	@Autowired
	private AttendanceDao attendanceDao;

	public ResponseEntity<ResponseStructure<Image>> addImageToAttendace(MultipartFile imageBytes, int attendanceId) {

		if (imageBytes == null || imageBytes.isEmpty()) {
			throw new InvalidImageIdException("No image found");
		}

		Image image = new Image();
		
		try {
			image.setFile(imageBytes.getBytes());
		} catch (IOException e) {
			throw new InvalidImageIdException("No image bytes found");
		}

		Attendance attendance = attendanceDao.getAttendanceById(attendanceId);

		if (attendance == null)
			throw new InvalidAttendanceIdException("No attendance found of ID: " + attendanceId);

		image = imageDao.saveImage(image);

		attendance.setImage(image);

		attendanceDao.updateAttendance(attendance);

		ResponseStructure<Image> responseStructure = new ResponseStructure<Image>(HttpStatus.CREATED.value(), "success", image);

		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Image>> findImageById(int imageId) {

		Image image = imageDao.getImageById(imageId);

		if (image == null)
			throw new InvalidImageIdException("No image found of ID: " + imageId);

		ResponseStructure<Image> responseStructure = new ResponseStructure<Image>(HttpStatus.CREATED.value(), "success", image);

		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Image>> findImageByAttendanceId(int attendanceId) {
		Attendance attendance = attendanceDao.getAttendanceById(attendanceId);

		if (attendance == null)
			throw new InvalidAttendanceIdException("No attendance found of ID: " + attendanceId);

		if (attendance.getImage() == null)
			throw new InvalidImageIdException("No image found for attendance ID: " + attendanceId);

		ResponseStructure<Image> responseStructure = new ResponseStructure<Image>(HttpStatus.CREATED.value(), "success",
				attendance.getImage());

		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}
}
