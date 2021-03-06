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
		// System.out.println("updalodPath : " + uploadPath);  // 내 workspace 기준의 파일경로 찾아오는 프로세스
		int maxSize = 5 * 1024 * 1024;						// 업로드 최대용량은 5MB로 지정 

		uploadPath = "D:/project/jejurisong/WebContent/common/images/RoomImg";
		System.out.println("updalodPath : " + uploadPath);  // 내 workspace 기준의 파일경로 찾아오는 프로세스
		
		MultipartRequest multi = new MultipartRequest(
				request, 	// request객체로 multi인스턴스로 전송된 데이터들을 받기 위함
				uploadPath, // 서버에 실제로 파일이 저장될 위치 지정
				maxSize, 	// 한 번에 업로드할 수 있는 최대크기 지정(byte단위)
				"utf-8", 	// 파일의 인코딩 방식
				new DefaultFileRenamePolicy());	// 파일 이름의 중복 처리
		
		Enumeration files = multi.getFileNames();
		// 업로드할 파일명들을 Enumeration형으로 받아옴(빈 file컨트롤은 받아오지 않음)
 
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
		System.out.println("관리자 아이디 : " + adminId);
		info.setRoom_reg_id(adminId);
		info.setRoom_del_id(adminId);
		
		
		/** 만약 미삭제 데이터를 삭제 처리 한다면!!! 삭제처리 프로세스 먼저 실행 후 수정 진행 **/
		if (multi.getParameter("hd_del_yn").trim().equals("n") && multi.getParameter("rdo_del_yn").trim().equals("y")) {
 
			String whereInDel = "'" + multi.getParameter("hd_code").trim() + "'";  
			RoomProcAdminSvc procAdminSvc = new RoomProcAdminSvc();  
			HashMap<String, String> ret = procAdminSvc.delete(whereInDel, adminId);
			if (ret.get("result").equals("fail")) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정보 수정에 실패하였습니다.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
		}
		 
		/** 정상적으로 수정 완료되었다면 나머지 데이터도 수정 진행하기  **/
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
		  
		
		/** 서비스&디비 결과값 가져오는 부분 **/
		RoomProcAdminSvc procAdminSvc = new RoomProcAdminSvc(); 
		int result = procAdminSvc.update(info); 	// 정보 저장 결과여부
		if (result == 0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보 수정에 실패하였습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else { 
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보를 수정하였습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}

		/** 페이지 이동 **/
		ActionForward forward = new ActionForward();  
		forward.setRedirect(true);	// redirect 방식으로 이동하도록 지정
	    forward.setPath("/jejurisong/admin/room_list.hotela");

		return forward;

	}

}
