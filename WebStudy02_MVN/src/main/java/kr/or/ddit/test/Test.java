package kr.or.ddit.test;

public class Test {
	public static void main(String[] args) {
		int TotalRecord = 120;
		int ScreenSize = 8;
		int CurrentPage = 6;
		int BlockPage = 6;
		
		int TotalPage = TotalRecord/ScreenSize;
		
		int StartPage = (CurrentPage-1)*ScreenSize+1;
		
		System.out.println(StartPage);
		
				
	}
}
