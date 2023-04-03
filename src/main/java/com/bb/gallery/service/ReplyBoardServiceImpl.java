package com.bb.gallery.service;

import com.bb.gallery.dao.ReplyBoardDao;
import com.bb.gallery.dto.ReplyBoardDto;
import com.bb.gallery.utils.Criteria;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReplyBoardServiceImpl implements ReplyBoardService {

  @Autowired
  ReplyBoardDao replyBoardDao;

  public ReplyBoardServiceImpl() {
    log.info("===========ReplyBoardService=========");
  }

  public int insertBoard(ReplyBoardDto replyBoardDto) {
    replyBoardDto.setReGroup(getMaxReGroup() + 1);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setReStep(1);

    int result = replyBoardDao.insertBoard(replyBoardDto);
    return result;
  }

  public List<ReplyBoardDto> getAllBoardList(
    String category,
    String searchTxt
  ) {
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("category", category);
    hashMap.put("searchTxt", searchTxt);
    List<ReplyBoardDto> boardList = replyBoardDao.getAllBoardList(hashMap);
    return boardList;
  }

  @Override
  public ReplyBoardDto getSelectOne(int no) {
    ReplyBoardDto replyBoardDto = replyBoardDao.getSelectOne(no);
    return replyBoardDto;
  }

  @Override
  public int updateHit(int no) {
    int result = replyBoardDao.updateHit(no);
    return result;
  }

  @Override
  public int getMaxReGroup() {
    int result = replyBoardDao.getMaxReGroup();
    return result;
  }

  @Override
  public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
    int reGroup = replyBoardDto.getReGroup();
    int reLevel = replyBoardDto.getReLevel();
    int reStep = replyBoardDto.getReStep();

    updateReLevel(replyBoardDto);

    replyBoardDto.setReGroup(reGroup);
    replyBoardDto.setReLevel(reLevel + 1);
    replyBoardDto.setReStep(reStep + 1);

    int result = replyBoardDao.insertReplyBoard(replyBoardDto);

    // db에가서 나보다 레벨이 높은 애들은 전부 1증가

    return result;
  }

  public int updateReLevel(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateReLevel(replyBoardDto);
  }

  public int deleteReplyBoard(ReplyBoardDto replyBoardDto) {
    int result = replyBoardDao.deleteReplyBoard(replyBoardDto);
    return result;
  }

  // public List<ReplyBoardDto> getSearchBoardList(String searchTxt) {
  //   List<ReplyBoardDto> boardList = replyBoardDao.getSearchBoardList(searchTxt);
  //   return boardList;
  // }

  public int modifyReplyBoard(ReplyBoardDto replyBoardDto) {
    int result = replyBoardDao.modifyReplyBoard(replyBoardDto);
    return result;
  }

  public ReplyBoardDto getNextSelect(int num) {
    ReplyBoardDto replyBoardDto = replyBoardDao.getNextSelect(num);
    return replyBoardDto;
  }

  public ReplyBoardDto getPrevSelect(int num) {
    ReplyBoardDto replyBoardDto = replyBoardDao.getPrevSelect(num);
    return replyBoardDto;
  }

  public int totalCount(Criteria criteria) {
    return replyBoardDao.totalCount(criteria);
  }
}
