class StringEx3 {
	public static void main(String[] args) {
		String str1 = "880525-1234567";		String str2 = "890515-2234567";
		String str3 = "0805253234567";		String str4 = "0905154234567";

		showBirth(str1);	showGender(str1);	showBirth(str2);	showGender(str2);
		showBirth(str3);	showGender(str3);	showBirth(str4);	showGender(str4);
	}
	public static void showBirth(String str) {
	// 주민등록번호를 이용하여 생년월일을 출력하는 메소드
	/* 주민등록번호의 앞 6자리를 이용하여 "yyyy년 mm월 dd일 생"으로 출력 */
		int i = 6;
		if (str.length() == 14)		i = 7;
		char g = str.charAt(i);

		String year = (g <= '2' ? "19" : "20") + str.substring(0, 2);
		String month = str.substring(2, 4);
		String day = str.substring(4, 6);
		System.out.println(year + "년 " + month + "월 " + day + "일 생");
	}
	public static void showGender(String str) {
	// 주민등록번호를 이용하여 성별을 출력하는 메소드
	/* 주민등록번호를 이용하여 "남자" 또는 "여자"로 출력 */
		int i = 6;	// 성별구분자의 위치 인덱스를 저장할 변수
		if (str.indexOf('-') >= 0)	i = 7;
		char g = str.charAt(i);

		if (g % 2 == 1)	System.out.println("남자");
		else			System.out.println("여자");
	}
}
