class MethodDef2 {
	public static void main(String[] args) {
		double height = 175.3;
		testMethod1(33, height);
		testMethod2(33, 66);
		testMethod3();
	}
	public static void testMethod1(int age, double height) {
		System.out.println("제 나이는 " + age + "세입니다.");
		System.out.println("제 키는 " + height + "cm입니다.");
	}
	public static void testMethod2(int age, int weight) {
		System.out.println("제 나이는 " + age + "세입니다.");
		System.out.println("제 몸무게는 " + weight + "kg입니다.");
	}
	public static void testMethod3() {
		System.out.println("잘가~~~");
	}
}
