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
	
	// ȸ������ �������� �̵�
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String MoveJoin(@ModelAttribute MemberDTO memberDTO) throws Exception {
		return "member/join";
	}
	
	// ȸ������
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String Join(@ModelAttribute @Valid MemberDTO memberDTO, BindingResult result, RedirectAttributes rttr ) throws Exception {		
		// @Valid ��� �ٷ� �ڿ� BindingResult�� �����ؾ� ������ �߻����� �ʴ´�
		// ������ �ִ��� �˻�
		if( result.hasErrors() ) {
			// ������ List�� ����
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list ) { // ������ �߻��� ������ ��Ŭ���� �ֿܼ� ���
				System.out.println(error);
			}
			return "/member/join";
		}
		int check = memberService.Join(memberDTO); // ����� �̸�, ����Ʈ ��Ȳ�� �޾ƿ��� �޼ҵ�
		if(check > 0) {
			rttr.addFlashAttribute("msg", "ȸ������ ����"); // �α��� ���� �޽��� ���
			return "redirect:/";
		}
		rttr.addFlashAttribute("msg", "ȸ������ ����"); // �α��� ���� �޽��� ���		
		return "member/join";
	}	
	
	// �α��� �������� �̵�
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String MoveLogin() {
		return "member/login";
	}
	
	// �α��� ���
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String Login(@ModelAttribute("memberDTO") MemberDTO memberDTO, HttpSession session, Model model, BindingResult result) {
		
		String msg = "�α��� ����";		
		MemberDTO login = memberService.Login(memberDTO); // ����� �̸�, ����Ʈ ��Ȳ�� �޾ƿ��� �޼ҵ�
		if(login != null) {
			session.setAttribute("login", login); // ���ǿ� ����� ���� ������Ʈ
			return "redirect:/";
		}
		model.addAttribute("msg", msg); // �α��� ���� �޽��� ���
		return "member/login";
	}
}
