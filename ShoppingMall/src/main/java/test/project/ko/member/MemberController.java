package test.project.ko.member;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.project.ko.util.PagingVO;


@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberervice; 	
	
	// ȸ������ �������� �̵�
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String MoveJoin() {
		return "member/join";
	}
	
	// ȸ������
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String Join(Model model, MemberDTO memberDTO) {
		
		memberDTO.toString();
		
		return "main";
	}	
	
	// �α��� �������� �̵�
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String MoveLogin() {
		return "member/login";
	}
	
	// �α��� ���
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String Login(Model model, MemberDTO memberDTO) {
		
		memberDTO.toString();
		
		return "main";
	}
}
