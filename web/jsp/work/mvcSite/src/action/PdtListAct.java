package action;

import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

public class PdtListAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
		
		request.setCharacterEncoding("utf-8");
		int cpage = 1, psize = 12, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));

		// �˻�����(�˻���, ��/�Һз�, �귣��, ���ݴ�) ������Ʈ��
		String keyword, bcata, scata, brand, sprice, eprice;
		keyword	= request.getParameter("keyword");	// �˻���
		bcata	= request.getParameter("bcata");	// ��з�
		scata	= request.getParameter("scata");	// �Һз�
		brand	= request.getParameter("brand");	// �귣��
		sprice	= request.getParameter("sprice");	// ���ݴ� �� ���� ����
		eprice	= request.getParameter("eprice");	// ���ݴ� �� ���� ����

		// �˻� ���ǿ� ���� where�� ����
		String where = " where a.cs_id = c.cs_id and b.cb_id = c.cb_id and " + 
			"a.b_id = d.b_id and a.pi_isview = 'y' ";
		if (!isEmpty(keyword))	where += " and a.pi_name like '%" + keyword + "%' ";
		if (!isEmpty(bcata))	where += " and b.cb_id = '" + bcata + "' ";
		if (!isEmpty(scata))	where += " and c.cs_id = '" + scata + "' ";
		if (!isEmpty(brand))	where += " and d.b_id = '" + brand + "' ";
		if (!isEmpty(sprice))	where += " and a.pi_price >= '" + sprice + "' ";
		if (!isEmpty(eprice))	where += " and a.pi_price <= '" + eprice + "' ";

		// ��������(�Ǹŷ�-��, ����-����, ���-��(�⺻), ��ǰ��-��, ����-��) ������Ʈ��
		String ord = request.getParameter("ord");
		if (ord == null || ord.equals(""))	ord = "idd";	// ��� �������� ������ �⺻��
		String orderBy = " order by a.pi_" + ord.substring(0, ord.length() - 1) + 
			(ord.charAt(ord.length() - 1) == 'a' ? " asc" : " desc");
		// �������ǿ� ���� order by�� ����

		PdtListSvc pdtListSvc = new PdtListSvc();
		rcnt = pdtListSvc.getPdtCount(where);
		// �˻��� ��ǰ�� �� ����(������ ������ ���ϱ� ���� �ʿ�)

		ActionForward forward = new ActionForward();
		forward.setPath("/product/pdt_list.jsp");

		return forward;
	}

	private boolean isEmpty(String str) {	// �Ű������� � ���̵� ��� �ִ��� ���θ� �˻��ϴ� �޼ҵ�
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}
}