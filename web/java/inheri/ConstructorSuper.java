class Car {
	private int gasoline;

	public Car(int g) {
		gasoline = g;
	}
	protected int getGasoline() { return gasoline; }
}

class HybridCar extends Car {
	private int electric;

	public HybridCar(int g, int e) {
		super(g);
		electric = e;
	}
	protected int getElectric() { return electric; }
}

class HybridWaterCar extends HybridCar {
	private int water;

	public HybridWaterCar(int g, int e, int w) {
		super(g, e);
		water = w;
	}
	public void showCurrentGauge() {
		System.out.println("�ܿ� ���ָ� : " + getGasoline());
		System.out.println("�ܿ� ���ⷮ : " + getElectric());
		System.out.println("�ܿ� ���ͷ� : " + water);
	}
}

class ConstructorSuper {
	public static void main(String[] args) {
		HybridWaterCar car1 = new HybridWaterCar(4, 2, 3);
		car1.showCurrentGauge();

		HybridWaterCar car2 = new HybridWaterCar(9, 5, 7);
		car2.showCurrentGauge();
	}
}
