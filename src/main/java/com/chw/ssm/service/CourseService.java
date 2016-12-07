package com.chw.ssm.service;

import java.util.List;

import com.chw.ssm.po.CourseCustom;
import com.chw.ssm.po.CourseQueryVo;

public interface CourseService {

	public CourseQueryVo selectCourseAndCount(CourseQueryVo courseQueryVo);
	
	public void deleteCourseByIds(CourseQueryVo courseQueryVo);
	
	public void updateOneCourse(CourseCustom courseCustom);
	
	public void insertOneCourse(CourseCustom courseCustom);

	public List<CourseCustom> selectAll();
	
}
