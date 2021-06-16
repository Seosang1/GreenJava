class StrConvert {
	public static void main(String[] args) {
		Integer n1 = new Integer("123");
		Double n2 = new Double("3.14");
		// WrapperŬ������ �̿��ϸ� ���ڿ��� �⺻ �ڷ��� �ν��Ͻ��� ��ȯ�� �� ����
		n1 += 10;	n2 += 1.2;
		System.out.println("n1 : " + n1);	// 133
		System.out.println("n2 : " + n2);	// 4.34

		Integer n3 = Integer.valueOf("123");
		Double n4 = Double.valueOf("3.14");
		// ��� WrapperŬ������ �ִ� valueOf() static �޼ҵ带 �̿��Ͽ� �⺻ �ڷ��� �ν��Ͻ��� ��ȯ
		n3 -= 10;	n4 -= 1.2;
		System.out.println("n3 : " + n3);	// 113
		System.out.println("n4 : " + n4);	// 1.9400000000000002

		int n5 = Integer.parseInt("123");
		double n6 = Double.parseDouble("3.14");
		// ��� WrapperŬ������ �ִ� parse�ڷ���() static �޼ҵ带 �̿��Ͽ� �⺻ �ڷ��� �����ͷ� ��ȯ
		n5 *= 2;	n6 *= 2.0;
		System.out.println("n5 : " + n5);	// 246
		System.out.println("n6 : " + n6);	// 6.28
	}
}
