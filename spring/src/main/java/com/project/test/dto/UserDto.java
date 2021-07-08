package com.project.test.dto;

import java.util.Date;

public class UserDto {
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String birth;
	private String wedding;
	private String p_birth;
	private String email;
	private String address;
	private Date start_date;
	private String code;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String id, String pwd, String name, String tel, String birth, String wedding, String p_birth,
			String email, String address, Date start_date, String code) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.wedding = wedding;
		this.p_birth = p_birth;
		this.email = email;
		this.address = address;
		this.start_date = start_date;
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getWedding() {
		return wedding;
	}
	public void setWedding(String wedding) {
		this.wedding = wedding;
	}
	public String getP_birth() {
		return p_birth;
	}
	public void setP_birth(String p_birth) {
		this.p_birth = p_birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	



}


