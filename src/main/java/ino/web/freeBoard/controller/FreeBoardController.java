package ino.web.freeBoard.controller;

import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.dto.PageDto;
import ino.web.freeBoard.dto.PaginationDto;
import ino.web.freeBoard.service.FreeBoardService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/main.ino")
	public ModelAndView main(PaginationDto pdto,Model model){
		System.out.println("///1///");
		ModelAndView mav = new ModelAndView();
//		List list = freeBoardService.freeBoardList();
		System.out.println("///2///");

		System.out.println(pdto.toString());
		List<FreeBoardDto> list2 = freeBoardService.freeBoardListWithPaging(pdto);

		int total = freeBoardService.freeBoardCount();
		System.out.println("///3///"+total);
		System.out.println("///6///");
		
		mav.setViewName("boardMain");
		mav.addObject("freeBoardList",list2);
		mav.addObject("pageMaker",new PageDto(pdto,total));
	return mav;
	}
	
	@RequestMapping("/freeBoardInsert.ino")
	public String freeBoardInsert(){
		
		return "freeBoardInsert";
	}
	
	@RequestMapping("/freeBoardInsertPro.ino")
	public String freeBoardInsertPro(HttpServletRequest request, FreeBoardDto dto){
		ModelAndView mav = new ModelAndView();
		freeBoardService.freeBoardInsertPro(dto);
		System.out.println("--insert!!--"+dto.toString());
		
		return "redirect:/freeBoardDetail.ino?num="+dto.getNum();
	}
	
	@RequestMapping("/freeBoardDetail.ino")
	public ModelAndView freeBoardDetail(HttpServletRequest request){
		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);
		
		System.out.println(dto.toString());
		
		return new ModelAndView("freeBoardDetail", "freeBoardDto", dto);
	}
	
	@RequestMapping("/freeBoardUpdate.ino")
	public String freeBoardUpdate(HttpServletRequest request,FreeBoardDto dto) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		dto.setTitle(title);
		dto.setContent(content);
		freeBoardService.freeBoardUpdate(dto);
		
		return "redirect:/main.ino";
	}
	
	@RequestMapping("/freeBoardDelete.ino")
	public String freeBoardDelete(HttpServletRequest request){
		int num2 = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num2);
		System.out.println("--delete--"+dto.toString());
		freeBoardService.freeBoardDelete(dto);
		
		return "redirect:/main.ino";
		
	}
}
