class NumberPrinter {
	public static void showInt(int n) { System.out.println(n); }
	public static void showDouble(double n) { System.out.println(n); }
	// 클래스 멤버 중 클래스 메소드로 'static'키워드를 붙여서 사용
}

class ClassMethod {
	public static void main(String[] args) {
		NumberPrinter.showInt(20);
		// 인스턴스 생성 전에 클래스 이름으로 static메소드인 showInt() 메소드
		NumberPrinter np = new NumberPrinter();
		np.showDouble(3.14);
		// 클래스 멤버는 인스턴스를 통해서도 접근할 수 있음
	}
}
