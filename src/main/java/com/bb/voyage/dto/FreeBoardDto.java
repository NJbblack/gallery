package com.bb.voyage.dto;

import lombok.Data;

@Data
public class FreeBoardDto {
    private int freeNo;
    private int freeWriterNo; // 세션에서 받아온 멤버 int no를 입력. 이걸 이용해 nickName을 출력하거나, PW확인 실시
    private String freeTitle;
    private String freeContents;
    private String freeRegDate;
    private int freeAvailable;
    private int freeReGroup;
    private int freeReLevel;
    private int freeReStep;
    private int freeHit;
    private int freeNum; // ROWNUM 용 property
}
