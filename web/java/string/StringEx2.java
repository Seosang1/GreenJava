class StringEx2 {
	public static void main(String[] args) {
		String str1 = "test@abc.com";		String str2 = "testabc.com";
		String str3 = "test@abccom";		String str4 = "test.abc@com";

		emailTest(str1);	emailTest(str2);	emailTest(str3);	emailTest(str4);
	}
	public static void emailTest(String str) {	// �����ּҸ� �޾� �˻��� �� ����� ����ϴ� �޼ҵ�
	/* �˻�����
	1. �ݵ�� '@'�� �־�� ��	2. �ݵ�� '.'�� �־�� ��	3. '@'�� '.' ���� �տ� �־�� ��
	�̸����� ������ �̸����ּ� + "�� �̸��� �ּҰ� �½��ϴ�."
	�̸����� Ʋ���� �̸����ּ� + "�� �̸��� �ּҰ� �ƴմϴ�."
	*/
		int at = str.indexOf('@');	// str���� '@'�� ��ġ �ε���
		int dot = str.indexOf('.');	// str���� '.'�� ��ġ �ε���

		if (at == -1 || dot == -1 || at > dot)
			System.out.println(str + "�� �̸��� �ּҰ� �ƴմϴ�.");
		else
			System.out.println(str + "�� �̸��� �ּҰ� �½��ϴ�.");
	}
}
