class StringEx4 {
	public static void main(String[] args) {
		String file1 = "test.jpg";		String file2 = "test.gif";
		String file3 = "test.zip";		String file4 = "test.docx";

		isImg(file1); isImg(file2); isImg(file3); isImg(file4);
	}
	public static void isImg(String file){
		String ext = file.substring(file.lastIndexOf('.') + 1);
		// ���ϸ��� ������ ���� ��ġ �������� ������ �߶󳻾� ext�� ������(Ȯ���� ����)

		if (ext.equals("jpg") || ext.equals("gif") || ext.equals("png") || ext.equals("jpeg")) {
			System.out.println(file + "�� �̹��� ������ �½��ϴ�.");
		} else {
			System.out.println(file + "�� �̹��� ������ �ƴմϴ�.");
		}
	}
}
