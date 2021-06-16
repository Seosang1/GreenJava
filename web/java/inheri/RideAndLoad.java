class Aa {
	public void testA() { System.out.println("Aa's test"); }	// �Ϲ� �޼ҵ�
	public void rideMethod() { System.out.println("Aa's Method"); }
	public void loadMethod() { System.out.println("void Method"); }
}

class Bb extends Aa {
	public void testB() { System.out.println("Bb's test"); }	// �Ϲ� �޼ҵ�
	public void rideMethod() { System.out.println("Bb's Method"); }		// �������̵�
	public void loadMethod(int n) { System.out.println("int Method"); }			// �����ε�
}

class Cc extends Bb {
	public void testC() { System.out.println("Cc's test"); }	// �Ϲ� �޼ҵ�
	public void rideMethod() { System.out.println("Cc's Method"); }		// �������̵�
	public void loadMethod(double n) { System.out.println("double Method"); }	// �����ε�
}

class RideAndLoad {
	public static void main(String[] args) {
		Aa a = new Cc();	Bb b = new Cc();	Cc c = new Cc();
		// ����Ŭ������ ������ �� ����Ŭ������ �ν��Ͻ��� ����
		// JVM������ ���� �ν��Ͻ��� �ڷ��� ��� ������ �ڷ����� ����ϱ� ������ ����Ŭ������ �޼ҵ�鸸 ��밡��

		/*
		a.testA() : ���డ��
		a.testB() �� a.testC() : ����Ұ���(a�� AaŬ���������� �νĵǱ� ������ AaŬ������ �޼ҵ常 ���డ��)

		b.testA() �� b.testB() : ���డ��
		b.testC() : ����Ұ���(b�� BbŬ���������� �νĵǱ� ������ BbŬ������ �޼ҵ�� Bb�� ����Ŭ������ Aa�� ���డ��)
		*/

		a.rideMethod();		b.rideMethod();		c.rideMethod();
		// Cc's Method		Cc's Method			Cc's Method
		// ����Ŭ������ ������ �� ����Ŭ������ �ν��Ͻ��� ������ �ν��Ͻ��δ� ����Ŭ������ �޼ҵ忡�� ������ �����ϳ�
		// �������̵��� �޼ҵ忡�� ���������� ������Ŭ�������� �������̵��� �޼ҵ尡 �����

		c.loadMethod();		c.loadMethod(1);	c.loadMethod(1.2);
		// void Method		int Method			double Method
		// �����ε��� �޼ҵ���� �Ű������� �ڷ����� ������ �����Ͽ� ȣ��
	}
}
