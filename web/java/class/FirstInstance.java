class NumberEx {
	int num = 0;	// ��������� NumberExŬ���������� �����Ӱ� ��밡��
	public void addNum(int n) {
		num += n;
	}
	public int getNum() {
		return num;
	}
}

class FirstInstance {
	public static void main(String[] args) {
		NumberEx num = new NumberEx();
		// NumberEx num : NumberEx �� �ν��Ͻ� num�� ����
		// new NumberEx() : �����ߴ� �ν��Ͻ� num�� �޸𸮻󿡼� ����
		System.out.println("�޼ҵ� ȣ�� �� : " + num.getNum());		// 0
		// num.getNum() : num �ν��Ͻ� ���� getNum() �޼ҵ带 ȣ��

		numMethod(num);	// �ν��Ͻ��� �Ű������� ������ �� ����
		// numMethod() �޼ҵ带 ȣ���ϸ鼭 �ν��Ͻ� num�� �μ��� ������
		// �μ��� �ν��Ͻ��� ������ ��� �ν��Ͻ� ��ü�� ������
		System.out.println("�޼ҵ� ȣ�� �� : " + num.getNum());		// 12

		int test = 0;
		numMethod2(test);
		// numMethod2() �޼ҵ带 ȣ���ϸ鼭 ���� test�� �μ��� ������
		// �μ��� ������ ������ ��� ������ ������ ������
		System.out.println("test : " + test);	// 0
	}
	public static void numMethod(NumberEx n) {
		n.addNum(12);
		// �μ��� �޾ƿ� �ν��Ͻ� n ���� addNum(12) �޼ҵ带 ȣ��
	}
	public static void numMethod2(int n) {
		n += 12;
	}
}
