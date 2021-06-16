/*
밑변과 높이를 저장할 수 있는 Triangle 클래스 제작
 - 인스턴스 생성과 동시에 초기화가 가능한 생성자 정의
 - 밑변과 높이를 변경시키는 메소드와 넓이를 계산해서 리턴하는 메소드 정의
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
		// Triangle 클래스의 인스턴스 생성후 넓이를 출력(밑변 : 20.5, 높이 : 27.6)
		Triangle tri = new Triangle(20.5, 27.6);
		System.out.println("삼각형의 넓이 : " + tri.getArea());

		// 넓이 출력후 밑변과 높이를 변경하여 다시 넓이 출력(밑변 : 7.5, 높이 : 9.2)
		tri.setBottom(7.5);		tri.setHeight(9.2);
		System.out.println("삼각형의 넓이 : " + tri.getArea());
	}
}
