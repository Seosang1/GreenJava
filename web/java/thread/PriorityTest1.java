class MessageThread extends Thread {
	String message;
	public MessageThread(String str) { message = str; }
	public void run() {
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println(message + "(" + getPriority() + ")");
			// getPriority() : ThreadŬ������ �޼ҵ�� �ش� �������� �켱 ������ ������(�⺻���� 5)
		}
	}
}

class PriorityTest1 {
	public static void main(String[] args) {
		MessageThread tr1 = new MessageThread("1st");
		MessageThread tr2 = new MessageThread("2nd");
		MessageThread tr3 = new MessageThread("3rd");

		tr1.start();	tr2.start();	tr3.start();
		// ������ ȣ�� �����ʹ� �����ϰ� �����
	}
}
