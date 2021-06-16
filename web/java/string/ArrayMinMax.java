import java.util.*;

class ArrayMinMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arrInt = new int[5];
		for (int i = 0 ; i < arrInt.length ; i++) {
			System.out.print("���� �Է� : ");
			arrInt[i] = sc.nextInt();
			// Scanner�� ���� �Է¹��� ������ arrInt�迭�� ����
			// ���ڿ��� nextLine()���� ����
		}

		System.out.println("�ּҰ� : " + minValue(arrInt));
		System.out.println("�ִ밪 : " + maxValue(arrInt));
	}
	public static int minValue(int[] arr) {	// �޾� �� �迭 arr���� �ּҰ��� ���Ͽ� �����ϴ� �޼ҵ�
		int min = arr[0];
		for (int i = 1 ; i < arr.length ; i++) {
			if (min > arr[i])	min = arr[i];
		}
		return min;
	}
	public static int maxValue(int[] arr) {	// �޾� �� �迭 arr���� �ִ밪�� ���Ͽ� �����ϴ� �޼ҵ�
		int max = arr[0];
		for (int i = 1 ; i < arr.length ; i++) {
			if (max < arr[i])	max = arr[i];
		}
		return max;
	}
}
