class NumberPrinter {
	public static void showInt(int n) { System.out.println(n); }
	public static void showDouble(double n) { System.out.println(n); }
	// Ŭ���� ��� �� Ŭ���� �޼ҵ�� 'static'Ű���带 �ٿ��� ���
}

class ClassMethod {
	public static void main(String[] args) {
		NumberPrinter.showInt(20);
		// �ν��Ͻ� ���� ���� Ŭ���� �̸����� static�޼ҵ��� showInt() �޼ҵ�
		NumberPrinter np = new NumberPrinter();
		np.showDouble(3.14);
		// Ŭ���� ����� �ν��Ͻ��� ���ؼ��� ������ �� ����
	}
}
