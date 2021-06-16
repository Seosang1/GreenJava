class InstCnt {
	static int instNum = 0;	// 클래스 변수(인스턴스와 무관하게 메모리 상에 따로 존재)
	int num = 0;	//인스턴스 변수(인스턴스 내의 멤버로 각 인스턴스별로 하나씩 존재)
	public InstCnt() {
		instNum++;
		System.out.println("클래스 변수 : " + instNum);
		num++;
		System.out.println("인스턴스 변수 : " + num);
	}
}

class ClassVar {
	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
	}
}
