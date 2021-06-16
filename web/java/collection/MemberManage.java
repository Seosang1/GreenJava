/* ȸ�� ���� ���� - MemberManage.java
ȸ������(���̵�, ��ȣ, �̸�)�� ������ Ŭ���� - MemberInfo
������ �Է¹ް�, ���� ó�� �� ���� ����� ����� Ŭ���� - MemberHandler
�޴�
1. ȸ�� ��� - ȸ�� ������ �Է¹޾� ArrayList�� ����(���׸� ���, ���̵� �ߺ�üũ)
2. ��ü ȸ������ ����
3. ȸ�� �˻� - ���̵�� �˻��Ͽ� ���� ������
4. �α��� - ���̵�� ��ȣ�� �Է¹޾� �α��� ó��(���� : �α��� �Ǿ����ϴ� / ���� : �α��ο� �����߽��ϴ� �� �ٽ� �α��� �õ�)
5. ���α׷� ����
*/
import java.util.*;

class MemberInfo {	// ȸ������ ����� Ŭ����
	private String id, pwd, name;
	public MemberInfo(String id, String pwd, String name) {
	// MemberInfoŬ������ �����ڷ� �ν��Ͻ� ������ ȸ�������� �޾ƿ�
		this.id = id;	this.pwd = pwd;		this.name = name;
	}
	public void setPwd(String pwd) { this.pwd = pwd; }	// ��ȣ ����� �޼ҵ�
	public String getId() { return id; }		// id�� �޾ƿ��� �޼ҵ�
	public String getPwd() { return pwd; }		// pwd�� �޾ƿ��� �޼ҵ�
	public String getName() { return name; }	// name�� �޾ƿ��� �޼ҵ�
	public void showInfo() {
		System.out.println("���̵� : " + id);
		System.out.println("��й�ȣ : " + pwd);
		System.out.println("�̸� : " + name);
	}
}

class MemberHandler {	// ȸ������(MemberInfo Ŭ������ �ν��Ͻ�)�� �Է¹ް� ó���ϴ� Ŭ����
	private ArrayList<MemberInfo> members;	// MemberInfo �� �ν��Ͻ��� �����ϴ� ȸ������ ����� ArrayList
	// ���׸����� MemberInfo ���� ���������Ƿ� members���� ��ü�� ������ �� MemberInfo ������ ����ȯ�� ���� �ʾƵ� ��

	public MemberHandler() {
		members = new ArrayList<MemberInfo>();
	}

	// ȸ�������� ����ڿ��� �޾� �����ϴ� �޼ҵ�
	public void saveMember() {
		String id, pwd, name;
		Scanner sc = new Scanner(System.in);

		System.out.print("���̵� : ");	id = sc.nextLine();
		if (isDupID(id)) {
			System.out.println("�̹� ������� ���̵� �Դϴ�.");
			saveMember();
		}

		System.out.print("��й�ȣ : ");	pwd = sc.nextLine();
		System.out.print("�̸� : ");		name = sc.nextLine();

		members.add(new MemberInfo(id, pwd, name));
		System.out.println("ȸ�� ������ �����մϴ�.\n");
	}

	// �˻�� �޾� ȸ�������� �˻��ϴ� �޼ҵ�
	public void searchMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� ���̵� : ");	String schId = sc.nextLine();

		for (int i = 0 ; i < members.size() ; i++) {
			if (members.get(i).getId().indexOf(schId) != -1) {
			// members.get(i).getId() : ArrayList �� members ���� i �ε����� �ش��ϴ� MemberInfo �� �ν��Ͻ��� 
			// getId() �޼ҵ带 �����϶� - �ش� �ν��Ͻ��� ���� id ������ String���� ����
			// members.get(i).getId() ���� �޾ƿ� ���̵� �ȿ� ����ڰ� �Է��� �˻�� ��� ������
				members.get(i).showInfo();
				// �ش� ȸ�������� showInfo() �޼ҵ带 ���� ������
			}
		}
	}

	// ���̵�� ��ȣ�� �޾� �α����� �ϴ� �޼ҵ�
	public void loginMember() {
		String id, pwd;
		Scanner sc = new Scanner(System.in);

		System.out.print("���̵� : ");	id = sc.nextLine();
		System.out.print("��й�ȣ : ");	pwd = sc.nextLine();

		boolean isLogin = false;
		for (int i = 0 ; i < members.size() ; i++) {
			if (members.get(i).getId().equals(id) && members.get(i).getPwd().equals(pwd)) {
				isLogin = true;
				break;
			}
		}

		if (isLogin)	System.out.println("�α��� �Ǿ����ϴ�.\n");
		else {
			System.out.println("�α��ο� �����߽��ϴ�.\n");
			loginMember();
		}
	}

	// ���̵� �ߺ� üũ�ϴ� �޼ҵ�
	public boolean isDupID(String id) {
		for (int i = 0 ; i < members.size() ; i++) {
			if (members.get(i).getId().equals(id)) {
				return true;
			}
		}

		return false;
	}

	// ȸ�������� �����ִ� �޼ҵ�
	public void showAllInfo() {
		for (int i = 0 ; i < members.size() ; i++) {
			members.get(i).showInfo();
		}
	}
}

class MemberManage {
	public static void main(String[] args) {
		MemberHandler handler = new MemberHandler();

		while (true) {
			System.out.println("*** �޴� ���� ***");
			System.out.println("1. ȸ�� ���");
			System.out.println("2. ��ü ȸ������ ����");
			System.out.println("3. ȸ�� �˻�");
			System.out.println("4. �α���");
			System.out.println("5. ���α׷� ����");
			System.out.print("�޴� ���� >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					handler.saveMember();		break;
				case 2:
					handler.showAllInfo();		break;
				case 3:
					handler.searchMember();		break;
				case 4:
					handler.loginMember();		break;
				case 5:
					System.out.println("���α׷��� �����մϴ�.");
					return;
			}
		}
	}
}
