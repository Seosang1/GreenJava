class MethodAbs {
	public static void main(String[] args) {
		// �� ���� ������ ���޹޾� �� ���� ���� ���밪���� ������ִ� �޼ҵ� �ۼ�
		printAbs(10, 5);	// 10�� 5�� ���� 5
		printAbs(10, 25);	// 10�� 25�� ���� 15
	}
	public static void printAbs(int n1, int n2) {
		int def = 0;	// �� ���� ���� ������ ����

		if (n1 > n2)	def = n1 - n2;
		else			def = n2 - n1;

		def = n1 - n2;
		if (def < 0)	def = n2 - n1;
		if (def < 0)	def *= -1;

		def = (n1 > n2) ? n1 - n2 : n2 - n1;

		System.out.println(n1 + "�� " + n2 + "�� ���� " + def);
	}
}
