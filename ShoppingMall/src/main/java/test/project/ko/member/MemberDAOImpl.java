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

	// 글 목록
	@Override
	public List<MemberDTO> ListAll() {
		return sqlSession.selectList(nameSpace + ".ListAll");
	}
	
	// 선택 조회
	@Override
	public MemberDTO BoardDetail(int bno) {
		return sqlSession.selectOne(nameSpace + ".BoardDetail", bno);
	}
	
	// 글 작성
	@Override
	public int Register(MemberDTO boardDTO) {
		return sqlSession.insert(nameSpace + ".Register", boardDTO);
	}
	
	// 조회수
	@Override
	public int ReadCnt(int bno) {
		return sqlSession.update(nameSpace + ".ReadCnt", bno);
	}

	// 글 수정
	@Override
	public int BoardUpdate(MemberDTO dto) {
		return sqlSession.update(nameSpace + ".BoardUpdate", dto);
	}

	// 글 삭제
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
	
	// 게시글 검색 제목
	public List<MemberDTO> SearchBoardN(String SearchData) {
		return sqlSession.selectList(nameSpace + ".SearchBoardN", SearchData);
	}
	
	// 게시글 검색 사람
	public List<MemberDTO> SearchBoardU(String SearchData) {
		return sqlSession.selectList(nameSpace + ".SearchBoardU", SearchData);
	}

	// 댓글 번호 가져오기
	@Override
	public List<ReplyDTO> ReplyList(int bno) {
		return sqlSession.selectList(nameSpace+".ReplyList", bno);
	}
//
//	// 댓글 보기
//	@Override
//	public BoardReply ReplyDetail(int reno) {
//		return sqlSession.selectOne(nameSpace+".replydetail", reno);
//	}
//	
//	// 댓글 작성
//	@Override
//	public int Reply(BoardReply boardReply) {
//		return sqlSession.insert(nameSpace+".reply", boardReply);
//	}
//	
//	// 댓글 수정
//	@Override
//	public int ReplyUpdate(BoardReply boardr) {
//		return sqlSession.update(nameSpace+".replyupdate", boardr);
//	}
//
//	// 댓글 삭제
//	@Override
//	public int ReplyDelete(int reno) {
//		return sqlSession.delete(nameSpace+".replydelete", reno);
//	}
//
//	// 게시글 총 갯수
//	@Override
//	public int CountBoard() {
//		return sqlSession.selectOne(nameSpace+".countBoard");
//	}
//
//	// 페이징 처리 게시글 조회
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