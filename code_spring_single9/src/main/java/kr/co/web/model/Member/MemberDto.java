package kr.co.web.model.Member;

import java.util.Date;

public class MemberDto {
	//회원 정보
	private String u_id;		//아이디
	private String u_pwd;		//비밀번호
	private String u_name;		//이름
	private String u_tel;		//전화번호
	private String u_birth;		//생일
	private String u_wedding;	//결혼
	private String u_p_birth;	//배우자 생일
	private String u_email;		//이메일
	private String u_address;	//주소
	private Date u_start_date;	//생성날짜
	private String u_code;		//유저등급구분
	
	public MemberDto() {
		super();
	}

	public MemberDto(String u_id, String u_pwd, String u_name, String u_tel, String u_birth, String u_wedding,
			String u_p_birth, String u_email, String u_address, Date u_start__date, String u_code) {
		super();
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_tel = u_tel;
		this.u_birth = u_birth;
		this.u_wedding = u_wedding;
		this.u_p_birth = u_p_birth;
		this.u_email = u_email;
		this.u_address = u_address;
		this.u_start_date = u_start__date;
		this.u_code = u_code;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_tel() {
		return u_tel;
	}

	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}

	public String getU_birth() {
		return u_birth;
	}

	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}

	public String getU_wedding() {
		return u_wedding;
	}

	public void setU_wedding(String u_wedding) {
		this.u_wedding = u_wedding;
	}

	public String getU_p_birth() {
		return u_p_birth;
	}

	public void setU_p_birth(String u_p_birth) {
		this.u_p_birth = u_p_birth;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public Date getU_start_date() {
		return u_start_date;
	}

	public void setU_start_date(Date u_start_date) {
		this.u_start_date = u_start_date;
	}

	public String getU_code() {
		return u_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}
	
	

}
