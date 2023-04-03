package com.bb.gallery.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bb.gallery.dao.GalleryDao;
import com.bb.gallery.dto.GalleryDto;
import com.bb.gallery.dto.ReplyDto;

@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    GalleryDao galleryDao;
    @Value("${file.path}")
    private String uploadFolder;

    @Override
    public int insertGallery(GalleryDto galleryDto) {
        UUID uuid = UUID.randomUUID();
        String originalFile = galleryDto.getFile().getOriginalFilename();
        String renamedFile = uuid + "_" + originalFile;
        Path imgFilePath = Paths.get(uploadFolder + renamedFile);
        galleryDto.setOriginal(originalFile);
        galleryDto.setRenamed(renamedFile);
        try {
            Files.write(imgFilePath, galleryDto.getFile().getBytes());
          } catch (IOException e) {
            e.printStackTrace();
          }
          int result = galleryDao.insertGallery(galleryDto);
          return result;
    }

    @Override
    public List<GalleryDto> getGalleryList() {
      List <GalleryDto>  galleryList = galleryDao.getGalleryList();
      return galleryList;
    }

    @Override
    public GalleryDto viewGallery(int no) {
    
      return galleryDao.viewGallery(no);
    }

    @Override
    public int insertGalleryReply(ReplyDto replyDto) {
      int result = galleryDao.insertGalleryReply(replyDto);
      return result;
    }

    @Override
    public List<ReplyDto> getGalleryReply(int galleryId) {
      return galleryDao.getGalleryReply(galleryId);
    }

    @Override
    public void deleteReply(int no) {
      galleryDao.deleteReply(no);
    }    

    
}

