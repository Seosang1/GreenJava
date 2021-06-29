package admin.action.hotel;

import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import admin.svc.*;
import admin.svc.hotel.*;
import vo.*;

public class RoomUpProcAdminAct implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		/** Image Upload Setting **/
		String urlPath = this.getClass().getResource("").getPath();     
		String imgUrl  = urlPath.substring(0, urlPath.indexOf(".metadata"));
		String uploadPath = imgUrl + "jejurisong/WebContent/common/images/RoomImg";
		// System.out.println("updalodPath : " + uploadPath);  // �� workspace ������ ���ϰ�� ã�ƿ��� ���μ���
		int maxSize = 5 * 1024 * 1024;						// ���ε� �ִ�뷮�� 5MB�� ���� 

		uploadPath = "D:/project/jejurisong/WebContent/common/images/RoomImg";
		System.out.println("updalodPath : " + uploadPath);  // �� workspace ������ ���ϰ�� ã�ƿ��� ���μ���
		
		MultipartRequest multi = new MultipartRequest(
				request, 	// request��ü�� multi�ν��Ͻ��� ���۵� �����͵��� �ޱ� ����
				uploadPath, // ������ ������ ������ ����� ��ġ ����
				maxSize, 	// �� ���� ���ε��� �� �ִ� �ִ�ũ�� ����(byte����)
				"utf-8", 	// ������ ���ڵ� ���
				new DefaultFileRenamePolicy());	// ���� �̸��� �ߺ� ó��
		
		Enumeration files = multi.getFileNames();
		// ���ε��� ���ϸ���� Enumeration������ �޾ƿ�(�� file��Ʈ���� �޾ƿ��� ����)
 
		String img1 = "", img2 = "", img3 = "";
		while (files.hasMoreElements()) {
			String f = (String)files.nextElement();
			switch (f) {
				case "img_1" : img1 = multi.getFilesystemName(f);	break; 
			}
		}
		
//		System.out.println("---------------- img ----------------------");

		if (img1 == null || img1.equals("null"))	img1 = ""; 

//		System.out.println("img1 : "+img1);
//		System.out.println("img2 : "+img2);
//		System.out.println("img3 : "+img3);

		/** Form Parameter VO setting **/
		RoomInfo info = new RoomInfo();
		
//		System.out.println("----------- parameter ---------------");
//		System.out.println(multi.getParameter("sl_area").trim());
//		System.out.println(multi.getParameter("sl_type").trim());
//		System.out.println(multi.getParameter("txt_name").trim());
//		System.out.println(multi.getParameter("txt_zip").trim());
//		System.out.println(multi.getParameter("txt_addr").trim());
//		System.out.println(multi.getParameter("txt_tel").trim());
//		System.out.println(multi.getParameter("txt_stime").trim());
//		System.out.println(multi.getParameter("txt_etime").trim());
//		System.out.println(multi.getParameter("txt_detail").trim());
//		System.out.println("img1 : " + img1);
//		System.out.println("img2 : " + img2);
//		System.out.println("img3 : " + img3);
//		System.out.println(multi.getParameter("rdo_park_yn").trim());
//		System.out.println(multi.getParameter("rdo_open_yn").trim());
//		System.out.println("-----------------------------");
		

		/** Admin id getter **/
		String adminId = "sa";
		System.out.println("������ ���̵� : " + adminId);
		info.setRoom_reg_id(adminId);
		info.setRoom_del_id(adminId);
		
		
		/** ���� �̻��� �����͸� ���� ó�� �Ѵٸ�!!! ����ó�� ���μ��� ���� ���� �� ���� ���� **/
		if (multi.getParameter("hd_del_yn").trim().equals("n") && multi.getParameter("rdo_del_yn").trim().equals("y")) {
 
			String whereInDel = "'" + multi.getParameter("hd_code").trim() + "'";  
			RoomProcAdminSvc procAdminSvc = new RoomProcAdminSvc();  
			HashMap<String, String> ret = procAdminSvc.delete(whereInDel, adminId);
			if (ret.get("result").equals("fail")) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('���� ������ �����Ͽ����ϴ�.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
		}
		 
		/** ���������� ���� �Ϸ�Ǿ��ٸ� ������ �����͵� ���� �����ϱ�  **/
//		info.setRoom_code(multi.getParameter("hd_code").trim());
//		info.setRoom_area(multi.getParameter("sl_area").trim());
//		info.setRoom_type(multi.getParameter("sl_type").trim());
//		info.setRoom_name(multi.getParameter("txt_name").trim());
//		info.setRoom_zip(multi.getParameter("txt_zip").trim());
//		info.setRoom_addr(multi.getParameter("txt_addr").trim());
//		info.setRoom_tel(multi.getParameter("txt_tel").trim());
//		info.setRoom_stime(multi.getParameter("txt_stime").trim());
//		info.setRoom_etime(multi.getParameter("txt_etime").trim());
//		info.setRoom_detail(multi.getParameter("txt_detail").trim());
//		info.setRoom_img1(img1);
//		info.setRoom_img2(img2);
//		info.setRoom_img3(img3);
//		info.setRoom_park_yn(multi.getParameter("rdo_park_yn").trim());
//		info.setRoom_open_yn(multi.getParameter("rdo_open_yn").trim()); 
		  
		
		/** ����&��� ����� �������� �κ� **/
		RoomProcAdminSvc procAdminSvc = new RoomProcAdminSvc(); 
		int result = procAdminSvc.update(info); 	// ���� ���� �������
		if (result == 0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('���� ������ �����Ͽ����ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else { 
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('������ �����Ͽ����ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
		}

		/** ������ �̵� **/
		ActionForward forward = new ActionForward();  
		forward.setRedirect(true);	// redirect ������� �̵��ϵ��� ����
	    forward.setPath("/jejurisong/admin/room_list.hotela");

		return forward;

	}

}
