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
	
	// 게시판 리스트 출력
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

	// 게시판 글 선택 조회 + 글 조회수 증가
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String BoardDetail(Model model, @RequestParam("bno") int bno) {
		
		BoardDTO boardDTO = boardService.BoardDetail(bno);
		int check = boardService.ReadCnt(bno);
		
		System.out.println(boardDTO);
		model.addAttribute("detail_data", boardDTO);
		
		return "board/board_detail";
	}
	
	// 게시판 글 수정화면으로 이동
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String MoveBoardUpdate(Model model, @RequestParam("bno") int bno) {
		
		logger.info("수정화면으로 이동");
		BoardDTO boardDTO = boardService.BoardDetail(bno);		
		System.out.println(boardDTO);
		model.addAttribute("detail_data", boardDTO);
		
		return "board/board_update";
	}
	
	// 게시판 글 수정
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String BoardUpdate(BoardDTO boardDTO) {
		
		logger.info("수정 진행 메서드 진입");
		System.out.println(boardDTO);
		int check = boardService.BoardUpdate(boardDTO);				
		
		return "redirect:/board/board_Paging";
	}
	
	// 게시판 글 작성 화면으로 이동
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public String MoveBoardRegister() {
		return "board/board_register";
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public String BoardRegister(Model model, BoardDTO boardDTO) {
		
		int check = boardService.Register(boardDTO);		
		String msg = "게시글 등록 중 오류가 발생했습니다.";
		
		if(check > 0) {
			msg = "게시글을 등록했습니다.";
		}		
		model.addAttribute("msg", msg);	
		return "redirect:/board/board_Paging";
	}

	// 게시판 글 삭제
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String BoardDelete(@RequestParam("bno") int bno) {
		
		int check = boardService.Delete(bno);		
		
		if(check > 0) {
//			msg = "게시글을 등록했습니다.";
		}		
		return "redirect:/board/board_Paging";
	}
	
	//게시판 글 검색
	@RequestMapping(value = "/board/search", method = RequestMethod.POST)
	public String BoardSearch(PagingVO vo, Model model, @RequestParam(value="nowPage", required=false)String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			@RequestBody Map<String, Object> data) {
		logger.info("검색 메서드 시작");
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
	
	// 댓글 리스트 조회 
	@ResponseBody
	@RequestMapping(value = "/board/replylist", method = RequestMethod.POST)
	public List<ReplyDTO> BoardReplyList(@RequestParam("bno") int bno) {
		
		List<ReplyDTO> replyDTO = boardService.ReplyList(bno);
		
		System.out.println(replyDTO);
		
		return replyDTO;
	}
}
