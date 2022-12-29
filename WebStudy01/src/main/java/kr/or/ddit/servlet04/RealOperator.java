package kr.or.ddit.servlet04;



//@FunctionalInterface => 람다 표현식을 쓸수 있게됨 
@FunctionalInterface 
public interface RealOperator {
	public int operate(int leftOp, int rightOp);
}
