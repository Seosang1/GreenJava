class InstCnt {
	static int instNum = 0;	// Ŭ���� ����(�ν��Ͻ��� �����ϰ� �޸� �� ���� ����)
	int num = 0;	//�ν��Ͻ� ����(�ν��Ͻ� ���� ����� �� �ν��Ͻ����� �ϳ��� ����)
	public InstCnt() {
		instNum++;
		System.out.println("Ŭ���� ���� : " + instNum);
		num++;
		System.out.println("�ν��Ͻ� ���� : " + num);
	}
}

class ClassVar {
	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
	}
}
