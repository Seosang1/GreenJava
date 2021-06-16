class Sum {
	int num;
	public Sum() { num = 0; }
	public void addNum(int n) { num += n; }
	public int getNum() { return num; }
}

class AdderThread extends Sum implements Runnable {
// Thread�� ��ӹ��� �� ���� ��Ȳ������ Runnable �������̽��� �̿��Ͽ� ������ �۾��� �ؾ� ��
	int start, end;
	public AdderThread(int s, int e) {
		start = s;
		end = e;
	}
	public void run() {
	// Runnable �������̽��� abstract �޼ҵ�� �ݵ�� �����ؾ� ��
		for (int i = start ; i <= end ; i++) {
			addNum(i);
			// Sum Ŭ�������� ��ӹ��� �޼ҵ�
		}
	}
}

class RunnableThread {
	public static void main(String[] args) {
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);

		Thread tr1 = new Thread(at1);	Thread tr2 = new Thread(at2);
		// Thread Ŭ������ �����ڸ� �̿��Ͽ� Runnable �� �ν��Ͻ��� ������� ����

		tr1.start();	tr2.start();
		// ������ �� ���� �����带 ���� ��Ŵ(run() �޼ҵ� ȣ��)

		try {
			tr1.join();		tr2.join();
			// join() : �ش� ������ ��� �۾��� ���� �� ���� �ٸ� �۾��� ����Ű�� ���
			// join() �޼ҵ�� �޼ҵ� ����� throws InterruptedException�� �����߱� ������ ����ó���� �ϸ鼭 ȣ���ؾ� ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100 ������ �� : " + (at1.getNum() + at2.getNum()));
	}
}
