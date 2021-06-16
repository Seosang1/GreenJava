import java.util.*;

class StringTokenizerTest {
	public static void main(String[] args) {
		String str1 = "ab:cd:ef:gh";
		StringTokenizer st1 = new StringTokenizer(str1, ":");
		// str1�� ���ڿ��� �ݷ�(:)�� �������� �߶� StringTokenizer �ν��Ͻ��� ����
		while (st1.hasMoreTokens()) {
		// st1 �ν��Ͻ��� ���� ��ū�� ������
			System.out.println(st1.nextToken());
			// st1.nextToken() : st1 �ν��Ͻ����� ���� ��ū�� ����
		}

		String str2 = "abc:def;ghi jkl-mno:pqr";

		StringTokenizer st2 = new StringTokenizer(str2);
		// str2�� ���ڿ��� ���⸦ �������� �ڸ�
		while (st2.hasMoreTokens())	System.out.print(st2.nextToken() + "  ");
		// abc:def;ghi  jkl-mno:pqr
		System.out.println();

		StringTokenizer st3 = new StringTokenizer(str2, ":; -");
		// str2�� ���ڿ��� ":; -"���� �������� �ڸ�(������ �����ڷ� ����)
		while (st3.hasMoreTokens())	System.out.print(st3.nextToken() + "  ");
		// abc  def  ghi  jkl  mno  pqr
		System.out.println();

		StringTokenizer st4 = new StringTokenizer(str2, ":; -", true);
		// str2�� ���ڿ��� ":; -"���� �������� �ڸ�(������ �����ڷ� ����) - �����ڷ� ����� ���ڷ� ��ū�� ����
		while (st4.hasMoreTokens())	System.out.print(st4.nextToken() + "  ");
		// abc  :  def  ;  ghi     jkl  -  mno  :  pqr
		System.out.println();
	}
}
