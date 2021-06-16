class Speaker {
	private int volume;
	public void showCurrentState() {
		System.out.println("볼륨 크기 : " + volume);
	}
	public void setVolume(int vol) { volume = vol; }
}

class BaseSpeaker extends Speaker {
	private int base;
	public void showCurrentState() {	// 상위클래스의 메소드를 오버라이딩한 것
		super.showCurrentState();
		// 오버라이딩된 메소드에서만 상위클래스의 원본 메소드를 호출할 수 있음
		System.out.println("베이스 크기 : " + base);
	}
	public void setBase(int base) { this.base = base; }
}

class Overriding {
	public static void main(String[] args) {
		BaseSpeaker bs = new BaseSpeaker();
		bs.setVolume(10);
		bs.setBase(20);
		bs.showCurrentState();
	}
}
