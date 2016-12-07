package com.chw.ssm.po;

import java.util.List;

public class StudentQueryVo {

	private Student student;

	private StudentCustom studentCustom;

	private String sids;

	private int page;

	private int rows;

	private int studentCount;

	

	private List<StudentCustom> studentList;

	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentCustom getStudentCustom() {
		return studentCustom;
	}

	public void setStudentCustom(StudentCustom studentCustom) {
		this.studentCustom = studentCustom;
	}

	public String getSids() {
		return sids;
	}

	public void setSids(String sids) {
		this.sids = sids;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public List<StudentCustom> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentCustom> studentList) {
		this.studentList = studentList;
	}

}
