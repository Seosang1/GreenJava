class ArrayEx1 {
	public static void main(String[] args) {
		int[] arrInt = new int[3];	// int�� ������ 3���� ������ �� �ִ� �迭 arrInt�� ���� �� ����
		arrInt[0] = 10;		// arrInt�迭�� 0�� �ε��� ĭ�� 10�� ���� ����
		arrInt[1] = 20;
		arrInt[2] = 30;

		int sum = arrInt[0] + arrInt[1] + arrInt[2];
		System.out.println("sum : " + sum);

		String[] arrStr = new String[3];
		arrStr[0] = "Java";
		arrStr[1] = "JSP";
		arrStr[2] = "Servlet";

		for (int i = 0 ; i < arrStr.length ; i++) {
		// length : �޼ҵ尡 �ƴ� �迭�� ������ �Ӽ�(field)���� �迭�� ũ�⸦ �ǹ�
			System.out.println(arrStr[i]);
		}
	}
}
