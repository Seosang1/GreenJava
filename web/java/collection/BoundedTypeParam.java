interface SimpleInterface {
	public void showYourName();
}

class UpperClass {
	public void showYourAncestor() {
		System.out.println("UpperClass");
	}
}

class Aa extends UpperClass implements SimpleInterface {
	public void showYourName() { System.out.println("class Aa"); }
}

class Bb extends UpperClass implements SimpleInterface {
	public void showYourName() { System.out.println("class Bb"); }
}

class BoundedTypeParam {
	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();

		showInstanceAncestor(a);	showInstanceName(a);
		showInstanceAncestor(b);	showInstanceName(b);
	}
	public static <T> void showInstanceAncestor(T param) {
		((SimpleInterface)param).showYourName();
		// �������̽��� Ŭ����ó�� ����ȯ�� �����Ͽ� SimpleInterface�� �޼ҵ带 ����
	}
	public static <T> void showInstanceName(T param) {
		((UpperClass)param).showYourAncestor();
		// Object Ŭ������ ���� �޼ҵ������� ����ȯ�� ���� UpperClass�� �޼ҵ带 ���
	}
}
