class TV {
	public void onTV() { System.out.println("���� ��� ��"); }
}

interface Computer {
	public void dataReceive();
}

class ComputerImpl {
	public void dataReceive() { System.out.println("���� ������ ���� ��"); }
}

class IPTV extends TV implements Computer {
	ComputerImpl com = new ComputerImpl();
	public void dataReceive() {
		com.dataReceive();
	}
	public void powerOn() {
		dataReceive();
		onTV();
	}
}

class MultiInheri1 {
	public static void main(String[] args) {
		IPTV iptv = new IPTV();
		iptv.powerOn();

		TV tv = iptv;
		Computer com = iptv;
	}
}
