package test.project.ko.board;

import java.util.List;
import java.util.Map;

import test.project.ko.util.PagingVO;

public interface BoardService {

	// �� ��� ��ȸ
	public List<BoardDTO> ListAll();

	// �� ���� ��ȸ
	public BoardDTO BoardDetail(int bno);
	
	// �� �ۼ�
	public int Register(BoardDTO boardDTO);

	// ��ȸ�� ����
	public int ReadCnt(int bno);

	// �� ���� ó��
	public int BoardUpdate(BoardDTO dto);

	// �� ���� ó��
	public int Delete(int bno);
	
	// ����¡ ���� �޼ҵ� 2��
	// �Խù� �� ����
	public int countBoard();

	// ����¡ ó�� �Խñ� ��ȸ
	public List<BoardDTO> selectBoard(PagingVO vo);
	
	// �Խñ� �˻�
	public List<BoardDTO> SearchBoardN(String SearchData);

	// �Խñ� �˻�
	public List<BoardDTO> SearchBoardU(String SearchData);
	
	// �Խù� ��ȣ�� �ش��ϴ� ��� ��ȣ�� �������� �޼ҵ�
	public List<ReplyDTO> ReplyList(int bno);
//
//	// ��� ����
//	public BoardReply ReplyDetail(int reno);
//
//	// ��� �ۼ�
//	public int Reply(BoardReply boardReply);
//
//	// ��� ����
//	public int ReplyUpdate(BoardReply boardr);
//
//	// ��� ����
//	public int ReplyDelete(int reno);
//
//	// �Խñ� �� ����
//	public int CountBoard();
//
//	// ����¡ ó�� �Խñ� ��ȸ
//	public List<BoardDTO> SelectBoard(PagingVO vo);
//
//	// ī�װ� �ҷ�����
//	public String SelectCategory(int bcategory);
	
}