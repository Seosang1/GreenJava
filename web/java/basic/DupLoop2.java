class DupLoop2 {
	public static void main(String[] args) {
		/*
		2 X 1 = 2		3 X 1 = 3	...		9 X 1 = 9
		2 X 2 = 4		3 X 2 = 6	...		9 X 2 = 18
		...				...			...		...
		2 X 9 = 18		3 X 9 = 27	...		9 X 9 = 81
		�״�� ������ �� : ���� �Է��ϴ� �κ� : " X " + " = "
		������ ������ �� : 2~9�� ��, 1~9�� ���� ��
		������� ������ �� : ���ϱ��� ���
		*/
		for (int i = 1 ; i < 10 ; i++) {
			for (int j = 2 ; j < 10 ; j++) {
				System.out.print(j + " X " + i + " = " + (i * j) + ((i * j < 10) ? "    " : "   "));
			}
			System.out.println();
		}
	}
}
