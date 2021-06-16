class Adder {
	public static int val = 0;
	public void add(int num) { val += num; }
}

class AddFriend extends Adder {
	public void friendAdd(int num) { val += num; }
	public void showVal() { System.out.println(val); }
}

class StaticInheritance {
	public static void main(String[] args) {
		Adder ad = new Adder();
		AddFriend af = new AddFriend();
		ad.add(1);
		af.friendAdd(3);
		AddFriend.val += 5;
		// static�� ����� �Ǿ� ����Ŭ�������� ����Ŭ������ static����� �����Ӱ� ���� ����
		af.showVal();	// 9
	}
}
