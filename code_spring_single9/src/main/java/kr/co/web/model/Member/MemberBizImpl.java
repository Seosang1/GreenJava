package kr.co.web.model.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberBizImpl implements MemberBiz {
	
	@Autowired
	private MemberDao dao;

	@Override
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}

	@Override
	public int memberjoin(MemberDto dto) {
		return dao.memberjoin(dto);
	}

	@Override
	public String Idcheck(MemberDto dto) {
		return null;
	}

	@Override
	public void PWcheck(MemberDto dto) {
		
	}

	@Override
	public String searchId() {
		return null;
	}

	@Override
	public void searchPw() {
		
	}

	@Override
	public void logout(HttpSession session) {
		
	}

	@Override
	public String loginCheck(MemberDto dto) {
		return null;
	}

	@Override
	public String level(MemberDto dto) {
		return null;
	}

	@Override
	public String forced_Admin(String u_id, String u_pwd) {
		return null;
	}

}
