class FinallyTest {
	public static void main(String[] args) { 
		boolean divOK = divider(4, 2);
		if (divOK)	System.out.println("���� ����");
		else		System.out.println("���� ����");	

		divOK = divider(4, 0);
		if (divOK)	System.out.println("���� ����");
		else		System.out.println("���� ����");	
	}
	public static boolean divider(int n1, int n2){
		try{
			int result = n1 / n2;
			System.out.println("������ ��� : " + result);
			return true;
		}catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			System.out.println("finally ���� ����");
		}
	}
}
