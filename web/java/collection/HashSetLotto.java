import java.util.*;

class HashSetLotto {
	public static void main(String[] args) {
		// HashSet�� �̿��Ͽ� 1~45������ ���� 6���� �ߺ����� �ʰ� ���� �� ��� - ������ ����
		Set set = new HashSet();
		for (int i = 0 ; set.size() < 6 ; i++) {	// set�� 6���� ���ڰ� ����� ������ ������ ��
			int num = (int)(Math.random() * 45) + 1;
			set.add(new Integer(num));
			// �������� ������ ���ڸ� set�� ����(�ߺ��� ���� ������ ������ �ȵ�)
		}
		System.out.println(set);

		// set�� ����ִ� ���ڵ��� �������� �����Ͽ� ���
		List list = new LinkedList(set);
		// Set�� set�� List�� ��ȯ�Ͽ� list�� ����
		Collections.sort(list);
		// Collections Ŭ������ sort() �޼ҵ�� �Ű������� �ڷ����� List�̹Ƿ� set�� �ٷ� ���� �ʰ� list�� �����Ͽ� ����
		System.out.println(list);
	}
}
