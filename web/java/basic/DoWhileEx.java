class DoWhileEx {
	public static void main(String[] args) {
		int num = 0;
		while (num < 3) {
			System.out.println("I like Java " + num);	// 0 1 2
			num++;
		}

		System.out.println("-----------------------------");

		do {
			System.out.println("I like Java " + num);	// 3
			// ���� �˻���� �ٷ� �����
			num++;
		} while (num < 3);	// �� �� ������ ������ �˻�
	}
}
