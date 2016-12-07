package com.chw.ssm.po;

public class DepartmentQueryVo {

	private Department department;
	
	private DepartmentCustom DepartmentCustom;
	
	private String dids;
	
	/*private String name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	public String getDids() {
		return dids;
	}

	public void setDids(String dids) {
		this.dids = dids;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	private Integer page;
	
	private Integer rows;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public DepartmentCustom getDepartmentCustom() {
		return DepartmentCustom;
	}

	public void setDepartmentCustom(DepartmentCustom departmentCustom) {
		DepartmentCustom = departmentCustom;
	}
	
	
	
}
