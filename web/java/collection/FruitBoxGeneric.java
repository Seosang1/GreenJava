class Orange {
	int sugar;
	public Orange(int s) { sugar = s; }
	public void showSugar() { System.out.println("�絵 : " + sugar); }
}

class Apple {
	int weight;
	public Apple(int w) { weight = w; }
	public void showWeight() { System.out.println("���� : " + weight); }
}

class FruitBox<T> {
// FruitBox<T> : FruitBoxŬ������ �ν��Ͻ� ������ ���� ������ �� <T>�� �ش��ϴ� Ŭ������ �Է��϶�� �ǹ�
// <T>�� �⺻������ Object�� �ǹ��ϸ� ��� ������ Ŭ������ �־ �� - T��� �� �ڷ����� �����ϴ� ��
	T item;
	public void store(T item) { this.item = item; }
	public T pullOut() { return item; }
}

class FruitBoxGeneric {
	public static void main(String[] args) {
		FruitBox<Orange> box1 = new FruitBox<Orange>();
		// FruitBox<Orange> : FruitBox�� �ν��Ͻ� ������ <T>��ſ� OrangeŬ������ �־� �ݵ�� OrangeŬ������ �ش��ϴ�
		// �����͸� ����ؾ� �Ѵٴ� �������� ����
		box1.store(new Orange(10));
		Orange org = box1.pullOut();
		// box1�ν��Ͻ� ������ Orange�� �����߱� ������ ���� ����ȯ�� ���� �ʾƵ� ����
		org.showSugar();

		FruitBox<Apple> box2 = new FruitBox<Apple>();
		// FruitBox�� �ν��Ͻ� ������ <T>��ſ� AppleŬ������ �־� Apple�ν��Ͻ��� ����ϰڴٴ� �ǹ�
		box2.store(new Apple(20));
		Apple app = box2.pullOut();
		app.showWeight();

		FruitBox box3 = new FruitBox();
		// FruitBox�� �ν��Ͻ� ������ ���׸����� �������� �ʾ����Ƿ� <T>�� Object�� �νĵ�
		box3.store(new Apple(30));
		Apple app2 = (Apple)box3.pullOut();
		app2.showWeight();
	}
}
