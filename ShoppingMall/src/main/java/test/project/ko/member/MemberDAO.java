package test.project.ko.member;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import test.project.ko.util.PagingVO;

public interface MemberDAO {

	// 로그인
	public MemberDTO Login(MemberDTO memberDTO);
	
	// 회원가입
	public int Join(MemberDTO memberDTO);
	
	// 아이디 중복체크
	public int EmailCheck(String member_email);

	// 회원정보 수정
	public int UpdateMember(MemberDTO memberDTO);
	
	// 마이페이지
	public MemberDTO Mypage(int member_no);
}