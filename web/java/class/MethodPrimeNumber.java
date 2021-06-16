class MethodPrimeNumber {
	public static void main(String[] args) {
		/*
		1 ~ 100 사이의 정수들 중 소수를 구하여 출력
		단, 전달된 값이 소수인지 여부를 판단해 주는 메소드를 제작하여 작업
		*/
		for (int i = 1 ; i <= 100 ; i++) {
			if (isPrime(i))	System.out.println(i);
		}
	}
	public static boolean isPrime(int n) {
		if (n == 1 || (n != 2 && n % 2 == 0)) {
			return false;
		}
		for (int i = 2 ; i < n ; i++) {
			if (n % i == 0)	return false;
		}

		return true;
	}
}
