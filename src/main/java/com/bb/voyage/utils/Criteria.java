package com.bb.voyage.utils;

import lombok.Data;

@Data
public class Criteria {

  private int currentPage;
  private int pageSize;
  private String type;
  private String keyword;

  public Criteria() {
    this.currentPage = 1;
    this.pageSize = 10;
  }

  public int getStartPage() {
    return (currentPage - 1) * pageSize;
  }
}
