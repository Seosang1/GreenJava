import java.util.*;

class HashMapEx1 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		// key�� value ��� String �ν��Ͻ��� ����޴� HashMap ����
		map.put("test", "1234");	map.put("abcd", "1111");	map.put("abcd", "1234");
		// HashMap�� ������ ����(������ Ű�� ������ ��� ���߿� �Է��� ������ ������)

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("id�� password�� �Է��ϼ���.");
			System.out.print("id : ");			String id = sc.nextLine().trim();
			System.out.print("password : ");	String pwd = sc.nextLine().trim();
			// trim() : ���ڿ��� �� ���� �ִ� ������ �������ָ�, �⺻������ ����ڰ� �Է��ϴ� ���ڿ����� ����ϴ� ���� ����.
			System.out.println();

			if (!map.containsKey(id)) {
			// map.containsKey(id) : map�� Ű���߿� ������ id�� ������ Ű�� �ִ��� ����
				System.out.println("�������� �ʴ� id�Դϴ�. �ٽ� �Է��ϼ���.");
			} else {
				if (!(map.get(id)).equals(pwd)) {
				// map.get(id) : map���� id ���� Ű�� ����ϴ� ��(value)
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��ϼ���.");
				} else {
					System.out.println("�α��� ����");
					break;
				}
			}
		}
	}
}
