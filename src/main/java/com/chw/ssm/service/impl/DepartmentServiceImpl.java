package com.chw.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chw.ssm.mapper.DepartmentMapperCustom;
import com.chw.ssm.po.DepartmentCustom;
import com.chw.ssm.po.DepartmentQueryVo;
import com.chw.ssm.service.DepartementService;

@Service
public class DepartmentServiceImpl implements DepartementService{

	@Resource
	private DepartmentMapperCustom departmentMapperCustom;
	
	public void insert(DepartmentCustom departmentCustom) {
		departmentMapperCustom.insertOne(departmentCustom);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void update(DepartmentCustom departmentCustom) {
		departmentMapperCustom.update(departmentCustom);
		
	}

	public DepartmentCustom selectOntById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DepartmentCustom> selectAll() {
		return departmentMapperCustom.selectAll();
	}

	@Override
	public List<DepartmentCustom> queryDepartmentByName(DepartmentQueryVo departmentQueryVo) {
		return departmentMapperCustom.selectByName(departmentQueryVo);
	}

	@Override
	public int selectDepartmentCount(DepartmentQueryVo departmentQueryVo) {
		return departmentMapperCustom.selectCount(departmentQueryVo) ;
	}

	

	@Override
	public void deleteByIds(DepartmentQueryVo departmentQueryVo) {
		departmentMapperCustom.deleteIds(departmentQueryVo);
		
	}

}
