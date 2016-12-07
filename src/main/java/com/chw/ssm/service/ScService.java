package com.chw.ssm.service;

import java.util.Map;

import com.chw.ssm.po.ScCustom;

public interface ScService {

	Map<String, Object> saveGrade(ScCustom scCustom);

	Map<String, Object> selectStudentGrade(ScCustom scCustom);

	Map<String, Object> selectCourseGrade(ScCustom scCustom);

	

}
