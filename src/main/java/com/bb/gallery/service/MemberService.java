package com.bb.gallery.service;

import com.bb.gallery.dto.MemberDto;

public interface MemberService {
  public int insertMember(MemberDto memberDto);

  public MemberDto loginMember(MemberDto memberDto);
}
