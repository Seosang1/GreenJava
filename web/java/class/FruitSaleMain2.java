class FruitSeller {
	int numOfApple ;		 
	int myMoney ;			 
	int APPLE_PRICE  ;
		// �Ϲ� �޼ҵ忡�� ����� ���� ������ ���� �����Ƿ� APPLE_PRICE�� ����� ���� �Ұ�
		// �Ϲ� �޼ҵ�� �ٽ� ȣ���� �� �����Ƿ� ����� ���� �����ұ�� ������ �߻���Ŵ 
		// ����� �����ϸ� �����߻� 
	
	public void inhitMember(int num, int money, int price) {
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
		System.out.println("���� ��� : " + numOfApple);
		System.out.println("�Ǹ� ���� : " + myMoney);
	}
}

class FruitBuyer {	 
	int numOfApple = 0;		 
	int myMoney = 10000;		 

	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);  
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("��� ���� : " + numOfApple);
		System.out.println("���� �ܾ� : " + myMoney);
	}
}

class  FruitSaleMain2 {
	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller();	
		// FruitSeller�� �ν��Ͻ� seller1�� ���� �� ����
		seller1.inhitMember(30, 0, 1500);
		// seller1 �ν��Ͻ� ���� inhitMember() �޼ҵ� ����

		FruitSeller seller2 = new FruitSeller();	
		// FruitSeller�� �ν��Ͻ� seller2 ���� �� ����	  
		seller2.inhitMember(20, 0, 1000);
		// seller2 �ν��Ͻ� ���� inhitMember() �޼ҵ� ����

		FruitBuyer buyer = new FruitBuyer();	
		// FruitBuyer�� �ν��Ͻ� buyer ���� �� ����	  
		buyer.buyApple(seller1, 4500);   
		buyer.buyApple(seller2, 2000);   
		// �� �ٸ� �Ǹ��ڿ��� �������

		System.out.println("����Ǹ���1 ���� ��Ȳ");
		seller1.showSaleResult();	 

		System.out.println("����Ǹ���2 ���� ��Ȳ");
		seller2.showSaleResult();	 

		System.out.println("��������� ���� ��Ȳ");
		buyer.showBuyResult();	 
	}
}
 

/*
������
 - APPLE_PRICE�� ����� �ƴ� ������ ������
 - �ν��Ͻ� ������ �ΰ��� ����� �ʿ�
 - inhitMember() �޼ҵ带 ������ ȣ���� �� ����(�ٽ� ȣ��Ǹ� �Ǹű���� ��� ���µ�)

�ذ�å
 - APPLE_PRICE�� ����� ����
 - �ν��Ͻ� ������ �ϳ��� ������� ó��
 - �ʱ�ȭ �޼ҵ�� �� ���� ȣ��ǰ� �� - APPLE_PRICE�� ����� ������ �� �ְԵ�
 - ��� �ذ�å�� �����ڸ� ����ϸ� ��
*/