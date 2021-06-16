abstract class PersonalNumberStorage {
// ���� ���������� ���� ����� ���� Ŭ������ �޼ҵ���� abstract�̹Ƿ� Ŭ������ abstractŬ����
	public abstract void addPersonalInfo(String name, String pNum);
	public abstract String searchName(String pNum);
	// �޼ҵ���� abstract�� ����Ǿ� ��ӹ޴� ����Ŭ�������� �����ϵ��� ��
}

class PersonalNumInfo {
// ���������� �����ϴ� Ŭ������ ��������� Ŭ���� - �� ���� �̸��� ��ȣ�� ����
	private String name, number;
	public PersonalNumInfo(String name, String pNum) {
		this.name = name;
		number = pNum;
	}
	String getName() { return name; }
	String getNumber() { return number; }
	// private���� ����� �������� ������ ���� getter �޼ҵ��
}

class PersonalNumberStorageImpl extends PersonalNumberStorage {
// abstractŬ������ PersonalNumberStorage�� ��ӹ޾����Ƿ� �ݵ�� PersonalNumberStorage �ȿ� �ִ� 
// abstract�޼ҵ带 ��� �������̵��Ͽ� �ϼ��ؾ� �� - ���ҰŸ� �� Ŭ������ abstract�� �����ؾ� ��
	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	public PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalNumInfo[sz];
		// ������� ���������� ���� PersonalNumInfo�� �ν��Ͻ��� ������ �迭�� ����
		numOfPerInfo = 0;
		// perArr�� �ε����� ����ִ� ������ ������ ��Ÿ���� ����
	}
	public void addPersonalInfo(String name, String pNum) {
	// ����Ŭ������ abstract�޼ҵ带 �������̵��� �޼ҵ�
		perArr[numOfPerInfo] = new PersonalNumInfo(name, pNum);
		// �޾ƿ� �̸��� ��ȣ�� �̿��Ͽ� PersonalNumInfo�� �ν��Ͻ��� ������ �� perArr�迭�� ����
		numOfPerInfo++;
	}
	public String searchName(String pNum) {
	// ����Ŭ������ abstract�޼ҵ带 �������̵��� �޼ҵ�
		for (int i = 0 ; i < numOfPerInfo ; i++) {
			if (pNum.equals(perArr[i].getNumber())) {
			// �μ��� �޾ƿ� ��ȣ�� perArr�迭�� i�ε����� �ش��ϴ� �ν��Ͻ��� getNumber()�޼ҵ�� ������ ��ȣ�� ������
				return perArr[i].getName();
				// ������ �ش� �ν��Ͻ����� �̸��� �����Ͽ� �����ϰ� �޼ҵ� ����
			}
		}
		return null;	// ã�� ���� ������ null�� ����
		// null�� ����ִ� ��ü(�ν��Ͻ�)�� �ǹ��ϹǷ� ����Ÿ���� �⺻�ڷ����� �ƴϸ� � ����Ÿ���̶� ����� �� ����
	}
}

class AbstractInterface {
	public static void main(String[] args) {
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);

		storage.addPersonalInfo("ȫ�浿", "950000-1234567");
		storage.addPersonalInfo("����ġ", "970000-1234567");

		System.out.println(storage.searchName("950000-1234567"));
		System.out.println(storage.searchName("970000-1234567"));
	}
}
