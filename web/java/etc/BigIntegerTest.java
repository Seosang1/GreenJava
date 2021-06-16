import java.math.*;

class BigIntegerTest {
	public static void main(String[] args) {
		System.out.println("�⺻ �ڷ��� �ִ� ���� : " + Long.MAX_VALUE);	// 9223372036854775807
		System.out.println("�⺻ �ڷ��� �ּ� ���� : " + Long.MIN_VALUE);	// -9223372036854775808

		BigInteger bigValue1 = new BigInteger("100000000000000000000");
		BigInteger bigValue2 = new BigInteger("-99999999999999999999");

		BigInteger addResult = bigValue1.add(bigValue2);
		BigInteger mulResult = bigValue1.multiply(bigValue2);

		System.out.println("BigInteger�� ���� : " + addResult);	// 1
		System.out.println("BigInteger�� ���� : " + mulResult);
		// -9999999999999999999900000000000000000000
	}
}
