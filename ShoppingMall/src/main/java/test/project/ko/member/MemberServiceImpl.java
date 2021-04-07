package test.project.ko.member;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import test.project.ko.util.PagingVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO boardDAO;

	@Override//
	public List<MemberDTO> ListAll() {
		return boardDAO.ListAll();
	}

	@Override//
	public MemberDTO BoardDetail(int bno) {
		return boardDAO.BoardDetail(bno);
	}
	
	@Override//
	public int Register(MemberDTO boardDTO) {
		return boardDAO.Register(boardDTO);
	}

	@Override
	public int ReadCnt(int bno) {
		return boardDAO.ReadCnt(bno);
	}

	@Override//
	public int BoardUpdate(MemberDTO dto) {
		return boardDAO.BoardUpdate(dto);
	}

	@Override
	public int Delete(int bno) {
		return boardDAO.Delete(bno);
	}

	@Override
	public int countBoard() {
		return boardDAO.countBoard();
	}

	@Override
	public List<MemberDTO> selectBoard(PagingVO vo) {
		return boardDAO.selectBoard(vo);
	}
	
	@Override
	public List<MemberDTO> SearchBoardN(String SearchData) {
		return boardDAO.SearchBoardN(SearchData);
	}
	
	@Override
	public List<MemberDTO> SearchBoardU(String SearchData) {
		return boardDAO.SearchBoardU(SearchData);
	}
	
	@Override
	public List<ReplyDTO> ReplyList(int bno) {
		return boardDAO.ReplyList(bno);
	}
//
//	@Override
//	public BoardReply ReplyDetail(int reno) {
//		return boardDAO.ReplyDetail(reno);
//	}
//
//	@Override
//	public int Reply(BoardReply boardReply) {
//		return boardDAO.Reply(boardReply);
//	}
//
//	@Override
//	public int ReplyUpdate(BoardReply boardr) {
//		return boardDAO.ReplyUpdate(boardr);
//	}
//
//	@Override
//	public int ReplyDelete(int reno) {
//		return boardDAO.ReplyDelete(reno);
//	}
//
//	@Override
//	public int CountBoard() {
//		return boardDAO.CountBoard();
//	}
//
//	@Override
//	public List<BoardDTO> SelectBoard(PagingVO vo) {
//		return boardDAO.SelectBoard(vo);
//	}
//
//	@Override
//	public String SelectCategory(int bcategory) {
//		return boardDAO.SelectCategory(bcategory);
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