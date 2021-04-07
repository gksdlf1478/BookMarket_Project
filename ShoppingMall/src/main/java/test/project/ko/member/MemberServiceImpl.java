package test.project.ko.member;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import test.project.ko.util.PagingVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;

	@Override
	public int Login(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return memberDAO.Login(memberDTO);
	}

	@Override
	public int Join(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return memberDAO.Join(memberDTO);
	}

	@Override
	public int UpdateMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return memberDAO.UpdateMember(memberDTO);
	}



	
	
	
}