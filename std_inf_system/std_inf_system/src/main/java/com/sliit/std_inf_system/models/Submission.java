package com.sliit.std_inf_system.models;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "submissions")
public class Submission {

	@Id
	private ObjectId _id;
	
	private byte[] file;
	private String fileName;
	private String submitDate;
	private String submitTime;
	private String comment;
	private double mark;
	private ObjectId assignment;
	private ObjectId userId;
	private String regNo;
	
	
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public ObjectId getAssignment() {
		return assignment;
	}
	public void setAssignment(ObjectId assignment) {
		this.assignment = assignment;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public ObjectId getUserId() {
		return userId;
	}
	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	@Override
	public String toString() {
		return "Submission [_id=" + _id + ", file=" + Arrays.toString(file) + ", fileName=" + fileName + ", submitDate="
				+ submitDate + ", submitTime=" + submitTime + ", comment=" + comment + ", mark=" + mark
				+ ", assignment=" + assignment + ", userId=" + userId + ", regNo=" + regNo + "]";
	}
	
	
}