package com.bb.gallery.service;
import java.util.List;

import com.bb.gallery.dto.GalleryDto;
import com.bb.gallery.dto.ReplyDto;

public interface GalleryService {
    
  public int insertGallery(GalleryDto galleryDto);
  public List<GalleryDto> getGalleryList();
  public GalleryDto viewGallery(int no);
  public int insertGalleryReply(ReplyDto replyDto);
  public List<ReplyDto> getGalleryReply(int galleryId);
  public void deleteReply(int no);

}
