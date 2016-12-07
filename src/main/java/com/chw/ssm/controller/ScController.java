package com.chw.ssm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chw.ssm.po.ScCustom;
import com.chw.ssm.service.ScService;

@Controller
@RequestMapping("/sc")
public class ScController {

	@Resource
	private ScService scService;
	
	@RequestMapping("sendInputGrade")
	public String sendInputGradeJsp(){
		return "sc/inputGrade";
	}
	
	@RequestMapping("/courseQuery")
	public String courseQuery(){
		return "redirect:/course/courseQueryAll";
	}
	
	@RequestMapping("/saveStudnetGrade")
	public @ResponseBody Map<String,Object> saveStudnetGrade(ScCustom scCustom){
		return scService.saveGrade(scCustom);
	}
	
	@RequestMapping("/sendQueryGrade")
	public String sendQueryGradeJsp(){
		return "sc/queryGrade";
	}
	
	@RequestMapping("/queryStudentGrade") 
	public @ResponseBody Map<String,Object> queryStudentGrade(ScCustom scCustom){
		return scService.selectStudentGrade(scCustom);
	}
	
	@RequestMapping("/sendQueryCourseGrade")
	public String sendQueryCourseGradeJsp(){
		return "sc/queryCourse";
	}
	
	@RequestMapping("/queryCourseGrade")
	public @ResponseBody Map<String,Object> queryCourseGrade(ScCustom scCustom){
		return scService.selectCourseGrade(scCustom);
	}
	
}
