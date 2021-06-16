/*
�θ�� : MyFriendInfo2 : ��� �ν��Ͻ� ������ private���� ����
��� : Friend : �̸�, ����, ����, ��ȭ
�б� �θ� : SchoolFriend : �б�, ��������, ����
��ȸ �θ� : SocialFriend : ȸ��, �Ҽ�, ����

1. �б� �θ� �߰�
2. ��ȸ �θ� �߰�
3. ��ü ���� ���
4. �⺻ ���� ��� - �̸�, ����, ����, �б�(ȸ��)
5. �̸� �˻� - �̸��� �޾� ���� �̸��� ��� ���� ��ü�� �����ֱ�
	(�� �� �̻��� ��� ��� �����ֱ�1, ù��°�� ��ġ�ϴ� ����� �����ֱ�2)
6. �̸� �˻�(������ ��ġ�� �˻�)
9. ���α׷� ����
*/
import java.util.*;

class Friend {
	private String name, gender, phone;
	private int age;
	public Friend(String name, String gender, String phone, int age) {
		this.name = name;		this.gender = gender;
		this.phone = phone;		this.age = age;
	}
	public void showAllData() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + gender + " / ���� : " + age);
		System.out.println("��ȭ : " + phone);
	}
	public void showBasicData() {}
	public String getName() { return name; }
	public String getGender() { return gender; }
	public String getPhone() { return phone; }
	public int getAge() { return age; }
}

class SchoolFriend extends Friend {
	private String school, major;
	private int year;
	public SchoolFriend(String n, String g, String p, int a, String s, String m, int y) {
		super(n, g, p , a);
		school = s;		major = m;		year = y;
	}
	public void showAllData() {
		super.showAllData();
		System.out.println("�б� : " + school);
		System.out.println("���� : " + major);
		System.out.println("���� : " + year);
	}
	public void showBasicData() {
		System.out.println("�̸� : " + getName());
		System.out.println("���� : " + getGender() + " / ���� : " + getAge());
		System.out.println("�б� : " + school);
	}
}

class SocialFriend extends Friend {
	private String company, division, position;
	public SocialFriend(String n, String g, String p, int a, String c, String d, String position) {
		super(n, g, p , a);
		company = c;		division = d;		this.position = position;
	}
	public void showAllData() {
		super.showAllData();
		System.out.println("ȸ�� : " + company);
		System.out.println("�Ҽ� : " + division);
		System.out.println("���� : " + position);
	}
	public void showBasicData() {
		System.out.println("�̸� : " + getName());
		System.out.println("ȸ�� : " + company);
		System.out.println("�Ҽ� : " + division);
	}
}

class FriendHandler {
	private ArrayList<Friend> friends;
	// ģ������ �ν��Ͻ��� ������ friends ���� (Friend�� �ν��Ͻ��� ������ �� �ֵ��� ���׸� ����)
	// �÷��� ���� �� ������ ���׸����� �ڷ����� �����ϸ� Object���� �ƴ� ������ �ڷ��� �����ͷ� �ν��ϰ� �Ǿ� ����ȯ�� �ʿ����
	public FriendHandler(int num) {
		friends = new ArrayList<Friend>(num);
	}
	public void friendAdd(int menu) {
		String name, gender, phone, school, major, company, division, position;
		int age, year;

		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");		name = sc.nextLine();
		System.out.print("���� : ");		age = sc.nextInt();
		sc.nextLine();	// nextInt() �ڿ� nextLine()���� �� nextLine()�� �ϳ� ����� ��
		System.out.print("���� : ");		gender = sc.nextLine();
		System.out.print("��ȭ : ");		phone = sc.nextLine();

		if (menu == 1) {
			System.out.print("�б� : ");		school = sc.nextLine();
			System.out.print("���� : ");		major = sc.nextLine();
			System.out.print("���� : ");		year = sc.nextInt();

			friends.add(new SchoolFriend(name, gender, phone, age, school, major, year));
		} else {
			System.out.print("ȸ�� : ");		company = sc.nextLine();
			System.out.print("�Ҽ� : ");		division = sc.nextLine();
			System.out.print("���� : ");		position = sc.nextLine();

			friends.add(new SocialFriend(name, gender, phone, age, company, division, position));
		}
		System.out.println("�Է¿Ϸ�!!\n");
	}
	public void showAllData() {
		for (int i = 0 ; i < friends.size() ; i++) {
			friends.get(i).showAllData();
			System.out.println("��ü ģ�� ����");
		}
	}
	public void showBasicData() {
		for (int i = 0 ; i < friends.size() ; i++) {
			friends.get(i).showBasicData();
			System.out.println("��ü ģ�� ����");
		}
	}
	public void searchData(int num) {
		if (friends.size() == 0) {	// �迭�� ����� ����� �ϳ��� ���� ���
			System.out.println("�˻��� ����� �����ϴ�.");
			return;
		}

		String schName;		// �˻���� ���� �̸��� ������ ����
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� �̸� : ");		schName = sc.nextLine();

		boolean isSearch = false;	// �˻� �������θ� ������ ����
		if (num == 5) {	// ������ �˻�(ù��° ��ġ�ϴ� �̸� ã��)
			for (int i = 0 ; i < friends.size() ; i++) {
				if (schName.equals(friends.get(i).getName())) {
					friends.get(i).showAllData();
					isSearch = true;
					break;	// �̸��� ���� ����� ���� �־ �� �� ������ �� ���
				}
			}
		} else {	// ������ �˻�(������ ��ġ�ϴ� �̸� ã��)
			for (int i = friends.size() - 1 ; i >= 0 ; i--) {
				if (schName.equals(friends.get(i).getName())) {
					friends.get(i).showAllData();
					isSearch = true;
					break;
				}
			}
		}

		if (!isSearch) {
			System.out.println("ã�� �̸��� �����ϴ�.");
			searchData(num);
			// �ڱ��ڽ��� �ٽ� ȣ���ϴ� ���� ���ȣ���̶���
			// ���ȣ�� ���� �ݵ�� �������ü� �ִ� ������ ����ؾ� ��
		}
	}
}

class MyFriendInfo3 {	// collection������ ����
	public static void main(String[] args) {
		FriendHandler fh = new FriendHandler(10);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*** �޴� ���� ***");
			System.out.println("1. �б� ģ�� ����");
			System.out.println("2. ���� ģ�� ����");
			System.out.println("3. ��ü ���� ���");
			System.out.println("4. �⺻ ���� ���");
			System.out.println("5. �̸� �˻�");
			System.out.println("6. �̸� �˻�(������ ��ġ�� �˻�)");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ���� >> ");

			int num = sc.nextInt();
			switch (num) {
				case 1: case 2:
					fh.friendAdd(num);	break;
				case 3:
					fh.showAllData();	break;
				case 4:
					fh.showBasicData();	break;
				case 5: case 6:
					fh.searchData(num);	break;
				case 9:
					System.out.println("���α׷� ����");	return;
			}
		}
	}
}
