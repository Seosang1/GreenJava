class BreakPoint {
	public static void main(String[] args) {
		for (int i = 1 ; i < 4 ; i++) {
			for (int j = 1 ; j < 4 ; j++) {
				System.out.print("[" + i + ", " + j + "]  ");
				if (i % 2 == 0 && j % 2 == 0)	break;
				// 중첩 루프문에서 break를 사용하면 현재 속한 루프문만을 빠져나옴
			}
		}

		System.out.println("-----------------------------------");

		outerLoop:	// 특정 루프문을 표시해주는 레이블(label)
		for (int i = 1 ; i < 4 ; i++) {
			for (int j = 1 ; j < 4 ; j++) {
				System.out.print("[" + i + ", " + j + "]  ");
				if (i % 2 == 0 && j % 2 == 0)	break outerLoop;
				// outerLoop라는 표식을 가진 루프문을 빠져나감
			}
		}
	}
}
