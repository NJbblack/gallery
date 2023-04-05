package com.bb.voyage.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bb.voyage.dto.MemberDto;
import com.bb.voyage.service.MemberService;
import com.bb.voyage.utils.ScriptWriter;

@Controller
@RequestMapping("/member")
public class MemberController {

  @Autowired
  MemberService memberService;

  @GetMapping("/join")
  public String join() {
    return "/member/join";
  }
  @PostMapping("/join")
  public String joinProcess(MemberDto memberDto, HttpServletResponse response) throws IOException{
    int result = memberService.insertMember(memberDto);
    if (result > 0) {
        ScriptWriter.alert(response,"회원가입이 완료되었습니다.");
        return "redirect:/member/login";
      } else {
        ScriptWriter.alertAndBack(response, "다시 시도해 주세요.");
        return null;
      }
  }
  @GetMapping("/login")
  public String login() {
    return "/member/login";
  }

  @PostMapping("/login")
  public String loginProcess(
    MemberDto memberDto,
    RedirectAttributes redirectAttributes,
    HttpServletRequest request,
    HttpServletResponse response
  ) throws IOException {
    MemberDto loggedMember = memberService.loginMember(memberDto);
    if (loggedMember == null) {
      return "redirect:/member/login";
    } else {
      HttpSession session = request.getSession();
      session.setAttribute("loggedMember", loggedMember);
      return "redirect:/member/info";
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
    session.removeAttribute("loggedMember");
    redirectAttributes.addFlashAttribute("msg", "로그아웃되었습니다.");
    return "redirect:/";
  }
}
