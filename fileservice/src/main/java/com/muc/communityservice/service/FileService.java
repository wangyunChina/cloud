package com.muc.communityservice.service;

import java.io.InputStream;

public interface FileService {
   public String uploadFile(byte[] fileContent,String fileType,String cid);
   public InputStream readFile(String fileName);
}
