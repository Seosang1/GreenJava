import java.util.*;

class AgeInputException extends Exception {
	public AgeInputException() {
		super ("유효하지 않은 나이가 입력되었습니다.");
	}
}

class ExceptionDefine2 {
	public static void main(String[] args) throws AgeInputException {
	// throws AgeInputException : 현 메소드(main)에서 AgeInputException 예외가 발생해도 처리하지 않겠단 의미로
	// 예외처리를 현 메소드를 호출한 곳(JVM)으로 넘기는 명령 
		System.out.print("나이 입력 : "); 
		int age = readAge();
		System.out.println("당신은 " + age + "세 입니다."); 
	}
	public static int readAge() throws AgeInputException {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age < 0) {
			AgeInputException excpt = new AgeInputException();
			throw excpt;
		}
		return age;
	}
}
