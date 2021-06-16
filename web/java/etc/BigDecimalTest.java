import java.math.*;

class BigDecimalTest {
	public static void main(String[] args) {
		double d1 = 1.6;
		double d2 = 0.1;
		System.out.println("�� �Ǽ��� ���� : " + (d1 + d2));	// 1.7000000000000002
		System.out.println("�� �Ǽ��� ���� : " + (d1 * d2));	// 0.16000000000000003

		BigDecimal d3 = new BigDecimal(1.6);
		BigDecimal d4 = new BigDecimal(0.1);
		System.out.println("�� �Ǽ��� ���� : " + d3.add(d4));		// 1.7000000000000000943689...
		System.out.println("�� �Ǽ��� ���� : " + d3.multiply(d4));	// 0.1600000000000000177635...
		// BigDecimal �ν��Ͻ� ������ �Է��ϴ� �Ǽ��� double������ �Է������Ƿ� ����� ��Ȯ�� ������ �Ұ�

		BigDecimal d5 = new BigDecimal("1.6");
		BigDecimal d6 = new BigDecimal("0.1");
		System.out.println("�� �Ǽ��� ���� : " + d5.add(d6));		// 1.7
		System.out.println("�� �Ǽ��� ���� : " + d5.multiply(d6));	// 0.16
		// BigDecimal �ν��Ͻ��� ������ ������ ���ڿ��� �Ǽ��� ǥ���ؾ� ��Ȯ�� ������ ����
	}
}
