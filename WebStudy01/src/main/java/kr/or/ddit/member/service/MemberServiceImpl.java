package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.UserNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	// 결합력 최상인 상태
	private MemberDAO memberDAO = new MemberDAOImpl();
	
	@Override
	public ServiceResult createMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		List<MemberVO> memberList = memberDAO.selectMemberList(); 
		memberList.stream()
			.forEach(System.out::println);//method reperence 문법
		return memberList;
	}

	@Override
	public MemberVO retrieveMember(String memId) {
		MemberVO resultObject = memberDAO.selectMember(memId);
		if(resultObject == null)
			throw new UserNotFoundException(String.format(memId +"에 해당하는 사용자 없음"));
		System.out.println(resultObject);
		return resultObject;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

}
