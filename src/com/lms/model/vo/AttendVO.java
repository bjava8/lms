package com.lms.model.vo;

public class AttendVO {
	private String attendno, courseno, memberno, allow;
	private String grade; // 학점
	private String name; // 학생이름
	private String coursename;

	public String getAttendno() {
		return attendno;
	}

	public void setAttendno(String attendno) {
		this.attendno = attendno;
	}

	public String getCourseno() {
		return courseno;
	}

	public void setCourseno(String courseno) {
		this.courseno = courseno;
	}

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	@Override
	public String toString() {
		return "AttendVO [attendno=" + attendno + ", courseno=" + courseno + ", memberno=" + memberno + ", allow="
				+ allow + ", grade=" + grade + ", name=" + name + ", coursename=" + coursename + "]";
	}

	

}
