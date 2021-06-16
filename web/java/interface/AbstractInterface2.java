interface PersonalNumberStorage {
	void addPersonalInfo(String name, String pNum);
	String searchName(String pNum);
	// interface에서 선언하는 모드 메소드는 자동으로 public abstract 로 선언됨
	// interface에서는 절대 구현된 메소드를 정의할 수 없고 무조건 public abstract 메소드만 선언해야 함
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
// interface인 PersonalNumberStorage를 implements했으므로 반드시 PersonalNumberStorage 안에 있는 
// 메소드를 모두 오버라이딩하여 완성해야 함 - 안하면 오류 발생
	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	public PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalNumInfo[sz];
		numOfPerInfo = 0;
	}
	public void addPersonalInfo(String name, String pNum) {
	// interface에 있는 abstract메소드를 오버라이딩한 것으로 무조건 public으로 지정해야 함
		perArr[numOfPerInfo] = new PersonalNumInfo(name, pNum);
		numOfPerInfo++;
	}
	public String searchName(String pNum) {
	// interface에 있는 abstract메소드를 오버라이딩한 것으로 무조건 public으로 지정해야 함
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

		storage.addPersonalInfo("홍길동", "950000-1234567");
		storage.addPersonalInfo("전우치", "970000-1234567");

		System.out.println(storage.searchName("950000-1234567"));
		System.out.println(storage.searchName("970000-1234567"));
	}
}
