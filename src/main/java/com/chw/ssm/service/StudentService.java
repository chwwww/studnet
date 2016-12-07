package com.chw.ssm.service;

import com.chw.ssm.po.StudentCustom;
import com.chw.ssm.po.StudentQueryVo;

public interface StudentService {

	public StudentQueryVo selectStudentAndCount(StudentQueryVo studentQueryVo);

	public void saveStudent(StudentCustom studentCustom);

	public void deleteByIds(StudentQueryVo studentQueryVo);

	public void updateStudent(StudentCustom studentCustom);
	
	
	
}
