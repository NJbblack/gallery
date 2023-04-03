package com.bb.gallery.dto;

import lombok.Data;

@Data
public class ReplyBoardDto {

  private int no;
  private String subject;
  private String writer;
  private String password;
  private String regDate;
  private String contents;
  private int available;
  private int reGroup;
  private int reLevel;
  private int reStep;
  private int hit;
  private int num; // ROWNUM 용 property
}
