/* RandomŬ������ �̿��Ͽ� �ζǹ�ȣ ������ �۾�(1~45������ ���� 6��, �ߺ��Ұ�) */
import java.util.*;

class RandomLotto {
	public static void main(String[] args) {
		int[] arrLotto = new int[6];
		Random rnd = new Random();

		for (int i = 0 ; i < arrLotto.length ; i++) {
			arrLotto[i] = rnd.nextInt(45) + 1;
			for (int j = 0 ; j < i ; j++) {
				if (arrLotto[i] == arrLotto[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0 ; i < arrLotto.length ; i++) {
			System.out.print(arrLotto[i] + " ");
		}
	}
}
