package action;

import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

public class NoticeListAction implements Action {
// �Խñ� ����� �޾ƿ� �����ϴ� Ŭ����
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// Action �������̽��� abstract �޼ҵ��� execute()�� �������̵��Ͽ� ����
		ArrayList<NoticeInfo> articleList = new ArrayList<NoticeInfo>();
		// �������� �Խñ��� ����� ������ ArrayList �ν��Ͻ��� NoticeInfo�� �ν��Ͻ��� ������

		request.setCharacterEncoding("utf-8");
		int cpage = 1, psize = 3, bsize = 10;
		// ���� ������ ��ȣ�� �� ���������� ������ �Խñ� ����, �� ���Ͽ��� ������ ������ ������ ������ ���� �ʱ�ȭ
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		// ���� ��������ȣ�� ������ �޾ƿ� ��������ȣ�� ���������� ����ȯ�Ͽ� ����
		// DB ������ ������ ���� ���԰� cpage�� ��������� �ؾ� �ϱ� ������ int������ ����ȯ�� �ؾ� ��

		String schtype = request.getParameter("schtype"); // �˻��������� ����, ����, ����+����
		String keyword = request.getParameter("keyword"); // �˻���
		
		String where = "";	// �˻�� ���� ��쿡�� ���� ��
		if (keyword != null && !keyword.equals("")) {	// �˻�� ���� ��쿡�� where�� ����
			if (schtype.equals("tc")) {	// �˻������� ����+���� �ϰ��
				where = " where bn_title like '%" + keyword + "%' or " + 
					"bn_content like '%" + keyword + "%' ";
			} else {
				where = " where bn_" + schtype + " like '%" + keyword + "%' ";
			}
		}

		NoticeListSvc noticeListSvc = new NoticeListSvc();
		// �Խ��� ����� ���� ����Ͻ� ������ ó���ϱ� ���� NoticeListSvc �ν��Ͻ� ����
		
		int rcnt = noticeListSvc.getArticleCount(where);
		// �� ���ڵ� ������ �޾ƿ�(��ü ���������� �˱� ����)

		articleList = noticeListSvc.getArticleList(where, cpage, psize);
		// ���ȭ�鿡�� ������ �Խñ� ����� ArrayList�� �޾ƿ�
		
		int pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;	// ��ü ������ ��
		
		int spage = (cpage - 1) / bsize * bsize + 1;	// ���� ���� ������ ��ȣ
		int epage = spage + bsize - 1;
		if (epage > pcnt)	epage = pcnt;				// ���� ���� ������ ��ȣ
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCpage(cpage);		// ���� ������ ��ȣ
		pageInfo.setRcnt(rcnt);			// ��ü �Խñ� ����
		pageInfo.setPcnt(pcnt);			// ��ü ������ ����
		pageInfo.setSpage(spage);		// ���� ���� ������ ��ȣ
		pageInfo.setEpage(epage);		// ���� ���� ������ ��ȣ
		pageInfo.setPsize(psize);		// ������ ũ��
		pageInfo.setBsize(bsize);		// ���� ũ��
		pageInfo.setSchtype(schtype);	// �˻�����
		pageInfo.setKeyword(keyword);	// �˻���
		// ��� ������ ������ �ʿ��� ������ ���ȭ������ ������ ���� �ϱ� ���� �ϳ��� �ν��Ͻ��� ����

		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		// notice_list.jsp�� request�� ���� �������� ��ü�� request�� ����
		// dispatch������� �̵��� ���̹Ƿ� �̵��ϴ� ������ ���� ������ request�� response�� ����� �� ����

		ActionForward forward = new ActionForward();
		forward.setPath("/bbs/notice_list.jsp");
		// forward�ν��Ͻ��� setPath() �޼ҵ带 �̿��Ͽ� forward�ν��Ͻ��� path ��������� ���� ����
		
		return forward;
	}
}