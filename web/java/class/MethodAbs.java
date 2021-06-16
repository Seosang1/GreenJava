class MethodAbs {
	public static void main(String[] args) {
		// 두 개의 정수를 전달받아 두 수의 차를 절대값으로 출력해주는 메소드 작성
		printAbs(10, 5);	// 10과 5의 차는 5
		printAbs(10, 25);	// 10과 25의 차는 15
	}
	public static void printAbs(int n1, int n2) {
		int def = 0;	// 두 수의 차를 저장할 변수

		if (n1 > n2)	def = n1 - n2;
		else			def = n2 - n1;

		def = n1 - n2;
		if (def < 0)	def = n2 - n1;
		if (def < 0)	def *= -1;

		def = (n1 > n2) ? n1 - n2 : n2 - n1;

		System.out.println(n1 + "과 " + n2 + "의 차는 " + def);
	}
}
