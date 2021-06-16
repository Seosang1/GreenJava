class BoxingUnboxing {
	public static void main(String[] args) {
		Integer iValue = new Integer(10);
		Double dValue = new Double(3.14);

		System.out.println("iValue : " + iValue);	// 10
		System.out.println("dValue : " + dValue);	// 3.14

		iValue = new Integer(iValue.intValue() + 10);
		dValue = new Double(dValue.doubleValue() + 1.2);

		System.out.println("iValue : " + iValue);	// 20
		System.out.println("dValue : " + dValue);	// 4.34
	}
}
