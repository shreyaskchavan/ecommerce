package member;

import java.sql.Date;

//DTO stands for Data Transfer Object.
//It will have fields based on the database table.

public class MemberDto {
	private String uname, password, fname, lname, email, mlevel;
	private long phone;
	private java.sql.Date dob, dor;

	public MemberDto() {
		super();
	}

	public MemberDto(String uname, String password, String fname, String lname, String email, String mlevel, long phone,
			Date dob, Date dor) {
		super();
		this.uname = uname;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mlevel = mlevel;
		this.phone = phone;
		this.dob = dob;
		this.dor = dor;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMlevel() {
		return mlevel;
	}

	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public java.sql.Date getDor() {
		return dor;
	}

	public void setDor(java.sql.Date dor) {
		this.dor = dor;
	}

}
