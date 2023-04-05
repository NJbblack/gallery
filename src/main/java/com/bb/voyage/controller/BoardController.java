package com.bb.voyage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bb.voyage.dto.FreeBoardDto;
import com.bb.voyage.dto.MemberDto;
import com.bb.voyage.service.BoardService;
import com.bb.voyage.utils.ScriptWriter;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

  @Autowired
  BoardService boardService;

  @GetMapping("/freeboard")
  public String freeBoard(Model model){
    List<FreeBoardDto> freeList = boardService.getAllFree();
    model.addAttribute("freeList", freeList);
    return "/board/freeboard";
  }
  @GetMapping("/freeboardwrite")
  public String freeBoardWrite() {
    return "/board/freeboardwrite";
  }
  @PostMapping("/freeBoardWrite")
  public String freeBoardWriteProcess(
    FreeBoardDto freeBoardDto,
    RedirectAttributes redirectAttributes, 
    int no
  ) {
    freeBoardDto.setFreeWriterNo(no);
    boardService.insertFreeBoard(freeBoardDto);
    redirectAttributes.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/freeboard";
  }
  @GetMapping("/freeboardview")
  public String freeBoardView(Model model, int no){
    FreeBoardDto freeBoardDto = boardService.getOneFree(no);
    MemberDto memberDto = boardService.getMemberInfo(no);
    model.addAttribute("freeBoardDto", freeBoardDto);
    model.addAttribute("memberDto", memberDto);
    return "/board/freeboardview";
  }
  @GetMapping("/freeboardmodify")
  public String freeBoardModify(Model model, int no) {
    FreeBoardDto freeBoardDto = boardService.getOneFree(no);
    model.addAttribute("freeBoardDto", freeBoardDto);
    return "/board/freeboardmodify";
  }
  @PostMapping("/freeBoardModify")
  public String freeBoardModifyProcess(
    FreeBoardDto freeBoardDto,
    RedirectAttributes redirectAttributes, 
    int no
  ) {
    freeBoardDto.setFreeWriterNo(no);
    log.info("freeBoardDto==={}", freeBoardDto);

    boardService.modifyFreeBoard(freeBoardDto);
    redirectAttributes.addFlashAttribute("msg", "글이 수정되었습니다.");
    return "redirect:/board/freeboard";
  }
  @GetMapping("/freeboarddelete")
  public String freeBoardDeleteProcess(
    RedirectAttributes redirectAttributes, 
    int no
  ) {
    boardService.deleteFreeBoard(no);
    redirectAttributes.addFlashAttribute("msg", "글이 삭제되었습니다.");
    return "redirect:/board/freeboard";
  }

  
}
