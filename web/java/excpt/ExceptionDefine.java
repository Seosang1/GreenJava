import java.util.*;

class AgeInputException extends Exception {
// Exception 클래스를 상속받았으므로 AgeInputException 클래스는 예외클래스가 됨.
// 나이입력시 유효하지 않은 값이 들어왔을 경우 발생시킬 예외클래스
	public AgeInputException() {
		super ("유효하지 않은 나이가 입력되었습니다.");
		// 상위클래스인 Exception 클래스의 생성자를 호출하면서 예외 발생시 보여줄 메시지를 인수로 가져감
	}
}

class ExceptionDefine {
	public static void main(String[] args) {
		System.out.print("나이 입력 : ");
	
		try	{
			int age = readAge();
			System.out.println("당신은 " + age + "세 입니다.");
		}catch (AgeInputException e){
			System.out.println(e.getMessage());
		}
	}
	public static int readAge() throws AgeInputException {
	// throws AgeInputException : 현 메소드에서 AgeInputException 예외가 발생해도 처리하지 않겠단 의미로
	// 예외처리를 현 메소드를 호출한 곳으로 넘기는 명령 - 예외처리는 try-catch문으로 해야함
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age < 0) {
			AgeInputException excpt = new AgeInputException();
			// AgeInputException형 인스턴스 excpt를 생성하는 것이자 AgeInputException 예외를 생성 - 예외발생아님 
			throw excpt;
			// excpt에 들어있는 AgeInputException 예외를 발생했다고 JVM에 알리는 역할
			// throw excpt가 실행되면 JVM의 예외처리 매커니즘이 동작하게 됨
		}
		return age;
	}
}
