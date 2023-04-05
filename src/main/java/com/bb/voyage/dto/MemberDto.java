package com.bb.voyage.dto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDto {

int no;
String userId;
String userPw;
String userName;
String userNickname;
String email;
String address;
MultipartFile originalFile;
String originalFilePath; // 프로필 사진 원본 이름
String renamedFilePath;  //  프로필 사진 실제 저장 경로
int userPoint; //  일정 수준 이상의 포인트를 쌓으면 등업. 게시글, 댓글 작성시 +1, 100넘으면 열심, 200넘으면 VIP
int userRank; // 일반회원(0), 열심회원(1), VIP회원(2), 관리자(9)
}
