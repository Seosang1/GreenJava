class MethodPrimeNumber {
	public static void main(String[] args) {
		/*
		1 ~ 100 ������ ������ �� �Ҽ��� ���Ͽ� ���
		��, ���޵� ���� �Ҽ����� ���θ� �Ǵ��� �ִ� �޼ҵ带 �����Ͽ� �۾�
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
