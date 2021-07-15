package kr.co.web.model.Member;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto user = null;
		
		try {
			return sqlSession.selectOne(NAMESPACE+"login", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int memberjoin(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String Idcheck(MemberDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void PWcheck(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String searchId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchPw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String loginCheck(MemberDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String level(MemberDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forced_Admin(String u_id, String u_pwd) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
