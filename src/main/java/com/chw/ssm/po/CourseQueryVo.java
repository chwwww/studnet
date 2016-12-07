package com.chw.ssm.po;

import java.util.List;

public class CourseQueryVo {

	private Course course;
	
	private CourseCustom courseCustom;

	private String cids;
	
	private int courseCount;
	
	public int getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}

	public String getCids() {
		return cids;
	}

	public void setCids(String cids) {
		this.cids = cids;
	}

	public List<CourseCustom> getCourseCustomList() {
		return courseCustomList;
	}

	public void setCourseCustomList(List<CourseCustom> courseCustomList) {
		this.courseCustomList = courseCustomList;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	private List<CourseCustom> courseCustomList;
	
	private Integer page;
	
	private Integer rows;
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseCustom getCourseCustom() {
		return courseCustom;
	}

	public void setCourseCustom(CourseCustom courseCustom) {
		this.courseCustom = courseCustom;
	}
	
}
