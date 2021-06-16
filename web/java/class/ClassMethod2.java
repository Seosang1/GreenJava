class SimpleMath {
	public static final double PI = 3.141592;
	public static double add(double d1, double d2) { return d1 + d2; }
	public static double min(double d1, double d2) { return d1 - d2; }
	public static double mul(double d1, double d2) { return d1 * d2; }
}

class AreaMath {
	public static double calCircleArea(double rad) {
		double result = SimpleMath.mul(rad, rad);
		result = SimpleMath.mul(result, SimpleMath.PI);
		// SimpleMath.PI : SimpleMath 클래스 내에 있는 PI라는 static변수
		return result;
	}
	public static double calRectangleArea(double width, double height) {
		return SimpleMath.mul(width, height);
	}
}

class PeriMath {
	public static double calCirclePeri(double rad) {
		double result = SimpleMath.mul(rad, 2);
		result = SimpleMath.mul(result, SimpleMath.PI);
		return result;
	}
	public static double calRectanglePeri(double width, double height) {
		return SimpleMath.add(SimpleMath.mul(width, 2), SimpleMath.mul(height, 2));
	}
}

class ClassMethod2 {
	public static void main(String[] args) {
		System.out.println("원의 넓이 : " + AreaMath.calCircleArea(2.4));
		System.out.println("직사각형의 둘레 : " + PeriMath.calRectanglePeri(2.0, 4.0));
	}
}
