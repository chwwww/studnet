package com.chw.ssm.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chw.ssm.mapper.CourseMapperCustom;
import com.chw.ssm.mapper.ScMapperCustom;
import com.chw.ssm.po.CourseGrade;
import com.chw.ssm.po.Report;
import com.chw.ssm.po.ScCustom;
import com.chw.ssm.service.ScService;

@Service
public class ScServiceImpl implements ScService {

	@Resource
	private ScMapperCustom scMapperCustom;

	@Resource
	private CourseMapperCustom courseMapperCustom;

	@Override
	public Map<String, Object> saveGrade(ScCustom scCustom) {
		Map<String, Object> result = new HashMap<>();
		int has = scMapperCustom.studentIdFandName(scCustom);
		if (has == 1) {
			if (scCustom.getGrade() != null) {
				int courseHas = scMapperCustom.alreadyHasCourse(scCustom);
				if (courseHas == 0) {
					scMapperCustom.saveGrade(scCustom);
					result.put("result", "成绩添加成功！");
				} else {
					scMapperCustom.updateGrade(scCustom);
					result.put("result", "修改成绩成功！");
				}
			}else{
				scMapperCustom.deleteGrade(scCustom);
				result.put("result", "成绩删除成功");
			}
		} else {
			result.put("result", "姓名学号不匹配！请检查");
		}
		return result;
	}

	@Override
	public Map<String, Object> selectStudentGrade(ScCustom scCustom) {
		Map<String, Object> result = new HashMap<>();
		int has = scMapperCustom.studentIdFandName(scCustom);
		if (has == 1) {
			DecimalFormat df = new DecimalFormat("0.0");
			ScCustom sc = scMapperCustom.gradeAvgAndSum(scCustom);
			List<Report> reports = scMapperCustom.selectGrades(scCustom);
			List<String> courseName = new ArrayList<>();
			List<String> courseGrade = new ArrayList<>();
			for (int i = 0; i < reports.size(); i++) {
				courseName.add(reports.get(i).getName());
				courseGrade.add(reports.get(i).getGrade());
			}

			result.put("courseGrade", courseGrade);
			result.put("courseName", courseName);
			result.put("result", "true");
			result.put("totalGrade", sc.getTotalGrade());
			result.put("avgGrade", df.format(sc.getAvgGrade()));
			result.put("name", scCustom.getStudent().getName());
		} else {
			result.put("result", "false");
		}
		return result;
	}

	@Override
	public Map<String, Object> selectCourseGrade(ScCustom scCustom) {
		Map<String, Object> result = new HashMap<>();
		int has = courseMapperCustom.hasCourse(scCustom.getCourse());
		System.out.println(has);
		if (has > 0) {
			DecimalFormat df = new DecimalFormat("0.0");
			List<CourseGrade> courseGrade = scMapperCustom.selectCourseGrades(scCustom);
			result.put("avg", df.format(scMapperCustom.courseGradeAvg(scCustom).getAvgGrade()));
			result.put("Grades", courseGrade);
			result.put("course", scCustom.getCourse().getName());
			result.put("result", "true");
		} else {
			result.put("result", "false");
		}
		return result;
	}

}
