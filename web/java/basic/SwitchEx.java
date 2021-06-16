class SwitchEx {
	public static void main(String[] args) {
		int score = 88;
		switch (score / 10) {
			case 9 : case 10 :
				System.out.println("A");	break;
			case 8 :
				System.out.println("B");	break;
			case 7 :
				System.out.println("C");	break;
			case 6 :
				System.out.println("D");	break;
			default :
				System.out.println("F");
		}

		switch ("abc") {	// jdk1.7이상에서는 문자열도 사용가능
			case "aaa":
				System.out.println("aaa");	break;
			case "ccc":
				System.out.println("ccc");	break;
			case "abc":
				System.out.println("abc");	break;
		}
	}
}
