class LoopTest {
	public static void main(String[] args) {
		// 1~100까지의 합을 구하여 출력
		int sum = 0;	// 누적치를 저장할 변수
		for (int i = 1 ; i <= 100 ; i++) {
			sum += i;	// sum = sum + i;
		}
		System.out.println("1~100까지의 합 : " + sum);

		// 100 이하의 양수들 중 2와 7의 공배수의 합을 출력
		sum = 0;
		for (int i = 1 ; i <= 100 ; i++) {
			if (i % 2 == 0 && i % 7 == 0) {
				sum += i;
			}
		}
		System.out.println("2와 7의 공배수의 합 : " + sum);
	}
}
