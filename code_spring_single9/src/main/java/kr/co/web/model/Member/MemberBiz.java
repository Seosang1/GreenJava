package kr.co.web.model.Member;

import javax.servlet.http.HttpSession;

public interface MemberBiz {
	
	//회원
	//로그인
	public MemberDto login(MemberDto dto);
	
	//회원가입
	public int memberjoin(MemberDto dto);
	
	//회원가입 아이디 중복체크
	public String Idcheck(MemberDto dto);
	
	//회원가입 비밀번호 확인
	public void PWcheck(MemberDto dto); 
	
	//회원가입 이메일&핸드폰 인증
	
	//아이디 찾기
	public String searchId();
	
	//비밀번호 찾기
	public void searchPw();
	
	//로그아웃
	public void logout(HttpSession session);
	
	//관리자
	//회원 정보 조회
	public String loginCheck(MemberDto dto);
	
	//회원 등급 조정
	public String level(MemberDto dto);
	
	//회원 강제 탈퇴
	public String forced_Admin(String u_id, String u_pwd);

}
