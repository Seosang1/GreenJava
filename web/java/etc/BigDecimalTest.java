import java.math.*;

class BigDecimalTest {
	public static void main(String[] args) {
		double d1 = 1.6;
		double d2 = 0.1;
		System.out.println("두 실수의 덧셈 : " + (d1 + d2));	// 1.7000000000000002
		System.out.println("두 실수의 곱셈 : " + (d1 * d2));	// 0.16000000000000003

		BigDecimal d3 = new BigDecimal(1.6);
		BigDecimal d4 = new BigDecimal(0.1);
		System.out.println("두 실수의 덧셈 : " + d3.add(d4));		// 1.7000000000000000943689...
		System.out.println("두 실수의 곱셈 : " + d3.multiply(d4));	// 0.1600000000000000177635...
		// BigDecimal 인스턴스 생성시 입력하는 실수를 double형으로 입력했으므로 연산시 정확한 연산이 불가

		BigDecimal d5 = new BigDecimal("1.6");
		BigDecimal d6 = new BigDecimal("0.1");
		System.out.println("두 실수의 덧셈 : " + d5.add(d6));		// 1.7
		System.out.println("두 실수의 곱셈 : " + d5.multiply(d6));	// 0.16
		// BigDecimal 인스턴스를 생성할 때에는 문자열로 실수를 표현해야 정확한 연산이 가능
	}
}
