package com.chw.ssm.service;

import java.util.List;

import com.chw.ssm.po.DepartmentCustom;
import com.chw.ssm.po.DepartmentQueryVo;

public interface DepartementService {

	public void insert(DepartmentCustom departmentCustom);
	
	public void delete(Integer id);
	
	public void update(DepartmentCustom departmentCustom);
	
	public DepartmentCustom selectOntById(Integer id);
	
	public List<DepartmentCustom> selectAll();

	public List<DepartmentCustom> queryDepartmentByName(DepartmentQueryVo departmentQueryVo);
	
	public int selectDepartmentCount(DepartmentQueryVo departmentQueryVo);

	public void deleteByIds(DepartmentQueryVo departmentQueryVo);
	
}
