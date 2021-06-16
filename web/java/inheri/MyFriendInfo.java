import java.util.*;

class Friend {
// 친구들의 기본 정보를 저장할 클래스
	String name, phone, addr;
	// 친구들의 기본정보인 이름, 전화, 주소의 정보를 담을 인스턴스 변수
	public Friend(String name, String phone, String addr) {
	// 받아온 인수들로 인스턴스 변수를 채움
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("주소 : " + addr);
	}
	public void showBasicInfo() {}
	// 하위클래스에서 오버라이딩 하려고 상위클래스에서 인위적으로 만들어 놓은 메소드
}

class HighFriend extends Friend {
	String work;
	public HighFriend(String name, String phone, String addr, String work) {
		super(name, phone, addr);
		this.work = work;
	}
	public void showData() {
	// 인스턴스에 저장된 모든 정보를 보여주는 메소드
		super.showData();
		// 기본 정보를 출력하는 상위클래스의 showData() 메소드 호출
		System.out.println("직업 : " + work);
	}
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
	}
}

class UnivFriend extends Friend {
	String major;
	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}
	public void showData() {
		super.showData();
		System.out.println("전공 : " + major);
	}
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("전공 : " + major);
	}
}

class FriendInfoHandler {
	private Friend[] myFriends;
	// Friend 클래스 형 인스턴스만 저장할 수 있는 배열 myFriends 선언(친구 정보들을 저장할 저장공간)
	private int numOfFriends;
	// myFriends 배열의 인덱스 번호이자 저장된 친구 수를 의미하는 변수

	public FriendInfoHandler(int num) {	// 생성자로서 배열의 크기를 받아와 생성함
		myFriends = new Friend[num];
		// 배열의 크기(10)를 인수로 받아와 myFriends배열 생성 - 10명의 친구 정보를 저장할 수 있음
		numOfFriends = 0;
		// 현재 저장된 친구 수 이자 myFriends배열에 저장할 친구정보를 넣을 인덱스 번호
	}
	private void addFriendInfo(Friend fren) {
	// FriendInfoHandler클래스 내부에서만 사용하므로 private으로 선언함
	// myFriends배열에 추가할 친구정보 인스턴스를 받아 myFriends배열에 추가하는 메소드
	// 매개변수가 Friend형인 이유는 HighFriend와 UnivFriend 모두 받아야 하므로 둘의 상위클래스형으로 선언함
	// 매개변수가 Friend형이 아니면 모든 종류의 친구정보 수 만큼 addFriendInfo() 메소드를 따로 만들어야 함
		myFriends[numOfFriends] = fren;
		// 배열에 받아온 친구정보 추가
		numOfFriends++;
		// 다음 친구정보를 저장할 인덱스 번호를 만듦(현재 저장된 친구 숫자이기도 함)
	}
	public void addFriend(int choice) {
	// 친구정보를 입력받아 저장하는 메소드
		String name, phone, addr, work, major;
		// 친구정보를 받을 변수 선언

		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");		name = sc.nextLine();
		System.out.print("전화 : ");		phone = sc.nextLine();
		System.out.print("주소 : ");		addr = sc.nextLine();
		// 친구의 기본정보로 고교와 대학 모두 가지는 공통정보(상위클래스인 Friend클래스의 인스턴스 변수)

		if (choice == 1) {	// 고교 친구 정보 입력시
			System.out.print("직업 : ");		work = sc.nextLine();
			// 고교 친구 전용 정보를 입력받음
			addFriendInfo(new HighFriend(name, phone, addr, work));
			// 이름없는 HighFriend형 인스턴스 생성한 후 그 인스턴스를 인수로 하여 addFriendInfo() 메소드 호출
		} else {
			System.out.print("전공 : ");		major = sc.nextLine();
			addFriendInfo(new UnivFriend(name, phone, addr, major));
		}
		System.out.println("입력 완료! \n");
	}
	public void showAllData() {
	// myFriends 배열에 저장되어 있는 모든 친구들의 정보를 보여주는 메소드 - showData()메소드 이용
		for (int i = 0 ; i < numOfFriends ; i++) {
		// 0번 부터 배열에 들어있는 자료까지(numOfFriends) 루프를 돔
			myFriends[i].showData();
			// myFriends[i] : myFriends 배열의 i인덱스에 들어있는 Friend형 인스턴스
			// .showData() : 안에 있는 showData() 메소드 호출
			System.out.println();
		}
	}
	public void showBasicData() {
		for (int i = 0 ; i < numOfFriends ; i++) {
			myFriends[i].showBasicInfo();
			// myFriends 배열의 i인덱스에 들어있는 Friend형 인스턴스 안에 있는 showBasicInfo() 메소드 호출
/*	오버로딩이 안될 경우 형변환으로 처리할 수도 있음
			if (myFriends[i] instanceof HighFriend) {
				((HighFriend)myFriends[i]).showBasicInfo();
			} else {
				((UnivFriend)myFriends[i]).showBasicInfo();
			}
*/
			System.out.println();
		}
	}
}

class MyFriendInfo {
	public static void main(String[] args) {
		FriendInfoHandler handler = new FriendInfoHandler(10);
		// FriendInfoHandler 형 인스턴스 handler 를 선언 및 생성

		while (true) {
		// 무한루프를 돌면서 프로그램 대기 상태를 유지
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 고교 친구 저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 기본 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴 선택 >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();	// 프로그램 시작시 동작 후 대기하는 곳
			// 사용자가 입력한 메뉴번호가 choice변수에 저장

			switch (choice) {
				case 1: case 2:
					handler.addFriend(choice);		break;
				case 3:
					handler.showAllData();			break;
				case 4:
					handler.showBasicData();		break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}
	}
}
