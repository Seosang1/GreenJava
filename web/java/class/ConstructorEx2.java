class NumberTest {
	int num;
	public NumberTest(int n) {	// ������
		num = n;
		System.out.println("���޵� �μ��� �� : " + n);
	}
	public int getNumber() {
		return num;
	}
}

class ConstructorEx2 {
	public static void main(String[] args) {
		NumberTest num1 = new NumberTest(10);	// NumberTest�� �����ڿ� 10�� ����
		System.out.println("�޼ҵ� ��ȯ�� : " + num1.getNumber());

		NumberTest num2 = new NumberTest(20);
		System.out.println("�޼ҵ� ��ȯ�� : " + num2.getNumber());
	}
}
