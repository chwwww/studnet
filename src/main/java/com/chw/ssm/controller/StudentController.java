package com.chw.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chw.ssm.po.StudentCustom;
import com.chw.ssm.po.StudentQueryVo;
import com.chw.ssm.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private StudentService studentService;
	
	@RequestMapping("/sendStudentQuery")
	public String sendStudentQuery(){
		return "student/studentlist";
	}
	
	@RequestMapping("/queryStudentByName")
	public @ResponseBody Map<String, Object> queryStudentByName(StudentQueryVo studentQueryVo){
		StudentQueryVo stu = studentService.selectStudentAndCount(studentQueryVo);
		Map<String,Object> studnetMap = new HashMap<String, Object>();
		studnetMap.put("rows", stu.getStudentList());
		studnetMap.put("total", stu.getStudentCount());
		return studnetMap;
	}
	
	@RequestMapping("/sendStudentSave")
	public String sendStudentSaveJsp(){
		return "student/studentSave";
	}
	
	@RequestMapping("/studentSave")
	public void studentSave(StudentCustom studentCustom){
		studentService.saveStudent(studentCustom);
	}
	
	@RequestMapping("/departmentQuery")
	public String departmentQuery(){
		return "redirect:/department/departmentQuery";
	}
	
	@RequestMapping("/studentDeleteByIds")
	public @ResponseBody Map<String,Object> studentDeleteByIds(StudentQueryVo studentQueryVo){
		studentService.deleteByIds(studentQueryVo);
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", "true");
		return resultMap;
	}
	
	@RequestMapping("/sendStudentUpdate")
	public String sendStudentUpdateJsp(){
		return "student/studentUpdate";
	}
	
	@RequestMapping("/studentUpdate")
	public void studentUpdate(StudentCustom studentCustom){
		studentService.updateStudent(studentCustom);
	}
}
