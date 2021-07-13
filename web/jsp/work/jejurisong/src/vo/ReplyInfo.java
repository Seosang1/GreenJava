package vo;

public class ReplyInfo { 
	
    
	private int room_re_idx; 		// 번호
	private String rv_code;			// 예약코드
	private String hotel_code; 		// 숙박코드 (t_room_info:hotel_code)
	private String room_code; 		// 방코드 (r + 인덱스)
	private String mem_id;			// 유저아이디
	private String room_re_content;	// 후기내용
	private Double room_re_score;	// 평점
	private String room_re_date;	// 등록일
	private String room_re_del_yn;	// 삭제유무 (y: 삭졔 , n:미삭제)
	private String room_re_del;		// 삭제일
	private String room_re_del_id;	// 삭제처리자 (작성자 회원 or 삭제관리자)

	private String hotel_name;		// 호텔명
	private String room_type;		// 방종류
	private String mem_img;			// 회원 사진
	
	
	 
	public String getMem_img() {
		return mem_img;
	}
	public void setMem_img(String mem_img) {
		this.mem_img = mem_img;
	}
	public String getRv_code() {
		return rv_code;
	}
	public void setRv_code(String rv_code) {
		this.rv_code = rv_code;
	}
	public int getRoom_re_idx() {
		return room_re_idx;
	}
	public void setRoom_re_idx(int room_re_idx) {
		this.room_re_idx = room_re_idx;
	}
	public String getHotel_code() {
		return hotel_code;
	}
	public void setHotel_code(String hotel_code) {
		this.hotel_code = hotel_code;
	}
	public String getRoom_code() {
		return room_code;
	}
	public void setRoom_code(String room_code) {
		this.room_code = room_code;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getRoom_re_content() {
		return room_re_content;
	}
	public void setRoom_re_content(String room_re_content) {
		this.room_re_content = room_re_content;
	}
	public Double getRoom_re_score() {
		return room_re_score;
	}
	public void setRoom_re_score(Double room_re_score) {
		this.room_re_score = room_re_score;
	}
	public String getRoom_re_date() {
		return room_re_date;
	}
	public void setRoom_re_date(String room_re_date) {
		this.room_re_date = room_re_date;
	}
	public String getRoom_re_del_yn() {
		return room_re_del_yn;
	}
	public void setRoom_re_del_yn(String room_re_del_yn) {
		this.room_re_del_yn = room_re_del_yn;
	}
	public String getRoom_re_del() {
		return room_re_del;
	}
	public void setRoom_re_del(String room_re_del) {
		this.room_re_del = room_re_del;
	}
	public String getRoom_re_del_id() {
		return room_re_del_id;
	}
	public void setRoom_re_del_id(String room_re_del_id) {
		this.room_re_del_id = room_re_del_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	} 
	
}