package com.bb.gallery.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GalleryDto {
    private int no;
    private String title;
    private String contents;
    private String original;
    private String renamed;
    private MultipartFile file;
    private String originalFilePath;
    private String renamedFilePath; 
}