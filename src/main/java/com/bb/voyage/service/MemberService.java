package com.bb.voyage.service;

import com.bb.voyage.dto.MemberDto;

public interface MemberService {
  public int insertMember(MemberDto memberDto);
  public MemberDto loginMember(MemberDto memberDto);
}
