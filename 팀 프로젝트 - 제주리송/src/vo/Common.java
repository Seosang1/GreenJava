package vo;

import java.util.HashMap;

public class Common {

	private HashMap<String, String> area = new HashMap();

	private HashMap<String, String> delYn = new HashMap();
	
	private HashMap<String, String> openYn = new HashMap();

	private HashMap<String, String> flightClass = new HashMap();

	private HashMap<String, String> flightCompany = new HashMap();

	private HashMap<String, String> flightEcity = new HashMap();

	private HashMap<String, String> flightScity = new HashMap();

	private HashMap<String, String> foodType = new HashMap();

	private HashMap<String, String> hoteEquip = new HashMap();

	private HashMap<String, String> hotelType = new HashMap();

	private HashMap<String, String> plannerType = new HashMap();

	private HashMap<String, String> roomType = new HashMap();

	private HashMap<String, String> tourType = new HashMap();

	private HashMap<String, String> hotelParking_yn = new HashMap();
	
	

	public HashMap<String, String> getOpenYn() {
		openYn.put("y", "운영중");
		openYn.put("n", "운영종료");
		return openYn;
	}

	public HashMap<String, String> getHotelParking_yn() {
		hotelParking_yn.put("y", "주차가능");
		hotelParking_yn.put("n", "주차불가능");
		return hotelParking_yn;
	}

	public HashMap<String, String> getArea() {
		area.put("N", "제주시");
		area.put("E", "정의군");
		area.put("W", "대정군");
		area.put("S", "서귀포시");
		return area;
	}

	public HashMap<String, String> getDelYn() {
		delYn.put("y", "삭제완료");
		delYn.put("n", "미삭제");
		return delYn;
	}

	public HashMap<String, String> getFlightClass() {
		flightClass.put("a", "전체");
		flightClass.put("n", "일반석");
		flightClass.put("d", "할인석");
		flightClass.put("b", "비즈니스석");
		return flightClass;
	}

	public HashMap<String, String> getFlightCompany() {
		flightCompany.put("KE", "대한항공");
		flightCompany.put("OZ", "아시아나");
		flightCompany.put("JJ", "제주항공");
		flightCompany.put("LG", "진에어");
		flightCompany.put("ARI", "에어부산");
		return flightCompany;
	}

	public HashMap<String, String> getFlightEcity() {
		flightEcity.put("CJU", "제주");
		flightEcity.put("PUS", "부산");
		flightEcity.put("KWJ", "광주");
		flightEcity.put("TAE", "대구");
		flightEcity.put("KPO", "포항");
		flightEcity.put("MWX", "무안");
		flightEcity.put("RSU", "여수");
		flightEcity.put("USN", "울산");
		flightEcity.put("HIN", "진주");
		flightEcity.put("YNY", "양양");
		return flightEcity;
	}

	public HashMap<String, String> getFlightScity() {
		flightScity.put("GMP", "김포");
		flightScity.put("ICN", "인천");
		flightScity.put("PUS", "부산");
		flightScity.put("CJU", "제주");
		flightScity.put("KWJ", "광주");
		flightScity.put("TAE", "대구");
		flightScity.put("KPO", "포항");
		flightScity.put("CJJ", "청주");
		flightScity.put("MWX", "무안");
		flightScity.put("RSU", "여수");
		flightScity.put("USN", "울산");
		flightScity.put("HIN", "진주");
		flightScity.put("KUV", "군산");
		flightScity.put("WJU", "원주");
		flightScity.put("YNY", "양양");
		return flightScity;
	}

	public HashMap<String, String> getFoodType() {
		foodType.put("KFR", "한식");
		foodType.put("CFR", "중식");
		foodType.put("WFR", "양식");
		foodType.put("CR", "카페");
		foodType.put("KJFR", "향토음식");
		foodType.put("JFR", "일식");
		return foodType;
	}

	public HashMap<String, String> getHoteEquip() {
		hoteEquip.put("EQ01", "취사");
		hoteEquip.put("EQ02", "에어컨");
		hoteEquip.put("EQ03", "TV");
		hoteEquip.put("EQ04", "냉장고");
		hoteEquip.put("EQ05", "쇼파");
		hoteEquip.put("EQ06", "T테이블");
		hoteEquip.put("EQ07", "테라스");
		hoteEquip.put("EQ08", "컴퓨터");
		hoteEquip.put("EQ09", "세탁기");
		hoteEquip.put("EQ10", "skylife");
		hoteEquip.put("EQ11", "헤어드라이");
		hoteEquip.put("EQ12", "전자렌지");
		return hoteEquip;
	}

	public HashMap<String, String> getHotelType() {
		hotelType.put("CMP", "캠프장");
		hotelType.put("MTL", "모텔");
		hotelType.put("GHS", "게스트하우스");
		hotelType.put("PNS", "펜션");
		hotelType.put("APT", "아파트");
		hotelType.put("VILL", "빌라");
		hotelType.put("HTL", "호텔");
		hotelType.put("RST", "리조트");
		return hotelType;
	}

	public HashMap<String, String> getPlannerType() {
		plannerType.put("RHT", "휴식과 치유여행");
		plannerType.put("LT", "레저와 체험");
		plannerType.put("WT", "천천히 걷기");
		plannerType.put("ET", "식도락 여행");
		plannerType.put("JOT", "제주의 문화유산");
		plannerType.put("MFT", "전시와 행사");
		plannerType.put("ST", "쇼핑하기");
		plannerType.put("ART", "관리자 추천여행");
		return plannerType;
	}

	public HashMap<String, String> getRoomType() {
		roomType.put("SDR", "Standard Room");
		roomType.put("SPR", "Superior Room");
		roomType.put("DXR", "Deluxe Room");
		roomType.put("ECR", "Excecutive Room");
		roomType.put("STR", "Suite Room");
		roomType.put("SBR", "Single Bed Room");
		roomType.put("DBR", "Double Bed Room");
		roomType.put("WBR", "Twin Bed Room");
		roomType.put("TPR", "Triple Room");
		roomType.put("FMR", "Family Room");
		roomType.put("CTR", "Connecting Room");
		return roomType;
	}

	public HashMap<String, String> getTourType() {
		tourType.put("NT", "자연");
		tourType.put("CT", "문화관광");
		tourType.put("AT", "엑티비티");
		return tourType;
	}

	// 매개변수에 어떤 값이든 들어 있는지 여부를 검사하는 메소드
	public boolean isEmpty(String str) {
		boolean empty = true;
		if (str != null && !str.equals(""))
			empty = false;
		return empty;
	}
 
	// Parameter 변수 null -> "" 으로 변환 
	public String nullToString(String str) {
		String toStr = "";
		if (str != null && !str.equals("")) {
			toStr = str;
		} else {
			toStr = "";
		}
		return toStr;
	}
	
	// 문자열 길면 len 까지만 노출하고 ...
	public String txtToShort(String str, int len) {
		String toStr = "";
		if (str.length() > len ) {
			toStr = str.substring(0, len) + "...";
		} else {
			toStr = str;
		}
		return toStr;
	}
}
