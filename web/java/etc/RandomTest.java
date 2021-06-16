import java.util.*;

class RandomTest {
	public static void main(String[] args) {
		Random rand = new Random();
		for (int i = 0 ; i < 10 ; i++) {
			System.out.print(rand.nextInt(100) + " ");
			// rand.nextInt(100) : 0 ~ 99 사이의 난수를 발생
		}
	}
}
