class Student {
	private int stdID, korean, math, art, by, bm, bd;

	public Student(int s, int k, int m, int a, int by, int bm, int bd) {
		stdID = s;		korean = k;		math = m;		art = a;
		this.by = by;	this.bm = bm;	this.bd = bd;
		// ��������� �Ű������� �̸��� ���� �� this�� ����Ͽ� ��������� ������ ��
	}
	public Student(int s, int k, int m, int by, int bm, int bd) {
		this(s, k, m, 0, by, bm, bd);
		// �Ű������� ������ ���� �� �� ���� �μ��� �Ͽ� �ٸ� �����ڸ� ȣ��
	}
	public void showInfo() {
		System.out.println("�й� : " + stdID);
		System.out.println("���� : " + by + "/" + bm + "/" + bd);
		System.out.println("���� : " + korean);
		System.out.println("���� : " + math);
		if (art == 0) {
			System.out.println("�̼� ���� �ȵ�� �л�");
		} else {
			System.out.println("�̼� : " + art);
		}
	}
}

class Overloading {
	public static void main(String[] args) {
		Student std1 = new Student(2012003, 98, 78, 88, 1998, 5, 6);
		Student std2 = new Student(2012010, 85, 68, 1995, 3, 4);
		std1.showInfo();
		std2.showInfo();
	}
}
