/* ����ڿ��� �ּ������� �ִ������� �޾� �� ������ ������ 10�� ��� - �ּҰ��� �ִ밪�� ���ԵǾ�� �� */
import java.util.*;

class RandomBetween {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ּҰ� �Է� : ");		int num1 = sc.nextInt();
		System.out.print("�ִ밪 �Է� : ");		int num2 = sc.nextInt();

		Random rnd = new Random();
		for (int i = 0 ; i < 10 ; i++) {
			int val = rnd.nextInt(num2 - num1 + 1);
			val += num1;
			System.out.print(val + " ");
		}
	}
}
