package com.chw.ssm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chw.ssm.mapper.StudentMapperCustom;
import com.chw.ssm.po.StudentCustom;
import com.chw.ssm.po.StudentQueryVo;
import com.chw.ssm.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapperCustom studentMapperCustom;

	@Override
	public StudentQueryVo selectStudentAndCount(StudentQueryVo studentQueryVo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StudentQueryVo sqv = new StudentQueryVo();
		List<StudentCustom> stList = studentMapperCustom.selectByName(studentQueryVo);
		for(StudentCustom sc : stList){
			sc.setDate(sdf.format(sc.getBirthday()));
		}
		sqv.setStudentList(stList);
		sqv.setStudentCount(studentMapperCustom.selectCount(studentQueryVo));
		return sqv;
	}

	@Override
	public void saveStudent(StudentCustom studentCustom) {
		studentMapperCustom.saveStudent(studentCustom);
		
	}

	@Override
	public void deleteByIds(StudentQueryVo studentQueryVo) {
		studentMapperCustom.deleteByIds(studentQueryVo);
		
	}

	@Override
	public void updateStudent(StudentCustom studentCustom) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			studentCustom.setBirthday(format.parse(studentCustom.getDate()));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		studentMapperCustom.update(studentCustom);
		
	}

}
