 
import java.util.*;

class Friend {
	public String name, hnum;
	public int kor, his, math;
	public Friend(String name, String hnum, int kor, int his, int math) {
		this.name = name;		this.hnum = hnum;
		this.kor = kor;			this.his = his;		this.math = math;
	}
	public void showAllData() {
		System.out.println("�й� : " + hnum + " / " + "�̸� : " + name + " / " + "�� ���� ���� : " + "���� : " + kor + " ���� : " + his + " ���� : " + math);
		System.out.println("��� ���� : " + (math + his + kor) / 3);
	}
}


class FriendHandler {
	private ArrayList<Friend> friends;
	public FriendHandler(int num) {
		friends = new ArrayList<Friend>(num);
	}
	public void friendAdd() {
	 String name, hnum;
	 int kor, his, math;

		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");			name = sc.nextLine();
		System.out.print("�й� : ");			hnum = sc.nextLine();
		System.out.print("�������� : ");		kor = sc.nextInt();
		System.out.print("�������� : ");		his = sc.nextInt();
		System.out.print("�������� : ");		math = sc.nextInt();

		System.out.println("�Է¿Ϸ�!!\n");
		friends.add(new Friend(name, hnum, kor, his, math ));
	}
	public void showAllData() {
		for (int i = 0 ; i < friends.size() ; i++) {
			friends.get(i).showAllData();
			System.out.println("��ü ģ�� ����");
		}
	} 
	public void searchData(int num) {
		if (friends.size() == 0) {	
			System.out.println("�˻��� ����� �����ϴ�.");
			return;
		}

		String schHnum;	
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� �й� : ");		schHnum = sc.nextLine();

		boolean isSearch = false;	
			for (int i = 0 ; i < friends.size() ; i++) {
				if (schHnum.equals(friends.get(i).hnum)) {
					friends.get(i).showAllData();
					isSearch = true;
					break;	
				}
			}
			if (!isSearch) {
			System.out.println("ã�� �л��� �����ϴ�.");
			searchData(num);
			}
		}
} 

class StudentInfo {	
	public static void main(String[] args) {
		FriendHandler fh = new FriendHandler(10);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*** �޴� ���� ***");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� �˻�");
			System.out.println("3. ��ü ����");
			System.out.println("4. ����");
			System.out.print("�޴� ���� >> ");

			int num = sc.nextInt();
			switch (num) {
				case 1:
					fh.friendAdd();	break;
				case 2:
					fh.searchData(num);	break;
				case 3:
					fh.showAllData();	break; 
				case 4:
					System.out.println("���α׷� ����");	return;
			}
		}
	}
}
