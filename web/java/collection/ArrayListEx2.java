import java.util.*;

class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();

		List list = new ArrayList(length / LIMIT + 10);
		// list�� List������ ����Ǿ��� ������ List�� �޼ҵ�� ArrayList���� �������̵��� �޼ҵ常 ����� �� ����
		// ArrayList�� �������� �ʰ� List�� �����ϴ� ������ List�� ��κ��� �޼ҵ尡 �ְ� �� �޼ҵ带 ArrayList���� 
		// �������̵� �س��� ������ ������� ���ϴ� �޼ҵ尡 ���� ��� ���ɻ��� ������ ����
		// List�� ���� �߱� ������ �ٸ� List��ü(LinkedList)���� ����ȯ�� �����ο�
		// ArrayList �ν��Ͻ� ����(ũ��� �˳��ϰ� ����ִ� ����)

		// list�� source�� ���ڿ��� 10�� �� �߶� ����
		for (int i = 0 ; i < length ; i += LIMIT) {
			if (i + LIMIT < length) {	// ���ڿ��� 10���� �ڸ��°� �����ϸ�
				list.add(source.substring(i, i + LIMIT));
			} else {	// �ڸ� ���ڿ��� 10���ڰ� �ȵǸ�
				list.add(source.substring(i));
			}
		}

		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}
}
