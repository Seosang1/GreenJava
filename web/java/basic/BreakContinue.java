class BreakContinue {
	public static void main(String[] args) {
		// 100������ �ڿ������� 5�� 7�� �ּҰ������ ���Ͽ� ��� - while�� ���
		int num = 1;	// 100���� ������ ������, �ּҰ������ ������ ����
		boolean isSearch = false;	// �ּҰ������ ã�Ҵ��� ���θ� ������ ����
		while (num <= 100) {
			if (num % 5 == 0 && num % 7 == 0) {
				isSearch = true;
				break;
			}
			num++;
		}
		if (isSearch) {
			System.out.println("5�� 7�� �ּҰ���� : " + num);
		} else {
			System.out.println("5�� 7�� �ּҰ������ ã�� ���߽��ϴ�.");
		}

		// 100������ ����� 5�� 7�� ������� ������ ���
		num = 0;	// 100���� ������ ���� ���� ������ ����
		int count = 0;	// 5�� 7�� ����� ������ ������ ����
		while (num <= 100) {
			num++;

			if (num % 5 != 0 || num % 7 != 0) {	// 5�� 7�� ������� �ƴϸ�
				continue;	// �Ʒ��� ���๮���� �����ϰ� �������� �ٷ� �ö�
			}

			count++;	// ������� ���� ����
			System.out.println(num);	// ����� ���
		}
		System.out.println("count : " + count);

		// 43�� 99�� �ּҰ������ ���Ͽ� ���
		num = 1;	// ������ ���� ���� ������ ����
		while (true) {	// ������ ��� ���̹Ƿ� ���ѷ���
		// ���ѷ��� ���� �ݵ�� ���ѷ����� �������� ������ ����� ���� ��
			if (num % 43 == 0 && num % 99 == 0) {
				break;
			}
			num++;
		}
		System.out.println(num);

		/*
		1���� �����ؼ� ��� Ȧ���� ¦�� �� 3�� ����� ���� ����.
		�� ���� �󸶸� ������ �� 1000�� �Ѵ���, �׸��� 1000�� ���� ���� ������ ��� - while, ���ѷ��� �̿�
		*/
		int sum = 0;
		num = 1;
		while (true) {
			if (num % 2 == 1) {
				sum += num;
			} else if (num % 3 == 0) {
				sum += num;
			}
			if (sum > 1000) {
				System.out.println(num + "��(��) ���� �� 1000�� ����");
				System.out.println("1000�� ���� �� : " + sum);
				break;
			}
			num++;
		}
	}
}
