package com.chw.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chw.ssm.mapper.CourseMapperCustom;
import com.chw.ssm.po.CourseCustom;
import com.chw.ssm.po.CourseQueryVo;
import com.chw.ssm.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseMapperCustom courseMapperCustom;
	
	@Override
	public CourseQueryVo selectCourseAndCount(CourseQueryVo courseQueryVo) {
		CourseQueryVo cour = new CourseQueryVo();
		cour.setCourseCustomList(courseMapperCustom.selectByName(courseQueryVo));
		cour.setCourseCount(courseMapperCustom.selectCount(courseQueryVo));
		return cour;
	}

	@Override
	public void deleteCourseByIds(CourseQueryVo courseQueryVo) {
		courseMapperCustom.deleteIds(courseQueryVo);
	}

	@Override
	public void updateOneCourse(CourseCustom courseCustom) {
		courseMapperCustom.update(courseCustom);
	}

	@Override
	public void insertOneCourse(CourseCustom courseCustom) {
		courseMapperCustom.insertOne(courseCustom);
	}

	@Override
	public List<CourseCustom> selectAll() {
		return courseMapperCustom.selectAll();
	}

}
