class StringEx3 {
	public static void main(String[] args) {
		String str1 = "880525-1234567";		String str2 = "890515-2234567";
		String str3 = "0805253234567";		String str4 = "0905154234567";

		showBirth(str1);	showGender(str1);	showBirth(str2);	showGender(str2);
		showBirth(str3);	showGender(str3);	showBirth(str4);	showGender(str4);
	}
	public static void showBirth(String str) {
	// �ֹε�Ϲ�ȣ�� �̿��Ͽ� ��������� ����ϴ� �޼ҵ�
	/* �ֹε�Ϲ�ȣ�� �� 6�ڸ��� �̿��Ͽ� "yyyy�� mm�� dd�� ��"���� ��� */
		int i = 6;
		if (str.length() == 14)		i = 7;
		char g = str.charAt(i);

		String year = (g <= '2' ? "19" : "20") + str.substring(0, 2);
		String month = str.substring(2, 4);
		String day = str.substring(4, 6);
		System.out.println(year + "�� " + month + "�� " + day + "�� ��");
	}
	public static void showGender(String str) {
	// �ֹε�Ϲ�ȣ�� �̿��Ͽ� ������ ����ϴ� �޼ҵ�
	/* �ֹε�Ϲ�ȣ�� �̿��Ͽ� "����" �Ǵ� "����"�� ��� */
		int i = 6;	// ������������ ��ġ �ε����� ������ ����
		if (str.indexOf('-') >= 0)	i = 7;
		char g = str.charAt(i);

		if (g % 2 == 1)	System.out.println("����");
		else			System.out.println("����");
	}
}
