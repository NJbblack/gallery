package com.bb.gallery.dao;

import com.bb.gallery.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
  public int insertMember(MemberDto memberDto);

  public MemberDto loginMember(MemberDto memberDto);
}
