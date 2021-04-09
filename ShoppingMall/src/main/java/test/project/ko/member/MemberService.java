package test.project.ko.member;

import java.util.List;
import java.util.Map;

import test.project.ko.util.PagingVO;

public interface MemberService {

	// 로그인
	public MemberDTO Login(MemberDTO memberDTO);
	
	// 회원가입
	public int Join(MemberDTO memberDTO);
	
	// 아이디 중복체크
	public int EmailCheck(String member_email);

	// 회원정보 수정
	public int UpdateMember(MemberDTO memberDTO);
	
}