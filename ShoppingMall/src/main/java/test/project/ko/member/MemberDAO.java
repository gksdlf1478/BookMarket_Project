package test.project.ko.member;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import test.project.ko.util.PagingVO;

public interface MemberDAO {

	// �α���
	public int Login(MemberDTO memberDTO);
	
	// ȸ������
	public int Join(MemberDTO memberDTO);

	// ȸ������ ����
	public int UpdateMember(MemberDTO memberDTO);
	
}