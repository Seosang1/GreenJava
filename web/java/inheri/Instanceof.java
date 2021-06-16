class BasicBox {
	public void basicWrap() { System.out.println("basic wrap"); }
}

class PaperBox extends BasicBox {
	public void paperWrap() { System.out.println("paper wrap"); }
}

class GoldBox extends PaperBox {
	public void goldWrap() { System.out.println("gold wrap"); }
}

class InstanceOf {
	public static void main(String[] args) {
		BasicBox box1 = new BasicBox();
		PaperBox box2 = new PaperBox();
		GoldBox box3 = new GoldBox();

		wrapBox(box1);	wrapBox(box2);	wrapBox(box3);
	}
	public static void wrapBox(BasicBox box) {
	// �Ű������� BasicBox�� �����߱� ������ ����Ŭ������ PaperBox�� GoldBox�� �ν��Ͻ��� ���� �� ����

		// instanceof ������ ���� �˻�� ������Ŭ���� ���� �ؾ� ��
		if (box instanceof GoldBox) {
		// �޾ƿ� box �ν��Ͻ��� GoldBox������ ����ȯ�� �����ϸ�
			((GoldBox)box).goldWrap();
			// box�� GoldBox������ ����ȯ �� goldWrap() �޼ҵ� ȣ��
		} else if (box instanceof PaperBox) {
		// �޾ƿ� box �ν��Ͻ��� PaperBox������ ����ȯ�� �����ϸ�
			((PaperBox)box).paperWrap();
			// box�� PaperBox������ ����ȯ �� paperWrap() �޼ҵ� ȣ��
		} else {
			box.basicWrap();
			// box�� BasicBox���̹Ƿ� �� ���� basicWrap() �޼ҵ� ȣ��
		}
	}
}
