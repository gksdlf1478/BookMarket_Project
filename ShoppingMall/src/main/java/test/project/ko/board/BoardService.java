package test.project.ko.board;

import java.util.List;
import java.util.Map;

import test.project.ko.util.PagingVO;

public interface BoardService {

	// 글 목록 조회
	public List<BoardDTO> ListAll();

	// 글 선택 조회
	public BoardDTO BoardDetail(int bno);
	
	// 글 작성
	public int Register(BoardDTO boardDTO);

	// 조회수 증가
	public int ReadCnt(int bno);

	// 글 수정 처리
	public int BoardUpdate(BoardDTO dto);

	// 글 삭제 처리
	public int Delete(int bno);
	
	// 페이징 관련 메소드 2개
	// 게시물 총 갯수
	public int countBoard();

	// 페이징 처리 게시글 조회
	public List<BoardDTO> selectBoard(PagingVO vo);
	
	// 게시글 검색
	public List<BoardDTO> SearchBoardN(String SearchData);

	// 게시글 검색
	public List<BoardDTO> SearchBoardU(String SearchData);
	
	// 게시물 번호에 해당하는 댓글 번호를 가져오는 메소드
	public List<ReplyDTO> ReplyList(int bno);
//
//	// 댓글 보기
//	public BoardReply ReplyDetail(int reno);
//
//	// 댓글 작성
//	public int Reply(BoardReply boardReply);
//
//	// 댓글 수정
//	public int ReplyUpdate(BoardReply boardr);
//
//	// 댓글 삭제
//	public int ReplyDelete(int reno);
//
//	// 게시글 총 갯수
//	public int CountBoard();
//
//	// 페이징 처리 게시글 조회
//	public List<BoardDTO> SelectBoard(PagingVO vo);
//
//	// 카테고리 불러오기
//	public String SelectCategory(int bcategory);
	
}