package com.naver.cafe.club.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.naver.cafe.club.service.ClubService;
import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.common.Auth;
import com.naver.cafe.common.DownloadUtil;
import com.naver.cafe.common.pager.ListPageExplorer;
import com.naver.cafe.menu.vo.MenuVO;
import com.naver.cafe.reply.biz.ReplyBiz;
import com.naver.cafe.reply.vo.ReplyVO;

@Controller
public class ClubController {
	
	
	private ClubService clubService;
	private ReplyBiz replyBiz;
	private Logger logger;

	
	public void setClubService(ClubService clubService) {
		this.clubService = clubService;
	}
	
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	
	@Auth("USR")
	@RequestMapping("/club/{menuId}/init")
	public String viewClubListInitPage(@PathVariable String menuId, HttpSession session) {
		session.removeAttribute("_SEARCH_");
		return "redirect:/club/" + menuId;
	}
	
	@RequestMapping("/club/{menuId}")
	public ModelAndView viewClubListPage(@PathVariable String menuId, ClubSearchVO clubSearchVO, HttpSession session) {
		

		if(clubSearchVO.getPageNo() == null || 
				clubSearchVO.getPageNo().length() == 0) {
			ClubSearchVO clubSearchVOInSession = 
					(ClubSearchVO) session.getAttribute("_SEARCH_");
			
			if(clubSearchVOInSession != null) {
				clubSearchVO = clubSearchVOInSession;
			}
		}
		

		
		clubSearchVO.setMenuId(menuId);
		ClubListVO clubListVO = clubService.getAllClub(clubSearchVO);
		
	
		session.setAttribute("_SEARCH_", clubSearchVO);
		
		
		ModelAndView view = new ModelAndView();
		
		
		view.addObject("menu", clubListVO.getMenuList());
		view.addObject("clubList", clubListVO.getClubList());
		view.addObject("totalCount", clubListVO.getPager().getTotalArticleCount());
		view.addObject("currentMenu", clubListVO.getCurrentMenu());
		view.addObject("menuId", menuId);
		
		ListPageExplorer pageExplorer = new ListPageExplorer(clubListVO.getPager());
		String pager = pageExplorer.getPagingList("PageNo", " @ ", " �씠�쟾 ", " �떎�쓬 ", "searchForm");

		
		view.addObject("pager", pager);
		
		view.setViewName("club/list");
		
		return view;
	}
	
	@Auth("USR")
	@RequestMapping("/club/read/{menuId}/{id}")
	public String viewReadPage(@PathVariable String menuId, @PathVariable String id) {
		
		ClubSearchVO clubSearchVO = new ClubSearchVO();
		clubSearchVO.setMenuId(menuId);
		clubSearchVO.setArticleId(id);
		
	
		
		Map<String, Object> club = clubService.selectOneClub(clubSearchVO);
		
		ClubVO clubVO = (ClubVO) club.get("club");
		
		clubVO.setMemberId(menuId);
		clubVO.setArticleId(id);
		
		clubService.updateReadCount(clubVO);
		return "redirect:/club/detail/" + menuId + "/" + id;
	}
	
	@Auth("USR")
	@RequestMapping("/club/detail/{menuId}/{id}")
	public ModelAndView viewDetailPage(@PathVariable String menuId, @PathVariable String id) {
		ModelAndView view = new ModelAndView();
		view.setViewName("club/detail");
		
	
			
		view.addObject("menuId", menuId);
		 
		ClubSearchVO clubSearchVO = new ClubSearchVO();
		
		clubSearchVO.setMenuId(menuId);
		clubSearchVO.setArticleId(id);
	
		
		Map<String, Object> club = clubService.selectOneClub(clubSearchVO);
		ClubVO clubVO = (ClubVO) club.get("club");
		List<MenuVO> allMenu = (List<MenuVO>) club.get("menu");
		List<MenuVO> currentMenu = (List<MenuVO>) club.get("currentMenu");
		
	//	view.addObject("club", clubService.selectOneClub(clubSearchVO));
		
		view.addObject("club", clubVO);
		view.addObject("menu", allMenu);
		view.addObject("currentMenu", currentMenu);
		
		return view;
	}
	
	@Auth("USR")
	@RequestMapping(value="/club/write/{menuId}", method=RequestMethod.GET)
	public ModelAndView viewWriteArticlePage(@PathVariable String menuId) {
		ModelAndView view = new ModelAndView();
		view.setViewName("club/write");
		view.addObject("menuId", menuId);
		return view;
	}
	
	@Auth("USR")
	@RequestMapping(value="/club/write/{menuId}", method=RequestMethod.POST)
	public String doWriteArticleAction(@PathVariable String menuId, ClubVO clubVO) {
		clubVO.setMenuId(menuId);
		clubVO.setMemberId("user");
		
		boolean isSuccess = clubService.addNewClub(clubVO);
		
		return "redirect:/club/" + menuId;
	}

	@Auth("USR")
	@RequestMapping(value="/club/upload", method=RequestMethod.POST)
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
			out.write("'<p>http://localhost:8080/cafe/club/download/" + 
					file.getOriginalFilename()
					.replaceAll(" ", "_")
					.replaceAll("[.]", "_dot_") + "</p>';");
			out.write("</script>");
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
	@Auth("USR")
	@RequestMapping("/club/download/{fileName}")
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
	
	
	@Auth("USR")
	@RequestMapping(value="/club/reply/write", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, String> doWriteReplyAction(HttpServletRequest request) {
		
		String articleId = request.getParameter("articleId");
		String content = request.getParameter("content");	
		String parentReplyId = request.getParameter("parentReplyId");
		HashMap<String, String> hashmap = new HashMap<String, String>();
		if(parentReplyId == null){
			parentReplyId = "";
		}
		
		ReplyVO replyVO = new ReplyVO();
		
		replyVO.setArticleId(articleId);
		replyVO.setContent(content);
		replyVO.setParentReplyId(parentReplyId);
		replyVO.setMemberId("user");
		
		if(replyBiz.insertOneReply(replyVO)) {
			hashmap.put("SUCCESS", "YES");
		}
		
		else {
			hashmap.put("SUCCESS", "YES");
		}
		
	 
		return hashmap;
	}
	
	@Auth("USR")
	@RequestMapping(value="/club/reply/count/{replyId}", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, String> countReplyAction(@PathVariable String replyId) {
		
		HashMap<String, String> hashmap = new HashMap<String, String>();
		
		if(replyBiz.updateCountReply(replyId)) {
			hashmap.put("SUCCESS", "YES");
		}
		
		else {
			hashmap.put("SUCCESS", "NO");
		}
		
		return hashmap;
	}
	
	
	@Auth("USR")
	@RequestMapping(value="/club/delete/{menuId}", method=RequestMethod.GET)
	public String deleteArticleAction(@PathVariable String menuId, ClubVO clubVO) {
		clubVO.setMenuId(menuId);
		clubVO.setMemberId("user");
		
		boolean isSuccess = clubService.addNewClub(clubVO);
		
		return "redirect:/club/" + menuId;
	}

	
	
}
