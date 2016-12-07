package com.chw.ssm.mapper;

import java.util.List;

import com.chw.ssm.po.Course;
import com.chw.ssm.po.CourseCustom;
import com.chw.ssm.po.CourseQueryVo;

public interface CourseMapperCustom {

	public List<CourseCustom> selectByName(CourseQueryVo courseQueryVo);

	public void insertOne(CourseCustom courseCustom);
	
	public int selectCount(CourseQueryVo courseQueryVo);

	public void deleteIds(CourseQueryVo courseQueryVo);

	public void update(CourseCustom courseCustom);

	public List<CourseCustom> selectAll();
	
	public int hasCourse(Course course);
}
