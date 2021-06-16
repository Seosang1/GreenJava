class AutoBoxingUnboxing {
	public static void main(String[] args) {
		Integer iValue = 10;
		Double dValue = 3.14;

		System.out.println("iValue : " + iValue);	// 10
		System.out.println("dValue : " + dValue);	// 3.14

		int n1 = iValue + 10;
		double n2 = dValue + 1.2;

		System.out.println("n1 : " + n1);	// 20
		System.out.println("n2 : " + n2);	// 4.34
	}
}
