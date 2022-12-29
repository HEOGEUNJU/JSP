package kr.or.ddit.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.UserNotFoundException;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.login.service.AuthenticateServiceImpl;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.memo.controller.MemoControllerServlet;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	// 결합력 최상인 상태
	private MemberDAO memberDAO = new MemberDAOImpl();
	
	// 인증관련된 service
	private AuthenticateService authService = new AuthenticateServiceImpl(); 
	
	private static final Logger log = LoggerFactory.getLogger(MemoControllerServlet.class);
	
	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		try {
			retrieveMember(member.getMemId());
			result = ServiceResult.PKDUPLICATED;
		}catch (UserNotFoundException e) {
			int rowcnt = memberDAO.insertMember(member);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}

		return result;
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
		MemberVO inputData = new MemberVO();
		inputData.setMemId(member.getMemId());
		inputData.setMemPass(member.getMemPass());
		
		ServiceResult result = authService.authenticate(inputData);
		if(ServiceResult.OK.equals(result)) {
			int rowcnt = memberDAO.updateMember(member);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		MemberVO inputData = new MemberVO();
		inputData.setMemId(member.getMemId());
		inputData.setMemPass(member.getMemPass());
		
		ServiceResult result = authService.authenticate(inputData);
		if(ServiceResult.OK.equals(result)) {
			log.info("memberID : {}",member.getMemId() );
			int rowcnt = memberDAO.deleteMember(member.getMemId());
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		return result;
	}

}