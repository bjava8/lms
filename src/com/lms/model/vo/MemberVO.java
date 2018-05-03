package com.lms.model.vo;

public class MemberVO {
	private String memberno, id, name, pw, email, phone, memberlevel;

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemberlevel() {
		return memberlevel;
	}

	public void setMemberlevel(String memberlevel) {
		this.memberlevel = memberlevel;
	}

	@Override
	public String toString() {
		return "MemberVO [memberno=" + memberno + ", id=" + id + ", name=" + name + ", pw=" + pw + ", email=" + email
				+ ", phone=" + phone + ", memberlevel=" + memberlevel + "]";
	}
	
	
}
