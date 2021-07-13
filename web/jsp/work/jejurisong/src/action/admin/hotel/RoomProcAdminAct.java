package action.admin.hotel;

import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

import svc.hotel.*;
import svc.user.*;
import vo.*;

public class RoomProcAdminAct implements action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		/** Image Upload Setting **/
		String urlPath = this.getClass().getResource("").getPath();
		String imgUrl = urlPath.substring(0, urlPath.indexOf(".metadata"));
		String uploadPath = imgUrl + "jejurisong/WebContent/common/images/RoomImg";
		System.out.println("updalodPath1 : " + uploadPath); // 내 workspace 기준의 파일경로
		// 찾아오는 프로세스
		int maxSize = 5 * 1024 * 1024; // 업로드 최대용량은 5MB로 지정

		//uploadPath = "D:/project/jejurisong/WebContent/common/images/RoomImg";
		//System.out.println("updalodPath2 : " + uploadPath); // 내 workspace 기준의 파일경로 찾아오는 프로세스

		MultipartRequest multi = new MultipartRequest(request, // request객체로 multi인스턴스로 전송된 데이터들을 받기 위함
				uploadPath, // 서버에 실제로 파일이 저장될 위치 지정
				maxSize, // 한 번에 업로드할 수 있는 최대크기 지정(byte단위)
				"utf-8", // 파일의 인코딩 방식
				new DefaultFileRenamePolicy()); // 파일 이름의 중복 처리

		Enumeration files = multi.getFileNames();

		String img1 = "", img2 = "", img3 = "";
		while (files.hasMoreElements()) {
			String f = (String) files.nextElement();
			switch (f) {
			case "img_1":
				img1 = multi.getFilesystemName(f);
				break;
			}
		}

		if (img1 == null || img1.equals("null"))
			img1 = "";

		/** Form Parameter VO setting **/
		RoomInfo info = new RoomInfo();
		 
		System.out.println("hotel_code : " + multi.getParameter("hd_hotel_code").trim());
		info.setHotel_code(multi.getParameter("hd_hotel_code").trim());
		info.setRoom_type(multi.getParameter("sl_type").trim());
		info.setRoom_eq(multi.getParameter("hd_eq").trim());
		info.setRoom_svc(multi.getParameter("txt_svc").trim());
		
		info.setRoom_min(Integer.parseInt(multi.getParameter("txt_min")));
		info.setRoom_max(Integer.parseInt(multi.getParameter("txt_max")));
		info.setRoom_price(Integer.parseInt(multi.getParameter("txt_price")));
		info.setRoom_discount(Integer.parseInt(multi.getParameter("txt_discount")));
		info.setRoom_dis_price(Integer.parseInt(multi.getParameter("txt_dis_price")));
		info.setRoom_cnt(Integer.parseInt(multi.getParameter("txt_number")));
		
		info.setRoom_img(img1); 
		info.setRoom_open_yn(multi.getParameter("rdo_open_yn").trim());
		
		/** Admin id getter **/
		String adminId = "sa";
		System.out.println("관리자 아이디 : " + adminId);
		info.setRoom_reg_id(adminId);

		/** 서비스&디비 결과값 가져오는 부분 **/
		RoomSvc procAdminSvc = new RoomSvc();  
		String code = procAdminSvc.getCode();
		info.setRoom_code(code);
		int result = procAdminSvc.insert(info);
		if (result == 0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록에 실패하였습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}

		/** 페이지 이동 **/
		ActionForward forward = new ActionForward();
		forward.setRedirect(true); // redirect 방식으로 이동하도록 지정
		forward.setPath("/jejurisong/admin/room_list.rooma");

		return forward;

	}

}
