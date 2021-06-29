package test;
// 현 클래스가 test라는 패키지에 속하게 됨(실제로는 test라는 폴더가 생성되어 그 안에 저장됨)

public class BeanTest {
	private String name = "hong-gildong";
	public String getName() {
		return name;
	}
	public void setName(String name) {	// setter는 void다
		this.name = name;
	}
	
}
