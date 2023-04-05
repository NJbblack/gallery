package com.bb.voyage.service;

import java.util.List;

import com.bb.voyage.dto.FreeBoardDto;
import com.bb.voyage.dto.MemberDto;

public interface BoardService {
  int insertFreeBoard(FreeBoardDto freeBoardDto);
  List<FreeBoardDto> getAllFree();    
  FreeBoardDto getOneFree(int no);
  MemberDto getMemberInfo(int no);
  int modifyFreeBoard(FreeBoardDto freeBoardDto);
  int deleteFreeBoard(int freeNo);

  

}
