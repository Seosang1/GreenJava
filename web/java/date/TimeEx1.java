import java.time.*;
import java.time.temporal.*;

class TimeEx1 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();	// ���� ��¥�� LocalDate �ν��Ͻ� today����
		LocalTime now = LocalTime.now();	// ���� �ð����� LocalTime �ν��Ͻ� now����

		LocalDate bDate = LocalDate.of(1999, 12, 31);	// Ư�� ��¥�� �����Ͽ� LocalDate �ν��Ͻ� bDate����
		LocalTime bTime = LocalTime.of(23, 59, 59);		// Ư�� �ð��� �����Ͽ� LocalTime �ν��Ͻ� bTime����

		System.out.println("today : " + today); // 2021-03-30
		System.out.println("now : " + now); // 10:20:31.780371300
		System.out.println("bDate : " + bDate); // 1999-12-31
		System.out.println("bTime : " + bTime); // 23:59:59
		System.out.println();
		System.out.println("bDate.withYear(2000) : " + bDate.withYear(2000)); // 2000-12-31
		// bDate.withYear(2000) : bDate�� ��¥���� �⵵�� 2000���� ����(bDate�� ���� �ȵ�)
		System.out.println("bDate.plusDays(1) : " + bDate.plusDays(1)); // 2000-01-01
		// bDate.plusDays(1) : bDate�� ��¥���� ��(day)�κп� 1�� ���� ��¥ ����
		System.out.println("bDate.plus(1, ChronoUnit.DAYS) : " + bDate.plus(1, ChronoUnit.DAYS));
		// 2000-01-01
		System.out.println();
		System.out.println("bTime.truncatedTo(ChronoUnit.HOURS) : " + 
			bTime.truncatedTo(ChronoUnit.HOURS)); // 23:00
		// bTime.truncatedTo(ChronoUnit.HOURS) : bTime�� �ð����� ������ ��(hour)���� ���� ���ֵ��� 0���� ����
	}
}
