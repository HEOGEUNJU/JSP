package kr.or.ddit.designpattern.templatemethodpattern;

/**
 * 순서를 정의하고 있는 메소드 = template 메소드
 * 순서가 정해져 있는 작업을 할 때 사용
 * 순서 상에 일부 코드가 형태가 달라질 때 사용
 * 디자인 패턴이 없는 형태에서는 다 따로 따로 코딩해야 함.
 */
public abstract class TemplateClass {
	//template 메소드
	public final void template() {
		stepOne();
		stepTwo();
		stepThree();
	}
	//hook 메소드
	private void stepOne() {
		System.out.println("1단계");
	}
	
	protected abstract void stepTwo();
	
	private void stepThree() {
		System.out.println("3단계");
	}
}
