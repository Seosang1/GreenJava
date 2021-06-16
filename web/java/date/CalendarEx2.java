import java.util.*;

class CalendarEx2 {
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK ={"", "��", "��", "ȭ", "��", "��", "��", "��"};
		// �����̸��� ����ϱ� ���� ��� �迭 - ���� ��ȣ�� 1���� �����ϹǷ� ù��° ��Ҹ� �����

		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		date1.set(2020, 1, 15);	// date1�� ��¥�� 2020�� 2�� 15�Ϸ� ����
		System.out.println("date1�� " + toString(date1) + 
			DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "�����̰�, ");
		// date1�� 2020�� 2�� 15��������̰�,

		System.out.println("����(date2)�� " + toString(date2) + 
			DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "�����̴�.");
		// ����(date2)�� 2021�� 3�� 29�Ͽ������̴�.

		long diff = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		// getTimeInMillis() : ������ ��¥ �� �ð��� 1970�� 1�� 1�� 0�ø� ������ �и��� ������ �����ϴ� �޼ҵ�
		System.out.println("�� ��(date1) ���� ����(date2)���� " + diff + "�ʰ� �������ϴ�.");
		// �� ��(date1) ���� ����(date2)���� 35251200�ʰ� �������ϴ�.

		System.out.println("��(day)������ �����ϸ� " + (diff / (60 * 60 * 24)) + "���Դϴ�.");
	}
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "�� " + (date.get(Calendar.MONTH) + 1)
			+ "�� " + date.get(Calendar.DATE) + "��";
	}
}
