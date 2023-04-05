package com.bb.voyage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.bb.voyage.dto.MemberDto;

@Mapper
public interface MemberDao {
  public int insertMember(MemberDto memberDto);
  public MemberDto loginMember(MemberDto memberDto);
}
