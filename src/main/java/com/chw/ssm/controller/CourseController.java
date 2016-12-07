package com.chw.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chw.ssm.po.CourseCustom;
import com.chw.ssm.po.CourseQueryVo;
import com.chw.ssm.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Resource
	private CourseService courseService;
	
	@RequestMapping("/courseQueryAll")
	public @ResponseBody List<CourseCustom> courseQueryAll(){
		return courseService.selectAll();
	}
	
	@RequestMapping("/sendCourseQuery")
	public String sendCourseQueryJsp(){
		return "course/courselist";
	}
	
	@RequestMapping("/queryCourseByName")
	public @ResponseBody Map<String, Object> queryCourseByName(CourseQueryVo courseQueryVo){
		CourseQueryVo cqv = courseService.selectCourseAndCount(courseQueryVo);
		Map<String, Object> courseMap = new HashMap<>();
		courseMap.put("rows", cqv.getCourseCustomList());
		courseMap.put("total", cqv.getCourseCount());
		return courseMap;
	}
	
	@RequestMapping("/sendCourseSaveJsp")
	public String sendCourseSaveJsp(){
		return "course/courseSave";
	}
	
	@RequestMapping("/sendCourseSave")
	public String sendCourseSave(CourseCustom courseCustom){
		courseService.insertOneCourse(courseCustom);
		return "redirect:sendCourseQuery";
	}
	
	@RequestMapping("/sendCourseUpdate")
	public String sendCourseUpdateJsp(){
		return "course/courseUpdate";
	}
	
	@RequestMapping("/courseUpdate")
	public void courseUpdate(CourseCustom courseCustom){
		courseService.updateOneCourse(courseCustom);
	}
	
	@RequestMapping("/courseDeleteByIds")
	public @ResponseBody Map<String, Object> courseDeleteByIds(CourseQueryVo courseQueryVo){
		courseService.deleteCourseByIds(courseQueryVo);
		Map<String,Object> result = new HashMap<>();
		result.put("result", "true");
		return result;
	}
}
