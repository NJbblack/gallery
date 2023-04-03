package com.bb.gallery.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bb.gallery.dto.GalleryDto;
import com.bb.gallery.dto.ReplyDto;

@Mapper
public interface GalleryDao {
    public int insertGallery(GalleryDto galleryDto);
    // @Select("SELECT * FROM GALLERY OREDER BY GALLERY")
    public List<GalleryDto> getGalleryList();
    public GalleryDto viewGallery(int no);
    public int insertGalleryReply(ReplyDto replyDto);
    public List<ReplyDto> getGalleryReply(int galleryId);
    public void deleteReply(int no);
}
