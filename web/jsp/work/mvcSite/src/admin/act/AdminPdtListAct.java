package admin.act;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminPdtListAct implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();

		request.setCharacterEncoding("utf-8");
		int cpage = 1, psize = 15, bsize = 10, spage, epage, rcnt, pcnt;
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));

		// �˻�����(�˻���, ��/�Һз�, �귣��, ���ݴ�) ������Ʈ��
		String isview	= request.getParameter("isview");	// �Խÿ���(y, n)
		String schtype	= request.getParameter("schtype");	// �˻�����(id, ��ǰ��)
		String keyword	= request.getParameter("keyword");	// �˻���
		String bcata	= request.getParameter("bcata");	// ��з�
		String scata	= request.getParameter("scata");	// �Һз�
		String brand	= request.getParameter("brand");	// �귣��
		String sprice	= request.getParameter("sprice");	// ���ݴ� �� ���� ����
		String eprice	= request.getParameter("eprice");	// ���ݴ� �� ���� ����
		String sdate	= request.getParameter("sdate");	// ��ϱⰣ �� ������
		String edate	= request.getParameter("edate");	// ��ϱⰣ �� ������
		String stock	= request.getParameter("stock");	// ���(�̻�)

		// �˻� ���ǿ� ���� where�� ����
		String where = " where 1=1 ";
		if (!isEmpty(isview))	where += " and pi_isview = '" + isview + "' ";
		else	isview = "";
		if (!isEmpty(keyword))	where += " and pi_" + schtype + " like '%" + keyword + "%' ";
		else { keyword = "";	schtype = ""; }
		if (!isEmpty(bcata))	where += " and cb_id = '" + bcata + "' ";
		else	bcata = "";
		if (!isEmpty(scata))	where += " and cs_id = '" + scata + "' ";
		else	scata = "";
		if (!isEmpty(brand))	where += " and b_id = '" + brand + "' ";
		else	brand = "";
		if (!isEmpty(sprice))	where += " and pi_price >= '" + sprice + "' ";
		else	sprice = "";
		if (!isEmpty(eprice))	where += " and pi_price <= '" + eprice + "' ";
		else	eprice = "";
		if (!isEmpty(sdate))	where += " and pi_date >= '" + sdate + " 00:00:00' ";
		else	sdate = "";
		if (!isEmpty(edate))	where += " and pi_date <= '" + edate + " 23:59:59' ";
		else	edate = "";
		if (!isEmpty(stock))	where += " and (pi_stock = -1 or pi_stock >= '" + stock + "') ";
		else	stock = "";

		// ��������(�Ǹŷ�-��, ����-����, ���-��(�⺻), ��ǰ��-��, ����-��) ������Ʈ��
		String ord = request.getParameter("ord");
		if (ord == null || ord.equals(""))	ord = "idd";	// ��� �������� ������ �⺻��
		String orderBy = " order by a.pi_" + ord.substring(0, ord.length() - 1) + 
			(ord.charAt(ord.length() - 1) == 'a' ? " asc" : " desc");
		// �������ǿ� ���� order by�� ����

		AdminPdtListSvc adminPdtListSvc = new AdminPdtListSvc();
		rcnt = adminPdtListSvc.getPdtCount(where);
		pdtList = adminPdtListSvc.getPdtList(where, orderBy, cpage, psize);

		pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;				// ��ü ������ ��
		spage = (cpage - 1) / bsize * bsize + 1;	// ����� ���� ������ ��ȣ
		epage = spage + bsize - 1;
		if (epage > pcnt)		epage = pcnt;		// ����� ���� ������ ��ȣ

		PdtPageInfo pageInfo = new PdtPageInfo();	// ����¡�� �ʿ��� �������� ������ �ν��Ͻ�
		// ����¡�� �ʿ��� ������
		pageInfo.setCpage(cpage);		// ���� ������ ��ȣ
		pageInfo.setRcnt(rcnt);			// ��ü �Խñ� ����
		pageInfo.setPcnt(pcnt);			// ��ü ������ ����
		pageInfo.setSpage(spage);		// ��� ���� ������ ��ȣ
		pageInfo.setEpage(epage);		// ��� ���� ������ ��ȣ
		pageInfo.setPsize(psize);		// ������ ũ��
		pageInfo.setBsize(bsize);		// ��� ũ��

		// �˻����� ������
		pageInfo.setSchtype(schtype);	// �˻�����(���̵� or ��ǰ��)
		pageInfo.setKeyword(keyword);	// �˻���
		pageInfo.setBcata(bcata);		// ��з�
		pageInfo.setScata(scata);		// �Һз�
		pageInfo.setBrand(brand);		// �귣��
		pageInfo.setSprice(sprice);		// ���ݴ�(���۰�)
		pageInfo.setEprice(eprice);		// ���ݴ�(���ᰡ)
		pageInfo.setIsview(isview);		// �Խÿ���
		pageInfo.setSdate(sdate);		// ��ϱⰣ �� ������
		pageInfo.setEdate(edate);		// ��ϱⰣ �� ������
		pageInfo.setStock(stock);		// ���
		pageInfo.setOrd(ord);			// ��������

		ArrayList<CataBigInfo> cataBigList = adminPdtListSvc.getCataBigList();
		ArrayList<CataSmallInfo> cataSmallList = adminPdtListSvc.getCataSmallList();
		ArrayList<BrandInfo> brandList = adminPdtListSvc.getBrandList();

		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pdtList", pdtList);
		request.setAttribute("cataBigList", cataBigList);
		request.setAttribute("cataSmallList", cataSmallList);
		request.setAttribute("brandList", brandList);

		ActionForward forward = new ActionForward();
		forward.setPath("/admin/product/pdt_list.jsp");

		return forward;
	}

	private boolean isEmpty(String str) {	// �Ű������� � ���̵� ��� �ִ��� ���θ� �˻��ϴ� �޼ҵ�
		boolean empty = true;
		if (str != null && !str.equals(""))	empty = false;
		return empty;
	}
}
