package com.chw.ssm.mapper;

import java.util.List;

import com.chw.ssm.po.CourseGrade;
import com.chw.ssm.po.Report;
import com.chw.ssm.po.ScCustom;

public interface ScMapperCustom {

	void saveGrade(ScCustom scCustom);

	int studentIdFandName(ScCustom scCustom);

	int alreadyHasCourse(ScCustom scCustom);

	List<Report> selectGrades(ScCustom scCustom);
	
	ScCustom gradeAvgAndSum(ScCustom scCustom);
	
	List<CourseGrade> selectCourseGrades(ScCustom scCustom);
	
	ScCustom courseGradeAvg(ScCustom scCustom);

	void updateGrade(ScCustom scCustom);

	void deleteGrade(ScCustom scCustom);
}
