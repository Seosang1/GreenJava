class BufferBuilder2 {
	public static void main(String[] args) {
		String mail1 = "abcd", mail2 = "@", mail3 = "naver.com";

		/* mail�� �ϼ��� �����ּҰ� ������ StringBuilder�� �̿��Ͽ� �۾� */
		StringBuilder sb = new StringBuilder(mail1);
		sb.append(mail2).append(mail3);
		String mail = new String(sb);
		System.out.println(mail);
	}
}
