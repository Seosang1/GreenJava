class DoWhileEx {
	public static void main(String[] args) {
		int num = 0;
		while (num < 3) {
			System.out.println("I like Java " + num);	// 0 1 2
			num++;
		}

		System.out.println("-----------------------------");

		do {
			System.out.println("I like Java " + num);	// 3
			// 조건 검사없이 바로 실행됨
			num++;
		} while (num < 3);	// 한 번 실행후 조건을 검사
	}
}
