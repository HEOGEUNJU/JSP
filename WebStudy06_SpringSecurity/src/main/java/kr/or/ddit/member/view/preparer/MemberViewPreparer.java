package kr.or.ddit.member.view.preparer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.MenuVO;

public class MemberViewPreparer implements ViewPreparer {
	
	@Inject
	private MemberDAO dao;
	
	@Override
	public void execute(Request req, AttributeContext attrContext) {
//		게시글 작성 : /board/boardInsert.do
//		게시글 목록조회 : /board/boardList.do
		MenuVO menu1 = new MenuVO("게시글 작성", "/member/memberInsert.do");
		MenuVO menu2 = new MenuVO("게시글 목록조회", "/member/memberList.do");
		List<MenuVO> menuList = Arrays.asList(menu1, menu2);
		Map<String, Object> scope = req.getContext(Request.REQUEST_SCOPE);
		scope.put("menuList", menuList);
		
	}

}
