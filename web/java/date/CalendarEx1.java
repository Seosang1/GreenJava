import java.util.*;

class CalendarEx1 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();	// ���� ��¥ �� ���� �ð��� ����
		// Calendar Ŭ������ abstract Ŭ�����̹Ƿ� �ν��Ͻ��� �����ڰ� �ƴ� �޼ҵ带 ���� ����

		System.out.println("�� ���� �⵵ : " + today.get(Calendar.YEAR)); // 2021
		System.out.println("��(0~11) : " + today.get(Calendar.MONTH)); // 2
		System.out.println("�� ���� �� °�� : " + today.get(Calendar.WEEK_OF_YEAR)); // 14
		System.out.println("�� ���� �� °�� : " + today.get(Calendar.WEEK_OF_MONTH)); // 5
		System.out.println("�� ���� �� �� : " + today.get(Calendar.DATE)); // 29
		System.out.println("�� ���� �� �� : " + today.get(Calendar.DAY_OF_MONTH)); // 29
		System.out.println("�� ���� �� �� : " + today.get(Calendar.DAY_OF_YEAR)); // 88
		System.out.println("����(1~7, 1:�Ͽ���) : " + today.get(Calendar.DAY_OF_WEEK)); // 2
		System.out.println("�� ���� �� ° ���� : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH)); // 5
		System.out.println();
		System.out.println("����_����(0:����,1:����) : " + today.get(Calendar.AM_PM)); // 0
		System.out.println("��(0~11) : " + today.get(Calendar.HOUR)); // 10
		System.out.println("��(0~23) : " + today.get(Calendar.HOUR_OF_DAY)); // 10
		System.out.println("��(0~59) : " + today.get(Calendar.MINUTE)); // 5
		System.out.println("��(0~59) : " + today.get(Calendar.SECOND)); // 18
		System.out.println("�и���(0~999) : " + today.get(Calendar.MILLISECOND)); // 787
		System.out.println("�� ���� ���� : " + today.getActualMaximum(Calendar.DATE)); // 31
	}
}
