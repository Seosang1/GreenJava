class BreakPoint {
	public static void main(String[] args) {
		for (int i = 1 ; i < 4 ; i++) {
			for (int j = 1 ; j < 4 ; j++) {
				System.out.print("[" + i + ", " + j + "]  ");
				if (i % 2 == 0 && j % 2 == 0)	break;
				// ��ø ���������� break�� ����ϸ� ���� ���� ���������� ��������
			}
		}

		System.out.println("-----------------------------------");

		outerLoop:	// Ư�� �������� ǥ�����ִ� ���̺�(label)
		for (int i = 1 ; i < 4 ; i++) {
			for (int j = 1 ; j < 4 ; j++) {
				System.out.print("[" + i + ", " + j + "]  ");
				if (i % 2 == 0 && j % 2 == 0)	break outerLoop;
				// outerLoop��� ǥ���� ���� �������� ��������
			}
		}
	}
}
