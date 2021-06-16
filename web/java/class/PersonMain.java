class PersonInfo {
	private int age;
	private char gender;
	private String name;

	public PersonInfo(int a, char g, String n) {
		age = a;	gender = g;		name = n;
	}

	// ��� ������ ���� �����ϱ� ���� getter
	public int getAge() { return age; }
	public char getGender() { return gender; }
	public String getName() { return name; }

	// ��� ������ ���� �����ϱ� ���� setter
	public void setAge(int a) {
		if (a < 0) {
			System.out.println("���̿� ������ ���� �� �����ϴ�.");
			return;
		}
		age = a;
	}
}

class PersonMain {
	public static void main(String[] args) {
		PersonInfo p1 = new PersonInfo(15, 'f', "�ָ���");
		PersonInfo p2 = new PersonInfo(18, 'm', "����");

		System.out.println("���� : " + p1.getAge() + ", �̸� : " + p1.getName());
		System.out.println("���� : " + p2.getAge() + ", �̸� : " + p2.getName());

		p1.setAge(25);
		p2.setAge(-10);

		System.out.println("���� : " + p1.getAge() + ", �̸� : " + p1.getName());
		System.out.println("���� : " + p2.getAge() + ", �̸� : " + p2.getName());
	}
}
