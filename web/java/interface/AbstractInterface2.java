interface PersonalNumberStorage {
	void addPersonalInfo(String name, String pNum);
	String searchName(String pNum);
	// interface���� �����ϴ� ��� �޼ҵ�� �ڵ����� public abstract �� �����
	// interface������ ���� ������ �޼ҵ带 ������ �� ���� ������ public abstract �޼ҵ常 �����ؾ� ��
}

class PersonalNumInfo {
	private String name, number;
	public PersonalNumInfo(String name, String pNum) {
		this.name = name;
		number = pNum;
	}
	String getName() { return name; }
	String getNumber() { return number; }
}

class PersonalNumberStorageImpl implements PersonalNumberStorage {
// interface�� PersonalNumberStorage�� implements�����Ƿ� �ݵ�� PersonalNumberStorage �ȿ� �ִ� 
// �޼ҵ带 ��� �������̵��Ͽ� �ϼ��ؾ� �� - ���ϸ� ���� �߻�
	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	public PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalNumInfo[sz];
		numOfPerInfo = 0;
	}
	public void addPersonalInfo(String name, String pNum) {
	// interface�� �ִ� abstract�޼ҵ带 �������̵��� ������ ������ public���� �����ؾ� ��
		perArr[numOfPerInfo] = new PersonalNumInfo(name, pNum);
		numOfPerInfo++;
	}
	public String searchName(String pNum) {
	// interface�� �ִ� abstract�޼ҵ带 �������̵��� ������ ������ public���� �����ؾ� ��
		for (int i = 0 ; i < numOfPerInfo ; i++) {
			if (pNum.equals(perArr[i].getNumber())) {
				return perArr[i].getName();
			}
		}
		return null;
	}
}

class AbstractInterface2 {
	public static void main(String[] args) {
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);

		storage.addPersonalInfo("ȫ�浿", "950000-1234567");
		storage.addPersonalInfo("����ġ", "970000-1234567");

		System.out.println(storage.searchName("950000-1234567"));
		System.out.println(storage.searchName("970000-1234567"));
	}
}
