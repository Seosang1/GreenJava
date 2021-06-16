class Array2DimenEx2 {
	public static void main(String[] args) {
		int[][] arr = {
			{1, 2}, 
			{3, 4, 5}, 
			{6, 7, 8, 9}
		};
		System.out.println("배열의 행 수 : " + arr.length);	// 3

		for (int i = 0 ; i < arr.length ; i++) {
			System.out.println(i + 1 + "행의 길이(열 수) : " + arr[i].length);
			// 1행의 길이 : 2
			// 2행의 길이 : 3
			// 3행의 길이 : 4
		}
	}
}
