package com.bb.voyage.utils;

import lombok.Data;

@Data
public class PageMaker {

  private Criteria criteria;
  private int total; // 전체 게시물 수
  private int startPage; // 처음 페이지 번호
  private int endPage; // 마지막 페이지 번호
  private int pageBlocks; // 하단에 뿌려질 페이지 번호들 prev 1|2|3|4|5 next
  private boolean prev; // 이전 글이 있는지...
  private boolean next; // 다음 글이 있는지...

  public void setTotalCount(int total) {
    this.total = total;
    makePagination();
  }

  private void makePagination() {
    endPage =
      (int) Math.ceil(criteria.getCurrentPage() / pageBlocks) * pageBlocks;
    startPage = (endPage - pageBlocks) + 1;
    if (startPage <= 0) startPage = 1;
    int tempEndPage = (int) Math.ceil(total / criteria.getPageSize());
    if (tempEndPage < endPage) endPage = tempEndPage;

    prev = startPage == 1 ? false : true;
    next = endPage < tempEndPage ? true : false;
  }
}
