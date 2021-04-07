package test.project.ko.member;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import test.project.ko.util.PagingVO;

public interface MemberDAO {

	// 글 목록 
	public List<MemberDTO> ListAll();

	// 글 작성
	public int Register(MemberDTO boardDTO);

	// 선택 조회
	public MemberDTO BoardDetail(int bno);
	
	// 조회수 증가
	public int ReadCnt(int bno); 
	
	// 글 수정 처리
	public int BoardUpdate(MemberDTO dto);
	
	// 글 삭제 처리
	public int Delete(int bno);
	
	// 페이징 관련 메소드 2개
	// 게시물 총 갯수
	public int countBoard();

	// 페이징 처리 게시글 조회
	public List<MemberDTO> selectBoard(PagingVO vo);
	
	// 게시글 검색
	public List<MemberDTO> SearchBoardN(String SearchData);

	// 게시글 검색
	public List<MemberDTO> SearchBoardU(String SearchData);
	
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

//	// 게시글 총 갯수
//	public int CountBoard();
//	
//	// 페이징 처리 게시글 조회
//	public List<BoardDTO> SelectBoard(PagingVO vo);
//	
//	// 카테고리 불러오기
//	public String SelectCategory(int bcategory);
	
}