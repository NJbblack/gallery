package com.bb.gallery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDto {

  private int no;

  private String regDate;

  @NotBlank
  @Size(min = 3, max = 20, message = "id는 5글자 이상 20 글자 이하여야 합니다.")
  private String userId;

  @NotBlank(message = "필수 입력사항입니다.")
  @Size(
    min = 3,
    max = 20,
    message = "패스워드는 5글자 이상 20 글자 이하여야 합니다."
  )
  // @Pattern(
  //   regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
  //   message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요."
  // )
  private String userPw;

  // @Email(message = "이메일 형식을 확인해 주세요.")
  // @Pattern(
  //   regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$",
  //   message = "이메일 형식이 올바르지 않습니다."
  // )
  private String email;

  @NotBlank(message = "필수입력사항입니다.")
  @Size(min = 3, max = 20, message = "id는 5글자 이상 20 글자 이하여야 합니다.")
  private String userName;

  private MultipartFile originalFile; // 진짜 파일...

  private String originalFilePath; // 원본 파일이름...
  private String renameFilePath; // 진짜 파일이 저장되는 경로+변경된 파일 이름
}
