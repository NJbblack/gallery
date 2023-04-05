package com.bb.voyage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.voyage.dao.BoardDao;
import com.bb.voyage.dto.FreeBoardDto;
import com.bb.voyage.dto.MemberDto;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;

    public int insertFreeBoard(FreeBoardDto freeBoardDto) {
        return boardDao.insertFreeBoard(freeBoardDto);
    }

    public List<FreeBoardDto> getAllFree() {
        return boardDao.getAllFree();
    }

    public FreeBoardDto getOneFree(int no) {
        return boardDao.getOneFree(no);
    }

    public MemberDto getMemberInfo(int no) {
        return boardDao.getMemberInfo(no);
    }

    @Override
    public int modifyFreeBoard(FreeBoardDto freeBoardDto) {
        return boardDao.modifyFreeBoard(freeBoardDto);
    }

    @Override
    public int deleteFreeBoard(int freeNo) {
        return boardDao.deleteFreeBoard(freeNo);

    }

    
    
    
}
