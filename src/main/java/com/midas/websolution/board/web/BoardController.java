package com.midas.websolution.board.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.board.service.BoardService;
import com.midas.websolution.board.vo.BoardSearchVO;
import com.midas.websolution.board.vo.BoardVO;
import com.midas.websolution.common.DownloadUtil;
import com.midas.websolution.common.pager.ListPageExplorer;


@Controller
public class BoardController {
	
	private BoardService boardService;
	private Logger logger;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board")
	public ModelAndView viewAllArticles(BoardSearchVO boardSearchVO) {
		
		List<BoardVO> boardList = boardService.getAllArticles(boardSearchVO);
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("boardList", boardList);
		view.addObject("content", "board/list.jsp");
		
		ListPageExplorer pageExplorer = new ListPageExplorer(boardSearchVO.getPager());
		String pager = pageExplorer.getPagingList("PageNo", " @ ", " 이전 ", " 다음 ", "searchForm");
		
		view.addObject("pager", pager);
		
		view.setViewName("/index");
		
		return view;	
	}
	
	

	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public ModelAndView viewWriteArticlePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/index");
		view.addObject("content", "board/write.jsp");
		return view;
	}
	

	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String doWriteArticleAction(BoardVO boardVO) {
	
		boolean isSuccess = boardService.insertOneArticle(boardVO);
		
		return "redirect:/board";
	}


	@RequestMapping(value="/board/upload", method=RequestMethod.POST)
	public void doUploadFile(
			MultipartHttpServletRequest request, HttpServletResponse response) {
		MultipartFile file = request.getFile("file");
		
		if(file !=null && !file.isEmpty()) {
			File uploadPath = new File("d://uploadFiles//" + file.getOriginalFilename().replaceAll(" ", "_"));
			
			try {
				file.transferTo(uploadPath);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage(), e);
			} catch (IOException e) {
			}
			
		}
		
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("parent.document.getElementById('uploadFiles').innerHTML += ");	
			out.write("'<p>http://localhost:5000/sample/board/download/" + 
					file.getOriginalFilename()
					.replaceAll(" ", "_")
					.replaceAll("[.]", "_dot_") + "</p>';");
			out.write("</script>");
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	

	@RequestMapping("/board/download/{fileName}")
	public void downloadAttachedFile(@PathVariable String fileName,
			HttpServletRequest request
			, HttpServletResponse response) {
		DownloadUtil download = 
				DownloadUtil.getInstance("d://uploadFiles//");
		fileName = fileName.replaceAll("_dot_", ".");
		try {
			download.download(request, response, fileName, fileName);
		}
		
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	
	@RequestMapping("/board/detail/{articleId}")
	public ModelAndView viewDetailPage(@PathVariable String articleId) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/index");
		
		BoardVO board = boardService.getOneArticle(articleId);
		
		System.out.println(board.getCreatedDate());
		
		view.addObject("board", board);
		view.addObject("content", "board/detail.jsp");

		return view;
	}
	
	
	
	
}
