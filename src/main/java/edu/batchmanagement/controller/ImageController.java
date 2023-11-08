package edu.batchmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.batchmanagement.dto.ResponseStructure;
import edu.batchmanagement.entity.Image;
import edu.batchmanagement.service.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageService service;

	@PostMapping(value = "/image/{attendanceId}", consumes = { "MULTIPART/FORM-DATA" })
	public ResponseEntity<ResponseStructure<Image>> saveImage(@RequestParam("screenshot") MultipartFile image,
			@PathVariable int attendanceId){
		return service.addImageToAttendace(image, attendanceId);
	}

	@GetMapping("/imagebyid/{imageId}")
	public ResponseEntity<ResponseStructure<Image>> findImageById(@PathVariable int imageId) {
		return service.findImageById(imageId);
	}

	@GetMapping("/imagebyattendanceid/{attendanceId}")
	public ResponseEntity<ResponseStructure<Image>> findImagesByBatchId(@PathVariable int attendanceId) {
		return service.findImageByAttendanceId(attendanceId);
	}
}