import java.util.*;

class ArrayMinMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arrInt = new int[5];
		for (int i = 0 ; i < arrInt.length ; i++) {
			System.out.print("정수 입력 : ");
			arrInt[i] = sc.nextInt();
			// Scanner를 통해 입력받은 정수를 arrInt배열에 저장
			// 문자열은 nextLine()으로 받음
		}

		System.out.println("최소값 : " + minValue(arrInt));
		System.out.println("최대값 : " + maxValue(arrInt));
	}
	public static int minValue(int[] arr) {	// 받아 온 배열 arr에서 최소값을 구하여 리턴하는 메소드
		int min = arr[0];
		for (int i = 1 ; i < arr.length ; i++) {
			if (min > arr[i])	min = arr[i];
		}
		return min;
	}
	public static int maxValue(int[] arr) {	// 받아 온 배열 arr에서 최대값을 구하여 리턴하는 메소드
		int max = arr[0];
		for (int i = 1 ; i < arr.length ; i++) {
			if (max < arr[i])	max = arr[i];
		}
		return max;
	}
}
