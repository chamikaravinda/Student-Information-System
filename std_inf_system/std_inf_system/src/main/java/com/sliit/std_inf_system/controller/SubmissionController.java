package com.sliit.std_inf_system.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sliit.std_inf_system.models.Submission;
import com.sliit.std_inf_system.repository.SubmissionRepo;
import com.sliit.std_inf_system.util.CommonConstants;
import com.sliit.std_inf_system.util.Generator;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(CommonConstants.API_PATH)
public class SubmissionController {

	@Autowired
	SubmissionRepo repo;

	/*
	 * This method will submit the assignment with respective data
	 */
	@RequestMapping(value = CommonConstants.SUBMIT_ASSIGNMENT, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> submitAssignment(@RequestParam("file") MultipartFile file,
			@RequestParam("comment") String comment,
			@RequestParam("mark") double mark,
			@RequestParam("assignment") ObjectId assignment,
			@RequestParam("userId") ObjectId userID,
			@RequestParam("regNo") String regNo)
			throws IOException {
		
		Submission submission = new Submission();
			
		submission.set_id(new ObjectId());
		submission.setFile(file.getBytes());
		submission.setFileName(file.getOriginalFilename());
		submission.setSubmitDate(Generator.getCurrentDate());
		submission.setSubmitTime(Generator.getCurrentTime());
		submission.setComment(comment);
		submission.setMark(mark);
		submission.setAssignment(new ObjectId());
		submission.setAssignment(assignment);
		submission.setUserId(userID);
		submission.setRegNo(regNo);

		repo.save(submission);

		
		return new ResponseEntity<>(submission, HttpStatus.OK);
		
	
	}

//	@RequestMapping(value = CommonConstants.SUBMIT_ASSIGNMENT, method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<Object> editSubmission(@RequestParam("file") MultipartFile file,
//			@RequestParam("comment") String comment,
//			@RequestParam("mark") double mark )
//			throws IOException {
//		
//		Submission submission = new Submission();
//			
//		submission.set_id(new ObjectId());
//		submission.setFile(file.getBytes());
//		submission.setFileName(file.getOriginalFilename());
//		submission.setSubmitDate(Generator.getCurrentDate());
//		submission.setSubmitTime(Generator.getCurrentTime());
//		submission.setComment(comment);
//		submission.setMark(mark);
//		submission.setAssignment(new ObjectId());
//
//		repo.save(submission);
//
//		
//		return new ResponseEntity<>(submission, HttpStatus.OK);
//		
//	
//	}
	
	/*
	 * This will update the marks of the student
	 */
	@RequestMapping(value = CommonConstants.SUBMIT_ASSIGNMENT, method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> updateMark(@RequestParam("file") MultipartFile file,
			@RequestParam("comment") String comment,
			@RequestParam("mark") double mark,
			@RequestParam("assignment") ObjectId assignment,
			@RequestParam("userId") ObjectId userID,
			@RequestParam("regNo") String regNo )
			throws IOException {
		
		Submission submission = new Submission();
			
		submission.set_id(new ObjectId());
		submission.setFile(file.getBytes());
		submission.setFileName(file.getOriginalFilename());
		submission.setSubmitDate(Generator.getCurrentDate());
		submission.setSubmitTime(Generator.getCurrentTime());
		submission.setComment(comment);
		submission.setMark(mark);
		submission.setAssignment(assignment);
		submission.setUserId(userID);
		submission.setRegNo(regNo);

		repo.save(submission);

		
		return new ResponseEntity<>(submission, HttpStatus.OK);
		
	
	}
	
	
	@GetMapping(path="test")
	public String testGetter() {
		return "success";
	};
	
	@RequestMapping(value = CommonConstants.GET_TIME, method = RequestMethod.POST)
	public ResponseEntity<Object> calculateTime(@RequestParam("deadLineDate") String deadLineDate
			)
			throws IOException {
		
		String message = "";
		
		String dateStart = Generator.getCurrentDate() + " " + Generator.getCurrentTime();
		
		String newDate = deadLineDate.replace("-", "/");
		
		String dateFront = newDate.substring(0, 10);
		String dateBack = newDate.substring(11,16);
		
		String dateStop =  dateFront + " " + dateBack;

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

		
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			message = diffDays + " days, " + diffHours + " hours, "+ diffMinutes + " minutes remaning for submission ";


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(message, HttpStatus.OK);
		
	
	}
}
