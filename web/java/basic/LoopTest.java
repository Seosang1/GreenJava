class LoopTest {
	public static void main(String[] args) {
		// 1~100������ ���� ���Ͽ� ���
		int sum = 0;	// ����ġ�� ������ ����
		for (int i = 1 ; i <= 100 ; i++) {
			sum += i;	// sum = sum + i;
		}
		System.out.println("1~100������ �� : " + sum);

		// 100 ������ ����� �� 2�� 7�� ������� ���� ���
		sum = 0;
		for (int i = 1 ; i <= 100 ; i++) {
			if (i % 2 == 0 && i % 7 == 0) {
				sum += i;
			}
		}
		System.out.println("2�� 7�� ������� �� : " + sum);
	}
}
