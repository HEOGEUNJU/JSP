package kr.or.ddit;

import java.util.ArrayList;
import java.util.List;

public class HelloMaven {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("SAMPLE");
		list.add("COOK");
		list.stream()
			.forEach(ele->{
				System.out.println(ele);
			});
	}
}
