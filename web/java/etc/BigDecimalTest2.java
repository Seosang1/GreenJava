/*
�� ���� �Ǽ��� �Է¹޾� �� �Ǽ��� ���� ���밪���� ����Ͽ� ��� : ��, ������ �����ϸ� �ȵ�
*/
import java.util.*;
import java.math.*;

class BigDecimalTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�Ǽ�1 �Է� : ");		String num1 = sc.nextLine();
		System.out.print("�Ǽ�2 �Է� : ");		String num2 = sc.nextLine();

		BigDecimal n1 = new BigDecimal(num1);
		BigDecimal n2 = new BigDecimal(num2);

		BigDecimal result = n1.subtract(n2);
		System.out.println("�� �Ǽ��� �� : " + result.abs());
	}
}
