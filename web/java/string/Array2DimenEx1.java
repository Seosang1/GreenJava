class Array2DimenEx1 {
	public static void main(String[] args) {
		int[][] arr = new int[3][4];

		for (int i = 0 ; i < arr.length ; i++) {
		// arr.length : arr�迭�� ��� - 3
			for (int j = 0 ; j < arr[i].length ; j++) {
			// arr[i].length : i�ε����� �ش��ϴ� 1���� �迭�� ���� - 4
				arr[i][j] = i + j;
			}
		}

		for (int i = 0 ; i < arr.length ; i++) {
			for (int j = 0 ; j < arr[i].length ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
