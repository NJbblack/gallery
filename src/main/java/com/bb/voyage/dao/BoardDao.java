package com.bb.voyage.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.bb.voyage.dto.FreeBoardDto;
import com.bb.voyage.dto.MemberDto;

@Mapper
public interface BoardDao {
  int insertFreeBoard(FreeBoardDto freeBoardDto);
  List<FreeBoardDto> getAllFree();    
  FreeBoardDto getOneFree(int no);
  MemberDto getMemberInfo(int no);
  int modifyFreeBoard(FreeBoardDto freeBoardDto);
  int deleteFreeBoard(int freeNo);
}

