import java.util.*;

class HashSetEx1 {
	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		Set set = new HashSet();
		for (int i = 0 ; i < objArr.length ; i++) {
			set.add(objArr[i]);
			// objArr�迭�� ������ set�� �߰�(��, �ߺ��Ǵ� �����ʹ� �ϳ��� �߰�)
		}
		System.out.println(set);	// [1, 1, 2, 3, 4]

		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");	// 1 1 2 3 4
		}
		// Set�� �ε����� �����Ƿ� for���� ������� �ʰ� Iterator�� �̿��Ͽ� ������ ����
	}
}
