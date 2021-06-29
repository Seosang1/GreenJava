package vo;

public class ReserveInfo {
	private int rv_idx; // 예약번호
	private String rv_code; // 예약코드 (YYYYMMDD + 001)
	private String hotel_code; // 숙박코드
	private String room_code; // 방코드
	private String mem_id; // 유저아이디
	private String rv_sdate; // 투숙시작일
	private String rv_edate; // 투숙종료일
	private int rv_cnt; // 투숙인원
	private int rv_price; // 금액
	private int rv_discount; // 할인율
	private int rv_dis_price; // 결제금액
	private String rv_name; // 예약자이름
	private String rv_email; // 예약자이메일
	private String rv_phone; // 예약자연락처
	private String rv_content; // 요청사항
	private String rv_payment; // 결제정보 (C : 카드)
	private String rv_agree; // 동의여부 (Y:동의, N:비동의)
	private String rv_date; // 예약일자
	private String rv_state; // 상태 (A:예약확정, B:예약취소, C:여행종료)
	private String rv_cancel_date; // 취소일자
	private String ai_id; // 취소자 (관리자아이디)

	public int getRv_idx() {
		return rv_idx;
	}

	public void setRv_idx(int rv_idx) {
		this.rv_idx = rv_idx;
	}

	public String getRv_code() {
		return rv_code;
	}

	public void setRv_code(String rv_code) {
		this.rv_code = rv_code;
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

	public String getRv_sdate() {
		return rv_sdate;
	}

	public void setRv_sdate(String rv_sdate) {
		this.rv_sdate = rv_sdate;
	}

	public String getRv_edate() {
		return rv_edate;
	}

	public void setRv_edate(String rv_edate) {
		this.rv_edate = rv_edate;
	}

	public int getRv_cnt() {
		return rv_cnt;
	}

	public void setRv_cnt(int rv_cnt) {
		this.rv_cnt = rv_cnt;
	}

	public int getRv_price() {
		return rv_price;
	}

	public void setRv_price(int rv_price) {
		this.rv_price = rv_price;
	}

	public int getRv_discount() {
		return rv_discount;
	}

	public void setRv_discount(int rv_discount) {
		this.rv_discount = rv_discount;
	}

	public int getRv_dis_price() {
		return rv_dis_price;
	}

	public void setRv_dis_price(int rv_dis_price) {
		this.rv_dis_price = rv_dis_price;
	}

	public String getRv_name() {
		return rv_name;
	}

	public void setRv_name(String rv_name) {
		this.rv_name = rv_name;
	}

	public String getRv_email() {
		return rv_email;
	}

	public void setRv_email(String rv_email) {
		this.rv_email = rv_email;
	}

	public String getRv_phone() {
		return rv_phone;
	}

	public void setRv_phone(String rv_phone) {
		this.rv_phone = rv_phone;
	}

	public String getRv_content() {
		return rv_content;
	}

	public void setRv_content(String rv_content) {
		this.rv_content = rv_content;
	}

	public String getRv_payment() {
		return rv_payment;
	}

	public void setRv_payment(String rv_payment) {
		this.rv_payment = rv_payment;
	}

	public String getRv_agree() {
		return rv_agree;
	}

	public void setRv_agree(String rv_agree) {
		this.rv_agree = rv_agree;
	}

	public String getRv_date() {
		return rv_date;
	}

	public void setRv_date(String rv_date) {
		this.rv_date = rv_date;
	}

	public String getRv_state() {
		return rv_state;
	}

	public void setRv_state(String rv_state) {
		this.rv_state = rv_state;
	}

	public String getRv_cancel_date() {
		return rv_cancel_date;
	}

	public void setRv_cancel_date(String rv_cancel_date) {
		this.rv_cancel_date = rv_cancel_date;
	}

	public String getAi_id() {
		return ai_id;
	}

	public void setAi_id(String ai_id) {
		this.ai_id = ai_id;
	}

}
