package kr.co.web.model.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberBizImpl implements MemberBiz {
	
	@Autowired
	private MemberDao dao;

	@Override
	public MemberDto userlogin(MemberDto dto) throws Exception {
		return dao.userlogin(dto);
	}

	@Override
	public int memberjoin(MemberDto dto) {
		return dao.memberjoin(dto);
	}

	@Override
	public int idcheck(MemberDto dto) throws Exception  {
		return dao.idcheck(dto);
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
		session.invalidate();
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
