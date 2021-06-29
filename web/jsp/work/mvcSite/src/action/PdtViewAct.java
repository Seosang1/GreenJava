package action;

import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

public class PdtViewAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");	// ��ǰID
		int cpage = Integer.parseInt(request.getParameter("cpage")); // ���� ������ ��ȣ
		int psize = Integer.parseInt(request.getParameter("psize")); // ������ũ��&��Ϻ�����

		// �˻�����(�˻���, ��/�Һз�, �귣��, ���ݴ�) �� �������� ������Ʈ��
		String keyword, bcata, scata, brand, sprice, eprice, ord;
		keyword	= request.getParameter("keyword");	// �˻���
		bcata	= request.getParameter("bcata");	// ��з�
		scata	= request.getParameter("scata");	// �Һз�
		brand	= request.getParameter("brand");	// �귣��
		sprice	= request.getParameter("sprice");	// ���ݴ� �� ���� ����
		eprice	= request.getParameter("eprice");	// ���ݴ� �� ���� ����
		ord 	= request.getParameter("ord");		// ��������

		PdtViewSvc pdtViewSvc = new PdtViewSvc();
		ProductInfo pdtInfo = pdtViewSvc.getPdtInfo(id);

		request.setAttribute("pdtInfo", pdtInfo);

		ActionForward forward = new ActionForward();
		forward.setPath("/product/pdt_view.jsp");

		return forward;
	}
}
