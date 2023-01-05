package kr.or.ddit.vo;

import java.security.Principal;
//1단계
public class MemberVOWrapper implements Principal{
	private MemberVO realMember;

	public MemberVOWrapper(MemberVO realMember) {
		super();
		this.realMember = realMember;
	}

	public MemberVO getRealMember() {
		return realMember;
	}
	
	@Override
	public String getName() {
		
		return realMember.getMemId();
	}
}
