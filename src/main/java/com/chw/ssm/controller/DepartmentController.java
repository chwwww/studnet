package com.chw.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chw.ssm.po.DepartmentCustom;
import com.chw.ssm.po.DepartmentQueryVo;
import com.chw.ssm.service.DepartementService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Resource
	private DepartementService departementService;
	
	
	@RequestMapping("/departmentQuery")
	public @ResponseBody List<DepartmentCustom> departmentQueryAll(){
		return departementService.selectAll();
	}
	
	@RequestMapping("/sendDepartmentQuery")
	public String departmentQueryJsp(){
		return "department/departmentlist";
	}
	
	@RequestMapping("/queryDepartmentByName")
	public @ResponseBody Map<String, Object> departmentByName(DepartmentQueryVo departmentQueryVo){
		Map<String,Object> pageMap = new HashMap<String ,Object>();
		pageMap.put("rows", departementService.queryDepartmentByName(departmentQueryVo));
		pageMap.put("total", departementService.selectDepartmentCount(departmentQueryVo) );
		return pageMap;
		
	}
	
	@RequestMapping("/sendDepartmentSaveJsp")
	public String departmentSaveJsp(){
		return "department/departmentSave";
	}
	
	@RequestMapping("/sendDepartmentSave")
	public String departmentSave(DepartmentCustom departmentCustom){
		 departementService.insert(departmentCustom);
		 return "redirect:sendDepartmentQuery";
	}
	
	@RequestMapping("/departmentDeleteByIds")
	public @ResponseBody Map<String, Object > deleteDepatrment(DepartmentQueryVo departmentQueryVo){
		departementService.deleteByIds(departmentQueryVo);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "true");
		return result;
	}
	
	@RequestMapping("/sendDepartmentUpdate")
	public String departmentUpdateJsp(){
		return "department/departmentUpdate";
	}
	
	@RequestMapping("departmentUpdate")
	public void departmentUpdate(DepartmentCustom departmentCustom){
		departementService.update(departmentCustom);
	}
}
