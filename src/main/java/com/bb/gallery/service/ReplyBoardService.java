package com.bb.gallery.service;

import com.bb.gallery.dto.ReplyBoardDto;
import com.bb.gallery.utils.Criteria;
import java.util.HashMap;
import java.util.List;

public interface ReplyBoardService {
  public int insertBoard(ReplyBoardDto replyBoardDto);

  public List<ReplyBoardDto> getAllBoardList(String category, String searchTxt);

  public ReplyBoardDto getSelectOne(int no);

  public int updateHit(int no);

  public int getMaxReGroup();

  public int insertReplyBoard(ReplyBoardDto replyBoardDto);

  public int updateReLevel(ReplyBoardDto replyBoardDto);

  public int deleteReplyBoard(ReplyBoardDto replyBoardDto);

  //public List<ReplyBoardDto> getSearchBoardList(String searchTxt);

  public int modifyReplyBoard(ReplyBoardDto replyBoardDto);

  public ReplyBoardDto getPrevSelect(int num);

  public ReplyBoardDto getNextSelect(int num);

  public int totalCount(Criteria criteria);
}
