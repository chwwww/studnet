package com.chw.ssm.po;

public class ScCustom extends Sc {
	
	private DepartmentCustom departmentCustom;

private float avgGrade;
	
	private int totalGrade;

	public float getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}

	public int getTotalGrade() {
		return totalGrade;
	}

	public void setTotalGrade(int totalGrade) {
		this.totalGrade = totalGrade;
	}

	public DepartmentCustom getDepartmentCustom() {
		return departmentCustom;
	}

	public void setDepartmentCustom(DepartmentCustom departmentCustom) {
		this.departmentCustom = departmentCustom;
	}
	
}
