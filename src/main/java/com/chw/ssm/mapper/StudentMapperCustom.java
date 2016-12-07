package com.chw.ssm.mapper;

import java.util.List;

import com.chw.ssm.po.StudentCustom;
import com.chw.ssm.po.StudentQueryVo;

public interface StudentMapperCustom {

	public int selectCount(StudentQueryVo studentQueryVo);
	
	public List<StudentCustom> selectByName(StudentQueryVo studentQueryVo);

	public void saveStudent(StudentCustom studentCustom);

	public void deleteByIds(StudentQueryVo studentQueryVo);

	public void update(StudentCustom studentCustom);
	
}
