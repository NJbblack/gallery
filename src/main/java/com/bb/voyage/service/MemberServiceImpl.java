package com.bb.voyage.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bb.voyage.dao.MemberDao;
import com.bb.voyage.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberDao memberDao;
  @Value("${file.path}")
  private String uploadFolder;

  public int insertMember(MemberDto memberDto) {
    UUID uuid = UUID.randomUUID();
    String originalFile = memberDto.getOriginalFile().getOriginalFilename();
    String renameFile = uuid + "_" + originalFile;
    Path imgFilePath = Paths.get(uploadFolder + renameFile); //C:japan/upload/4877832894748372.jpg

    memberDto.setOriginalFilePath(originalFile);
    memberDto.setRenamedFilePath(renameFile);

    try {
      Files.write(imgFilePath, memberDto.getOriginalFile().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    int result = memberDao.insertMember(memberDto);
    return result;
  }

  public MemberDto loginMember(MemberDto memberDto) {
    MemberDto loginMemberDto = memberDao.loginMember(memberDto);
    return loginMemberDto;
  }
}
