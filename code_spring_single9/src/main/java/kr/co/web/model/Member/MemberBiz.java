package kr.co.web.model.Member;

import javax.servlet.http.HttpSession;

public interface MemberBiz {
	
	//����
	//濡�洹몄��
	public MemberDto userlogin(MemberDto dto) throws Exception;
	
	//����媛���
	public int memberjoin(MemberDto dto);
	
	//����媛��� ���대�� 以�蹂듭껜��
	public int idcheck(MemberDto dto) throws Exception;
	
	//����媛��� 鍮�諛�踰��� ����
	public void PWcheck(MemberDto dto); 
	
	//����媛��� �대���&�몃���� �몄�
	
	//���대�� 李얘린
	public String searchId();
	
	//鍮�諛�踰��� 李얘린
	public void searchPw();
	
	//濡�洹몄����
	public void logout(HttpSession session);
	
	//愿�由ъ��
	//���� ��蹂� 議고��
	public String loginCheck(MemberDto dto);
	
	//���� �깃� 議곗��
	public String level(MemberDto dto);
	
	//���� 媛��� ����
	public String forced_Admin(String u_id, String u_pwd);

}
