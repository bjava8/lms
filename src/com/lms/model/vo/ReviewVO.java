package com.lms.model.vo;

public class ReviewVO {
	private String reviewno, courseno, writer,	memberno, rcontent,	writedate;

	public String getReviewno() {
		return reviewno;
	}

	public void setReviewno(String reviewno) {
		this.reviewno = reviewno;
	}

	public String getCourseno() {
		return courseno;
	}

	public void setCourseno(String courseno) {
		this.courseno = courseno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "ReviewVO [reviewno=" + reviewno + ", courseno=" + courseno + ", writer=" + writer + ", memberno="
				+ memberno + ", rcontent=" + rcontent + ", writedate=" + writedate + "]";
	}	
	
}
