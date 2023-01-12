package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vaildate.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *   Backend controller(command handler) --> Plain Old Java Object
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController{

   private final MemberService service;
   
   //모든 메소드 실행 전에 실행되어서 무엇을 하든 member라는 속성 개체를 가지고 있을 수 있다.
   @ModelAttribute("member")
   public MemberVO member() {
	   log.info("@ModelAttribute 메소드 실행 -> member 속성 생성");
	   return new MemberVO();
   }
   
   @GetMapping
   public String memberForm(@ModelAttribute("member") MemberVO member) {
      return "member/memberForm";
   }
   
   @PostMapping
   public String memberInsert(
         HttpServletRequest req
         //@ModelAttribute("member")이걸 지우면 request안에 memberVO라는 이름으로 저장된다.
         , @Validated(InsertGroup.class) @ModelAttribute("member") MemberVO member // 이미 존재하는 memberVo에 요청파라미터만 바인딩해줌.
         , Errors errors
      )throws ServletException, IOException {
      //member.setMemImage(memImage); 커멘드 오브젝트만 선언되면 알아서 저장해준다.

      // 로그인검증
      boolean valid = !errors.hasErrors();
      
      String viewName = null;
      
      if(valid) {
         ServiceResult result = service.createMember(member);
         switch (result) {
         case PKDUPLICATED:
            req.setAttribute("message", "아이디 중복");
            viewName = "member/memberForm";
            break;
            
         case FAIL:
            req.setAttribute("message", "서버에 문제 있음. 쫌따 다시 하셈");
            viewName = "member/memberForm";
            break;
            
         default:
            viewName = "redirect:/";
            break;
         }
      } else {
         viewName = "member/memberForm";
      }
      return viewName;
   }
}