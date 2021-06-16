/* ���ڿ� "aa,bb,cc,dd"�� StringTokenizer�� StringŬ������ split�޼ҵ带 �̿��Ͽ� ���� ��� */
import java.util.*;

class SplitTokenizer {
	public static void main(String[] args) {
		String str = "aa,bb,cc,dd";

		StringTokenizer st = new StringTokenizer(str, ",");
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken() + "  ");	// aa  bb  cc  dd
		} // StringTokenizer �� �ѹ� ������ ���� ���� - �ٽ� ����Ϸ��� �ٽ� StringTokenizer �ν��Ͻ��� �����ؾ� ��

		System.out.println();
		String[] arr = str.split(",");
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + "  ");	// aa  bb  cc  dd
		}
	}
}
