package com.bb.gallery.controller;

import com.bb.gallery.dto.MemberDto;
import com.bb.gallery.service.MemberService;
import com.bb.gallery.utils.ScriptWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

  @Autowired
  MemberService memberService;

  @GetMapping("/login")
  public String login() {
    return "/member/login";
  }

  @PostMapping("/loginProcess")
  public String loginProcess(
    MemberDto memberDto,
    RedirectAttributes redirectAttributes,
    HttpServletRequest request,
    HttpServletResponse response
  ) {
    MemberDto loggedMember = memberService.loginMember(memberDto);
    if (loggedMember == null) {
      return "redirect:/member/login";
    } else {
      HttpSession session = request.getSession();
      redirectAttributes.addFlashAttribute("msg", "로그인 되었습니다.");
      session.setAttribute("loggedMember", loggedMember);
      return "redirect:/";
    }
  }

  @GetMapping("/info")
  public String info() {
    return "/member/info";
  }

  @GetMapping("/logout")
  public String logout(
    HttpServletRequest request,
    RedirectAttributes redirectAttributes,
    HttpServletResponse response
  ) {
    HttpSession session = request.getSession();
    //session.invalidate();
    session.removeAttribute("loggedMember");
    redirectAttributes.addFlashAttribute("msg", "로그아웃되었습니다.");
    return "redirect:/";
  }

  @GetMapping("/join")
  public String join(Model model) {
    model.addAttribute("memberDto", new MemberDto());
    return "/member/join";
  }

  @PostMapping("/join")
  public String joinProcess(
    @Valid MemberDto memberDto,
    BindingResult bindingResult,
    RedirectAttributes redirectAttributes,
    HttpServletResponse response,
    Model model
  ) throws IOException {
    int result = memberService.insertMember(memberDto);
    if (bindingResult.hasErrors()) {
      return "/member/join";
    } else {
      if (result > 0) {
        redirectAttributes.addFlashAttribute("msg", "회원가입 되었습니다.");
        return "redirect:/member/login";
      } else {
        ScriptWriter.alertAndBack(response, "다시 시도해 주세요.");
        return null;
      }
    }
  }
}
