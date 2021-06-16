import java.util.*;

class StringTokenizerTest {
	public static void main(String[] args) {
		String str1 = "ab:cd:ef:gh";
		StringTokenizer st1 = new StringTokenizer(str1, ":");
		// str1의 문자열을 콜론(:)을 기준으로 잘라 StringTokenizer 인스턴스로 생성
		while (st1.hasMoreTokens()) {
		// st1 인스턴스에 남은 토큰이 있으면
			System.out.println(st1.nextToken());
			// st1.nextToken() : st1 인스턴스에서 다음 토큰을 리턴
		}

		String str2 = "abc:def;ghi jkl-mno:pqr";

		StringTokenizer st2 = new StringTokenizer(str2);
		// str2의 문자열을 띄어쓰기를 기준으로 자름
		while (st2.hasMoreTokens())	System.out.print(st2.nextToken() + "  ");
		// abc:def;ghi  jkl-mno:pqr
		System.out.println();

		StringTokenizer st3 = new StringTokenizer(str2, ":; -");
		// str2의 문자열을 ":; -"들을 기준으로 자름(각각이 구분자로 사용됨)
		while (st3.hasMoreTokens())	System.out.print(st3.nextToken() + "  ");
		// abc  def  ghi  jkl  mno  pqr
		System.out.println();

		StringTokenizer st4 = new StringTokenizer(str2, ":; -", true);
		// str2의 문자열을 ":; -"들을 기준으로 자름(각각이 구분자로 사용됨) - 구분자로 사용한 문자로 토큰에 포함
		while (st4.hasMoreTokens())	System.out.print(st4.nextToken() + "  ");
		// abc  :  def  ;  ghi     jkl  -  mno  :  pqr
		System.out.println();
	}
}
