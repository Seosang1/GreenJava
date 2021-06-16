import java.util.*;

class AgeInputException extends Exception {
// ExceptionŬ������ ��ӹ޾����Ƿ� AgeInputExceptionŬ������ ����Ŭ������ ��
// �����Է½� ��ȿ���� ���� ���� ������ ��� �߻���ų ����Ŭ����
	public AgeInputException() {
		super("��ȿ���� ���� ���̰� �ԷµǾ����ϴ�.");
		// ����Ŭ������ ExceptionŬ������ �����ڸ� ȣ���ϸ鼭 ���� �߻��� ������ �޽����� �μ��� ������
	}
}

class ExceptionDefine {
	public static void main(String[] args) {
		System.out.print("���� �Է� : ");

		try {
			int age = readAge();
			System.out.println("����� " + age + "�� �Դϴ�.");
		} catch (AgeInputException e) {
			System.out.println(e.getMessage());
		}
	}
	public static int readAge() throws AgeInputException {
	// throws AgeInputException : �� �޼ҵ忡�� AgeInputException ���ܰ� �߻��ص� ó������ �ʰڴٴ� �ǹ̷�
	// ����ó���� �� �޼ҵ带 ȣ���� ������ �ѱ�� ��� - ����ó���� try-catch������ �ؾ� ��
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age < 0) {
			AgeInputException excpt = new AgeInputException();
			// AgeInputException �� �ν��Ͻ� excpt�� �����ϴ� ������ AgeInputException ���ܸ� ���� - ���ܹ߻��ƴ�
			throw excpt;
			// excpt�� ����ִ� AgeInputException ���ܸ� �߻��ߴٰ� JVM�� �˸��� ����
			// throw excpt �� ����Ǹ� JVM�� ����ó�� ��ī������ �����ϰ� ��
		}
		return age;
	}
}
