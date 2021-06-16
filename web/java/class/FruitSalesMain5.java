class FruitSeller {
	private int numOfApple;
	private int myMoney;
	private final int APPLE_PRICE;

	public FruitSeller(int num, int money, int price) {
		numOfApple = num;
		myMoney = money;
		APPLE_PRICE = price;
	}
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		myMoney += money;
		numOfApple -= num;

		return num;
	}
	public void showSaleResult() {
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("판매 수익 : " + myMoney);
	}
}

class FruitBuyer {
	private int numOfApple;
	private int myMoney;

	public FruitBuyer(int money) {
		numOfApple = 0;
		myMoney = money;
	}
	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("사과 개수 : " + numOfApple);
		System.out.println("현재 잔액 : " + myMoney);
	}
}

class FruitSalesMain5 {
	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller(30, 0, 1500);
		FruitSeller seller2 = new FruitSeller(20, 0, 1000);
		FruitBuyer buyer = new FruitBuyer(10000);

		buyer.buyApple(seller1, 4500);
		buyer.buyApple(seller2, 2000);

		System.out.println("사과판매자1 현재 상황");
		seller1.showSaleResult();

		System.out.println("사과판매자2 현재 상황");
		seller2.showSaleResult();

		System.out.println("사과구매자 현재 상황");
		buyer.showBuyResult();
	}
}
