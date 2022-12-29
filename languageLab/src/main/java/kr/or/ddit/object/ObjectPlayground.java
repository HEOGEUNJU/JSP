package kr.or.ddit.object;

import org.openjdk.jol.vm.VM;
import org.openjdk.jol.vm.VirtualMachine;

public class ObjectPlayground {
	public static void main(String[] args) throws Exception {
		String qualifiedName = "kr.or.ddit.object.Parent";
		// 클래스는 상수 메모리에 저장되기 때문에 type1, type2는 같은 값이다.
		Class<?> type1 = Parent.class; 
		Class<?> type2 = Class.forName(qualifiedName);
		VirtualMachine vm = VM.current();
		System.out.printf("type1 adress : %d \n", vm.addressOf(type1));
		System.out.printf("type2 adress : %d \n", vm.addressOf(type2));
		
		Parent parent1 = new Parent();
		Object parent2 = type1.newInstance();
		System.out.printf("parent1 adress : %d \n", vm.addressOf(parent1));
		System.out.printf("parent2 adress : %d \n", vm.addressOf(parent2));
		
		System.out.printf("parent1 == parent2 : %b \n", parent1 == parent2);
		System.out.printf("parent1.equals(parent2) : %b \n", parent1.equals(parent2));
		
		int number1 = 20;
		int number2 = 20;
		
		System.out.printf("number1 adress : %d \n", vm.addressOf(number1));
		System.out.printf("number2 adress : %d \n", vm.addressOf(number2));
		
		StringBuffer sb1 = new StringBuffer("ORIGINAL");
		StringBuffer sb2 = new StringBuffer("ORIGINAL");
		
		System.out.printf("sb1 adress : %d \n", vm.addressOf(sb1));
		System.out.printf("sb2 adress : %d \n", vm.addressOf(sb2));
		
		number1 = sample(number1, sb1);
		System.out.printf("number1 : %d \n", number1); // call by value
		System.out.printf("sb1 : %s \n", sb1); // call by reference
		
		Child child = new Child();
		child.templete();
	}
	
	private static int sample(int number, StringBuffer sb) {
		number = number + 1;
		sb.append(" APPEND ");
		return number;
		
	}
}



















