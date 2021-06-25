 
import java.util.*;

class Friend {
	public String name, hnum;
	public int kor, his, math;
	public Friend(String name, String hnum, int kor, int his, int math) {
		this.name = name;		this.hnum = hnum;
		this.kor = kor;			this.his = his;		this.math = math;
	}
	public void showAllData() {
		System.out.println("학번 : " + hnum + " / " + "이름 : " + name + " / " + "각 과목별 점수 : " + "국어 : " + kor + " 국사 : " + his + " 수학 : " + math);
		System.out.println("평균 점수 : " + (math + his + kor) / 3);
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
		System.out.print("이름 : ");			name = sc.nextLine();
		System.out.print("학번 : ");			hnum = sc.nextLine();
		System.out.print("국어점수 : ");		kor = sc.nextInt();
		System.out.print("국사점수 : ");		his = sc.nextInt();
		System.out.print("수학점수 : ");		math = sc.nextInt();

		System.out.println("입력완료!!\n");
		friends.add(new Friend(name, hnum, kor, his, math ));
	}
	public void showAllData() {
		for (int i = 0 ; i < friends.size() ; i++) {
			friends.get(i).showAllData();
			System.out.println("전체 친구 정보");
		}
	} 
	public void searchData(int num) {
		if (friends.size() == 0) {	
			System.out.println("검색할 대상이 없습니다.");
			return;
		}

		String schHnum;	
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학번 : ");		schHnum = sc.nextLine();

		boolean isSearch = false;	
			for (int i = 0 ; i < friends.size() ; i++) {
				if (schHnum.equals(friends.get(i).hnum)) {
					friends.get(i).showAllData();
					isSearch = true;
					break;	
				}
			}
			if (!isSearch) {
			System.out.println("찾는 학생이 없습니다.");
			searchData(num);
			}
		}
} 

class StudentInfo {	
	public static void main(String[] args) {
		FriendHandler fh = new FriendHandler(10);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 정보 입력");
			System.out.println("2. 정보 검색");
			System.out.println("3. 전체 정보");
			System.out.println("4. 종료");
			System.out.print("메뉴 선택 >> ");

			int num = sc.nextInt();
			switch (num) {
				case 1:
					fh.friendAdd();	break;
				case 2:
					fh.searchData(num);	break;
				case 3:
					fh.showAllData();	break; 
				case 4:
					System.out.println("프로그램 종료");	return;
			}
		}
	}
}
