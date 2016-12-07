package com.chw.ssm.mapper;

import java.util.List;

import com.chw.ssm.po.DepartmentCustom;
import com.chw.ssm.po.DepartmentQueryVo;

public interface DepartmentMapperCustom {

	public List<DepartmentCustom> selectAll();

	public List<DepartmentCustom> selectByName(DepartmentQueryVo departmentQueryVo);

	public void insertOne(DepartmentCustom departmentCustom);
	
	public int selectCount(DepartmentQueryVo departmentQueryVo);

	public void deleteIds(DepartmentQueryVo departmentQueryVo);

	public void update(DepartmentCustom departmentCustom);
	
}
