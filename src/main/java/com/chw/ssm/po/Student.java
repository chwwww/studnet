package com.chw.ssm.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
    private Integer sid;

    private String name;

    private String sex;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private Department department;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

   
}