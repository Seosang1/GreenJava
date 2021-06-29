package vo;

public class RoomInfo {
	private int room_idx; // 방번호
	private String room_code; // 방코드 (r + 인덱스)
	private String hotel_code; // 숙박코드 (t_room_info:hotel_code)
	private String room_type; // 방종류
	private String room_number; // 방호수
	private String room_eq; // 객실구성
	private String room_svc; // 추가제공서비스
	private int room_min; // 기본인원
	private int room_max; // 최대인원
	private int room_price; // 금액
	private int room_discount; // 할인율
	private int room_dis_price; // 할인금액
	private Double room_score; // 평점평균
	private String room_open_yn; // 운영여부 (Y:운영중, N:미운영)
	private String room_reg_date; // 등록일자
	private String room_reg_id; // 등록자 (관리자아이디)
	private String room_del_yn; // 삭제유무 (Y:삭제, N:미삭제)
	private String room_del_date; // 삭제일자
	private String room_del_id; // 취소자 (관리자아이디)
	private String room_img; // 객실 사진
	
	private String hotel_name;	// 숙박이름

	public int getRoom_idx() {
		return room_idx;
	}

	public void setRoom_idx(int room_idx) {
		this.room_idx = room_idx;
	}

	public String getRoom_code() {
		return room_code;
	}

	public void setRoom_code(String room_code) {
		this.room_code = room_code;
	}

	public String getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(String hotel_code) {
		this.hotel_code = hotel_code;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	public String getRoom_eq() {
		return room_eq;
	}

	public void setRoom_eq(String room_eq) {
		this.room_eq = room_eq;
	}

	public String getRoom_svc() {
		return room_svc;
	}

	public void setRoom_svc(String room_svc) {
		this.room_svc = room_svc;
	}

	public int getRoom_min() {
		return room_min;
	}

	public void setRoom_min(int room_min) {
		this.room_min = room_min;
	}

	public int getRoom_max() {
		return room_max;
	}

	public void setRoom_max(int room_max) {
		this.room_max = room_max;
	}

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public int getRoom_discount() {
		return room_discount;
	}

	public void setRoom_discount(int room_discount) {
		this.room_discount = room_discount;
	}

	public int getRoom_dis_price() {
		return room_dis_price;
	}

	public void setRoom_dis_price(int room_dis_price) {
		this.room_dis_price = room_dis_price;
	}

	public Double getRoom_score() {
		return room_score;
	}

	public void setRoom_score(Double room_score) {
		this.room_score = room_score;
	}

	public String getRoom_open_yn() {
		return room_open_yn;
	}

	public void setRoom_open_yn(String room_open_yn) {
		this.room_open_yn = room_open_yn;
	}

	public String getRoom_reg_date() {
		return room_reg_date;
	}

	public void setRoom_reg_date(String room_reg_date) {
		this.room_reg_date = room_reg_date;
	}

	public String getRoom_reg_id() {
		return room_reg_id;
	}

	public void setRoom_reg_id(String room_reg_id) {
		this.room_reg_id = room_reg_id;
	}

	public String getRoom_del_yn() {
		return room_del_yn;
	}

	public void setRoom_del_yn(String room_del_yn) {
		this.room_del_yn = room_del_yn;
	}

	public String getRoom_del_date() {
		return room_del_date;
	}

	public void setRoom_del_date(String room_del_date) {
		this.room_del_date = room_del_date;
	}

	public String getRoom_del_id() {
		return room_del_id;
	}

	public void setRoom_del_id(String room_del_id) {
		this.room_del_id = room_del_id;
	}

	public String getRoom_img() {
		return room_img;
	}

	public void setRoom_img(String room_img) {
		this.room_img = room_img;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	

}
