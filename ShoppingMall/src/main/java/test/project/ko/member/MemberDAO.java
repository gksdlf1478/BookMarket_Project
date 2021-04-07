package test.project.ko.member;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import test.project.ko.util.PagingVO;

public interface MemberDAO {

	// 로그인
	public int Login(MemberDTO memberDTO);
	
	// 회원가입
	public int Join(MemberDTO memberDTO);

	// 회원정보 수정
	public int UpdateMember(MemberDTO memberDTO);
	
}