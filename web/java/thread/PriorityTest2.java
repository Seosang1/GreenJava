class MessageThread extends Thread {
	String message;
	public MessageThread(String str, int prio) {
		message = str;
		setPriority(prio);
		// setPriority() : ThreadŬ������ �޼ҵ�� �ش� �������� �켱 ������ ������
	}
	public void run() {
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println(message + "(" + getPriority() + ")");
		}
	}
}

class PriorityTest2 {
	public static void main(String[] args) {
		MessageThread tr1 = new MessageThread("1st", Thread.MAX_PRIORITY);	// 10���� ���� ���� �켱����
		MessageThread tr2 = new MessageThread("2nd", Thread.NORM_PRIORITY);	// 5�� ��� �켱����
		MessageThread tr3 = new MessageThread("3rd", Thread.MIN_PRIORITY);	// 1�� ���� ���� �켱����

		tr1.start();	tr2.start();	tr3.start();
		// �켱������ �����ص� ��Ȯ�ϰ� ���� �켱������ �����尡 ���� ����Ǵ� ���� �ƴ�
		// ������ �߿��� ���α׷������� �����带 ����ϸ� �ȵ�
	}
}
