class NumberTest {
	int num;
	public NumberTest() {	// ������
		num = 10;
		System.out.println("������ ȣ��!!");
	}
	/*
	public NumberTest() { }
	// ����Ʈ ������ : �����ڰ� ���� �� JVM�� �ڵ����� ������ִ� �����ڷ� �ν��Ͻ� ���� �۾��� ó��
	*/
	public int getNumber() {
		return num;
	}
}

class ConstructorEx1 {
	public static void main(String[] args) {
		NumberTest num1 = new NumberTest();
		// NumberTest �� �ν��Ͻ� num1�� ���� �� ����(������ ȣ��)
		System.out.println(num1.getNumber());

		NumberTest num2 = new NumberTest();
		System.out.println(num2.getNumber());
	}
}
