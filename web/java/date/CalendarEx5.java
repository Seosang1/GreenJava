import java.util.*;

class CalendarEx5 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("���� : java CalendarEx5 2021 2");
			return;
		}
		int year = Integer.parseInt(args[0]);	// ������ �޷��� ������ int������ ����ȯ
		int month = Integer.parseInt(args[1]);	// ������ �޷��� ���� int������ ����ȯ
		// set() �޼ҵ��� �μ��� ����ϱ� ���� int������ ����ȯ�� ��
		int weekDay = 0;	// 1���� ���Ϲ�ȣ�� ������ ����
		int endDay = 0;		// �ش� ���� ������ ������ ����

		Calendar sdate = Calendar.getInstance();	// �޷��� �������� ������ �ν��Ͻ�
		Calendar edate = Calendar.getInstance();	// �޷��� �������� ������ �ν��Ͻ�

		sdate.set(year, month - 1, 1);	// �޷��� ������ ����
		edate.set(year, month, 1);		// �޷��� �������� ������ �޷��� ������ 1�Ϸ� ����
		edate.add(Calendar.DATE, -1);	// ������ 1�Ͽ��� 1���� �� ��¥�� �������� ����

		weekDay = sdate.get(Calendar.DAY_OF_WEEK);	// �������� ���� ��ȣ�� ������ ���������� ����
		endDay = edate.get(Calendar.DATE);			// ���Ϸ� ������ ���������� ����

		System.out.println("      " + args[0] + "�� " + args[1] + "��");
		System.out.println(" SU MO TU WE TH FR SA");

		for (int i = 1 ; i < weekDay ; i++) System.out.print("   ");
		// 1���� ������ġ�� ���ϱ� ���� for��

		for (int i = 1, n = weekDay ; i <= endDay ; i++, n++) {
		// i : ��¥�� ��(day)�� ǥ���ϱ� ���� ���� / n : �������� ���� �� ���� ���� �ٷ� ������ ���� ����
			System.out.print((i < 10) ? "  " + i : " " + i);	// ��¥ ���
			if (n % 7 == 0) System.out.println();
			// n�� ���� 7�� ����� ��� �������� ���� �ɷ� �Ͽ� ���� �ٷ� ����
		}
	}
}
