package test.project.ko.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService; 	
	
	// 회원가입 페이지로 이동
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String MoveJoin(@ModelAttribute MemberDTO memberDTO) throws Exception {
		return "member/join";
	}
	
	// 회원가입
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String Join(@ModelAttribute @Valid MemberDTO memberDTO, BindingResult result, RedirectAttributes rttr ) throws Exception {		
		// @Valid 대상 바로 뒤에 BindingResult를 선언해야 에러가 발생하지 않는다
		// 에러가 있는지 검사
		if( result.hasErrors() ) {
			// 에러를 List로 저장
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list ) { // 에러가 발생한 내역을 이클립스 콘솔에 출력
				System.out.println(error);
			}
			return "/member/join";
		}
		int check = memberService.Join(memberDTO); // 사용자 이름, 포인트 현황을 받아오는 메소드
		if(check > 0) {
			rttr.addFlashAttribute("msg", "회원가입 성공"); // 로그인 성공 메시지 출력
			return "redirect:/";
		}
		rttr.addFlashAttribute("msg", "회원가입 실패"); // 로그인 실패 메시지 출력		
		return "member/join";
	}	
	
	// 로그인 페이지로 이동
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String MoveLogin() {
		return "member/login";
	}
	
	// 로그인 기능
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String Login(@ModelAttribute("memberDTO") MemberDTO memberDTO, HttpSession session, Model model, BindingResult result) {
		
		String msg = "로그인 실패";		
		MemberDTO login = memberService.Login(memberDTO); // 사용자 이름, 포인트 현황을 받아오는 메소드
		if(login != null) {
			session.setAttribute("login", login); // 세션에 사용자 정보 업데이트
			return "redirect:/";
		}
		model.addAttribute("msg", msg); // 로그인 실패 메시지 출력
		return "member/login";
	}
}
