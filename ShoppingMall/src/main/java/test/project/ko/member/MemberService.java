package test.project.ko.member;

import java.util.List;
import java.util.Map;

import test.project.ko.util.PagingVO;

public interface MemberService {

	// �α���
	public MemberDTO Login(MemberDTO memberDTO);
	
	// ȸ������
	public int Join(MemberDTO memberDTO);

	// ȸ������ ����
	public int UpdateMember(MemberDTO memberDTO);
	
}