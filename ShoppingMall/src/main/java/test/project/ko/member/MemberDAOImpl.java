package test.project.ko.member;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import test.project.ko.util.PagingVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession; 
	private static final String nameSpace= "test.project.ko.member";
	
	@Override
	public int Login(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".Login");
	}

	@Override
	public int Join(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".Join");
	}

	@Override
	public int UpdateMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".UpdateMember");
	}

	
}