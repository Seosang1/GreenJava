/*
�غ��� ���̸� ������ �� �ִ� Triangle Ŭ���� ����
 - �ν��Ͻ� ������ ���ÿ� �ʱ�ȭ�� ������ ������ ����
 - �غ��� ���̸� �����Ű�� �޼ҵ�� ���̸� ����ؼ� �����ϴ� �޼ҵ� ����
*/
class Triangle {
	private double bottom, height;
	public Triangle(double b, double h) {
		bottom = b;		height = h;
	}
	public void setBottom(double b) { bottom = b; }
	public void setHeight(double h) { height = h; }
	public double getArea() { return bottom * height / 2; }
}

class TriangleMain {
	public static void main(String[] args) {
		// Triangle Ŭ������ �ν��Ͻ� ������ ���̸� ���(�غ� : 20.5, ���� : 27.6)
		Triangle tri = new Triangle(20.5, 27.6);
		System.out.println("�ﰢ���� ���� : " + tri.getArea());

		// ���� ����� �غ��� ���̸� �����Ͽ� �ٽ� ���� ���(�غ� : 7.5, ���� : 9.2)
		tri.setBottom(7.5);		tri.setHeight(9.2);
		System.out.println("�ﰢ���� ���� : " + tri.getArea());
	}
}
