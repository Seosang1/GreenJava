class ShowThread extends Thread {
// ThreadŬ������ ��� �������ν� ShowThreadŬ������ ������� ���� �� ����
	String name;
	public ShowThread(String name) {
		this.name = name;
	}
	public void run() {
	// �����忡�� �ؾ��� �ϵ��� ������ ���� �޼ҵ�� ������ ����� satrt()�޼ҵ带 ȣ���ϸ� �ڵ����� run()�޼ҵ尡 �����
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println("�ȳ��ϼ���. " + name + "�Դϴ�.");
			try {
				sleep(1);	// ���� ����ǰ� �ִ� �����带 0.1�� ���� ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadFirst {
	public static void main(String[] args) {
		ShowThread st1 = new ShowThread("1st ������");
		ShowThread st2 = new ShowThread("2nd ������");
		// st1�� st2 ��� ���α׷� �帧�� ���� �� ���� �����带 ����

		st1.start();	// st1 �̶�� �����带 �����Ŵ(run()�޼ҵ� ȣ��)
		st2.start();	// st2 �̶�� �����带 �����Ŵ(run()�޼ҵ� ȣ��)
		// ������� �����Ų ������ ������� ���� cpu�� �����ϴ� ���� �����
	}
}
