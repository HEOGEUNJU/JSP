package kr.or.ddit.object;

import org.openjdk.jol.vm.VM;
import org.openjdk.jol.vm.VirtualMachine;

public class StringPlayground {
	public static void main(String[] args) {
		VirtualMachine vm = VM.current();
		String str1 = "SAMPLE";
		String str2 = "SAMPLE";
		String str3 = new String("SAMPLE");
		String str4 = new String(str1);
		
		System.out.printf("str1 == str2 : %b \n", str1 == str2 );
		System.out.printf("str2 == str3 : %b \n", str2 == str3 );
		System.out.printf("str3 == str4 : %b \n", str3 == str4 );
		System.out.printf("str4 == str1 : %b \n", str4 == str1 );
		System.out.printf("str1.equals(str2) : %b \n", str1.equals(str2) );
		System.out.printf("str2.equals(str3) : %b \n", str2.equals(str3) );
		System.out.printf("str3.equals(str4) : %b \n", str3.equals(str4) );
		System.out.printf("str1.equals(str4) : %b \n", str1.equals(str4) );
	
		
		
		System.out.printf("str1 adress : %d \n", vm.addressOf(str1));
		System.out.printf("str2 adress : %d \n", vm.addressOf(str2));
		System.out.printf("str3 adress : %d \n", vm.addressOf(str3));
		System.out.printf("str4 adress : %d \n", vm.addressOf(str4));
	}
}
