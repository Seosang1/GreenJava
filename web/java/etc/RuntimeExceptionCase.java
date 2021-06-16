class RuntimeExceptionCase {
	public static void main(String[] args) {
		try {
			int[] arr = new int[2];
			arr[-1] = 20;
		} catch (ArrayIndexOutOfBoundsException e) {
		// ����Ϸ��� �ε�����ȣ�� �迭�� �ε��� ������ ����� �� �߻��ϴ� ����
			System.out.println(e.getMessage());
		}
		try {
			Object obj = new int[10];
			String str = (String)obj;
		} catch (ClassCastException e) {
		// �Ұ����� ����ȯ�� ����� �߻��ϴ� ����
			System.out.println(e.getMessage());
		}
		try {
			int[] arr = new int[-10];
		} catch (NegativeArraySizeException e) {
		// �迭�� ũ�⸦ ������ �������� �� �߻��ϴ� ����
			System.out.println(e.getMessage());
		}
		try {
			String str = null;
			int len = str.length();
		} catch (NullPointerException e) {
		// ����ִ� ��ü�� ����Ϸ� ���� �� �߻��ϴ� ����
			System.out.println(e.getMessage());
		}
	}
}
