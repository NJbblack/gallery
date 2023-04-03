package com.bb.gallery.service;

import com.bb.gallery.dao.MemberDao;
import com.bb.gallery.dto.MemberDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberDao memberDao;

  @Value("${file.path}")
  private String uploadFolder;

  // 섬머노트

  public int insertMember(MemberDto memberDto) {
    UUID uuid = UUID.randomUUID();
    // form에서 전달된 파일에서 이름 추출
    String originalFile = memberDto.getOriginalFile().getOriginalFilename();
    // 중복방지용 이름 만들기....
    String renameFile = uuid + "_" + originalFile;
    // 저장되는 경로
    Path imgFilePath = Paths.get(uploadFolder + renameFile); //C:japan/upload/4877832894748372.jpg

    memberDto.setOriginalFilePath(originalFile);
    memberDto.setRenameFilePath(renameFile);

    try {
      Files.write(imgFilePath, memberDto.getOriginalFile().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    int result = memberDao.insertMember(memberDto);
    return result;
  }

  @Override
  public MemberDto loginMember(MemberDto memberDto) {
    MemberDto loginMemberDto = memberDao.loginMember(memberDto);
    return loginMemberDto;
  }
}
