/*
1. 생년월일을 yyyy-mm-dd형으로 입력받아 Calendar형 인스턴스로 생성한 후 출력
2. Calendar형 인스턴스의 값들을 이용하여 LocalDate형 인스턴스로 생성한 후 출력
3. 입력받은 생일을 기준으로 나이를 계산하여 출력
*/
import java.util.*;
import java.time.*;
import java.time.temporal.*;

class BirthTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("생년월일(yyyy-mm-dd) : ");
		String birth = sc.nextLine();

		Calendar cDate = Calendar.getInstance();	// Carlendar 객체를 만들기 위한 인스턴스
		int cYear = cDate.get(Calendar.YEAR);	// 나이를 구하기 위한 올해 연도
		String[] arrBirth = birth.split("-");	// 입력받은 날짜 문자열을 연월일로 쪼개어 배열에 저장

		int year = Integer.parseInt(arrBirth[0]);
		int mon = Integer.parseInt(arrBirth[1]) - 1;
		int day = Integer.parseInt(arrBirth[2]);
		// Calendar의 set()과 LocalDate의 of() 메소드에서 인수로 사용하기 위해 int형으로 형변환

		cDate.set(year, mon, day);
		// 사용자가 입력한 값을 이용하여 생일 Calendar 형 인스턴스 생성
		System.out.println(cDate.get(Calendar.YEAR) + "년 " + (cDate.get(Calendar.MONTH) + 1)
			+ "월 " + cDate.get(Calendar.DATE) + "일");

		LocalDate lDate = LocalDate.of(year, mon + 1, day);
		// 사용자가 입력한 값을 이용하여 생일 LocalDate 형 인스턴스 생성
		System.out.println(lDate);
		System.out.println("나이 : " + (cYear - year) + "살");
	}
}
