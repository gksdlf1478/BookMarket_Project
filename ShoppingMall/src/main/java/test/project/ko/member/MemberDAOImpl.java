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
	private static final String nameSpace= "test.project.ko.board";

	// �� ���
	@Override
	public List<MemberDTO> ListAll() {
		return sqlSession.selectList(nameSpace + ".ListAll");
	}
	
	// ���� ��ȸ
	@Override
	public MemberDTO BoardDetail(int bno) {
		return sqlSession.selectOne(nameSpace + ".BoardDetail", bno);
	}
	
	// �� �ۼ�
	@Override
	public int Register(MemberDTO boardDTO) {
		return sqlSession.insert(nameSpace + ".Register", boardDTO);
	}
	
	// ��ȸ��
	@Override
	public int ReadCnt(int bno) {
		return sqlSession.update(nameSpace + ".ReadCnt", bno);
	}

	// �� ����
	@Override
	public int BoardUpdate(MemberDTO dto) {
		return sqlSession.update(nameSpace + ".BoardUpdate", dto);
	}

	// �� ����
	@Override
	public int Delete(int bno) {
		return sqlSession.delete(nameSpace + ".Delete", bno);
	}
	
	@Override
	public int countBoard() {
		return sqlSession.selectOne(nameSpace + ".countBoard");
	}

	@Override
	public List<MemberDTO> selectBoard(PagingVO vo) {
		return sqlSession.selectList(nameSpace + ".selectBoard", vo);
	}
	
	// �Խñ� �˻� ����
	public List<MemberDTO> SearchBoardN(String SearchData) {
		return sqlSession.selectList(nameSpace + ".SearchBoardN", SearchData);
	}
	
	// �Խñ� �˻� ���
	public List<MemberDTO> SearchBoardU(String SearchData) {
		return sqlSession.selectList(nameSpace + ".SearchBoardU", SearchData);
	}

	// ��� ��ȣ ��������
	@Override
	public List<ReplyDTO> ReplyList(int bno) {
		return sqlSession.selectList(nameSpace+".ReplyList", bno);
	}
//
//	// ��� ����
//	@Override
//	public BoardReply ReplyDetail(int reno) {
//		return sqlSession.selectOne(nameSpace+".replydetail", reno);
//	}
//	
//	// ��� �ۼ�
//	@Override
//	public int Reply(BoardReply boardReply) {
//		return sqlSession.insert(nameSpace+".reply", boardReply);
//	}
//	
//	// ��� ����
//	@Override
//	public int ReplyUpdate(BoardReply boardr) {
//		return sqlSession.update(nameSpace+".replyupdate", boardr);
//	}
//
//	// ��� ����
//	@Override
//	public int ReplyDelete(int reno) {
//		return sqlSession.delete(nameSpace+".replydelete", reno);
//	}
//
//	// �Խñ� �� ����
//	@Override
//	public int CountBoard() {
//		return sqlSession.selectOne(nameSpace+".countBoard");
//	}
//
//	// ����¡ ó�� �Խñ� ��ȸ
//	@Override
//	public List<BoardDTO> SelectBoard(PagingVO vo) {
//		return sqlSession.selectList(nameSpace+".selectBoard", vo);
//	}
//
//	@Override
//	public String SelectCategory(int bcategory) {
//		return sqlSession.selectOne(nameSpace+".selectCategory", bcategory);
//	}
//
//	@Override
//	public BoardDTO ListDetail(int bno) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BoardReply ReplyDetail(int reno) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}