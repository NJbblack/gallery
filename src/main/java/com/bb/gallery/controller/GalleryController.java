package com.bb.gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bb.gallery.dto.GalleryDto;
import com.bb.gallery.dto.ReplyDto;
import com.bb.gallery.service.GalleryService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/gallery")
public class GalleryController {
    @Autowired
    GalleryService galleryService;
    
    @GetMapping("/list")
    public String list(Model model){
      List galleryList =  galleryService.getGalleryList();
      model.addAttribute("galleryList", galleryList);
        return "gallery/list";
    }
    
    @GetMapping("/insert")
    public String insert(){
        return "gallery/insert";
    }
    @PostMapping("/insertGallery")
    public String insertGallery(GalleryDto galleryDto, RedirectAttributes redirectAttributes){
       int result = galleryService.insertGallery(galleryDto);
       if (result > 0) {
        redirectAttributes.addFlashAttribute("msg", "업로드 완료.");
        return "gallery/list";
      } else {
        redirectAttributes.addFlashAttribute("msg", "에러.");
        return "gallery/list";
      }
    }
    

    @GetMapping("/view/{no}")
    public String view(@PathVariable("no") int no, Model model){
      GalleryDto galleryDto = galleryService.viewGallery(no);
      model.addAttribute("galleryDto", galleryDto);
        return "gallery/view";
    }
    
    @PostMapping("/insertReply")
    @ResponseBody
    public List<ReplyDto> insertReply(ReplyDto replyDto, Model model){
      int result = galleryService.insertGalleryReply(replyDto);
      List<ReplyDto> replyList = galleryService.getGalleryReply(replyDto.getGalleryId());
      if (result > 0) {
        return replyList;

      } else {
        return replyList;
      }
    }

  @PostMapping("/getReply/{no}")
  @ResponseBody
  public List<ReplyDto> getReply(@PathVariable("no") int no) {
    List<ReplyDto> replyList = galleryService.getGalleryReply(no);
    return replyList;
  }


  @GetMapping("/delete")
  public String deleteReply(int no, int galleryId){
    galleryService.deleteReply(no);
    return "redirect:/gallery/view/"+galleryId;
  }
}
