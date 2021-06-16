/*
1. ��������� yyyy-mm-dd������ �Է¹޾� Calendar�� �ν��Ͻ��� ������ �� ���
2. Calendar�� �ν��Ͻ��� ������ �̿��Ͽ� LocalDate�� �ν��Ͻ��� ������ �� ���
3. �Է¹��� ������ �������� ���̸� ����Ͽ� ���
*/
import java.util.*;
import java.time.*;
import java.time.temporal.*;

class BirthTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�������(yyyy-mm-dd) : ");
		String birth = sc.nextLine();

		Calendar cDate = Calendar.getInstance();	// Carlendar ��ü�� ����� ���� �ν��Ͻ�
		int cYear = cDate.get(Calendar.YEAR);	// ���̸� ���ϱ� ���� ���� ����
		String[] arrBirth = birth.split("-");	// �Է¹��� ��¥ ���ڿ��� �����Ϸ� �ɰ��� �迭�� ����

		int year = Integer.parseInt(arrBirth[0]);
		int mon = Integer.parseInt(arrBirth[1]) - 1;
		int day = Integer.parseInt(arrBirth[2]);
		// Calendar�� set()�� LocalDate�� of() �޼ҵ忡�� �μ��� ����ϱ� ���� int������ ����ȯ

		cDate.set(year, mon, day);
		// ����ڰ� �Է��� ���� �̿��Ͽ� ���� Calendar �� �ν��Ͻ� ����
		System.out.println(cDate.get(Calendar.YEAR) + "�� " + (cDate.get(Calendar.MONTH) + 1)
			+ "�� " + cDate.get(Calendar.DATE) + "��");

		LocalDate lDate = LocalDate.of(year, mon + 1, day);
		// ����ڰ� �Է��� ���� �̿��Ͽ� ���� LocalDate �� �ν��Ͻ� ����
		System.out.println(lDate);
		System.out.println("���� : " + (cYear - year) + "��");
	}
}
