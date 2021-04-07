package test.project.ko.board;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.project.ko.util.PagingVO;


@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService; 
	
	// �Խ��� ����Ʈ ���
	@RequestMapping(value="/board/boardListPaging", method=RequestMethod.GET)
	public String list(PagingVO vo, Model model, @RequestParam(value="nowPage", required=false)String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		int total = boardService.countBoard();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if(nowPage == null) {
			nowPage = "1";
		} else if(cntPerPage == null) {
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("boardlist", boardService.selectBoard(vo));
		return "board/board_Paging";
	}

	// �Խ��� �� ���� ��ȸ + �� ��ȸ�� ����
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String BoardDetail(Model model, @RequestParam("bno") int bno) {
		
		BoardDTO boardDTO = boardService.BoardDetail(bno);
		int check = boardService.ReadCnt(bno);
		
		System.out.println(boardDTO);
		model.addAttribute("detail_data", boardDTO);
		
		return "board/board_detail";
	}
	
	// �Խ��� �� ����ȭ������ �̵�
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String MoveBoardUpdate(Model model, @RequestParam("bno") int bno) {
		
		logger.info("����ȭ������ �̵�");
		BoardDTO boardDTO = boardService.BoardDetail(bno);		
		System.out.println(boardDTO);
		model.addAttribute("detail_data", boardDTO);
		
		return "board/board_update";
	}
	
	// �Խ��� �� ����
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String BoardUpdate(BoardDTO boardDTO) {
		
		logger.info("���� ���� �޼��� ����");
		System.out.println(boardDTO);
		int check = boardService.BoardUpdate(boardDTO);				
		
		return "redirect:/board/board_Paging";
	}
	
	// �Խ��� �� �ۼ� ȭ������ �̵�
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public String MoveBoardRegister() {
		return "board/board_register";
	}
	
	// �Խ��� �� �ۼ�
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public String BoardRegister(Model model, BoardDTO boardDTO) {
		
		int check = boardService.Register(boardDTO);		
		String msg = "�Խñ� ��� �� ������ �߻��߽��ϴ�.";
		
		if(check > 0) {
			msg = "�Խñ��� ����߽��ϴ�.";
		}		
		model.addAttribute("msg", msg);	
		return "redirect:/board/board_Paging";
	}

	// �Խ��� �� ����
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String BoardDelete(@RequestParam("bno") int bno) {
		
		int check = boardService.Delete(bno);		
		
		if(check > 0) {
//			msg = "�Խñ��� ����߽��ϴ�.";
		}		
		return "redirect:/board/board_Paging";
	}
	
	//�Խ��� �� �˻�
	@RequestMapping(value = "/board/search", method = RequestMethod.POST)
	public String BoardSearch(PagingVO vo, Model model, @RequestParam(value="nowPage", required=false)String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			@RequestBody Map<String, Object> data) {
		logger.info("�˻� �޼��� ����");
		int total = boardService.countBoard();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if(nowPage == null) {
			nowPage = "1";
		} else if(cntPerPage == null) {
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		String SearchType = (String)data.get("SearchType");
		String SearchData = (String)data.get("SearchData");
		
		if(SearchType == "boardname") {
			model.addAttribute("boardlist", boardService.SearchBoardN(SearchData));
		} else {
			model.addAttribute("boardlist", boardService.SearchBoardU(SearchData));
		}
		model.addAttribute("paging", vo);
		
		return "board/board_Paging";
	}
	
	// ��� ����Ʈ ��ȸ 
	@ResponseBody
	@RequestMapping(value = "/board/replylist", method = RequestMethod.POST)
	public List<ReplyDTO> BoardReplyList(@RequestParam("bno") int bno) {
		
		List<ReplyDTO> replyDTO = boardService.ReplyList(bno);
		
		System.out.println(replyDTO);
		
		return replyDTO;
	}
}
