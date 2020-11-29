package com.muc.communityservice.service.impl;

import com.muc.communityservice.entity.File;
import com.muc.communityservice.mappers.FileMapper;
import com.muc.communityservice.service.FileService;
import com.muc.communityservice.util.SecureRandomUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;
    @Value("${fileservice.system.name}")
    private String systemName;

    @Override
    @Transactional
    public String uploadFile(byte[] fileContent,String fileType,String cid) {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fileId = getFileId(systemName,fileType);
        File file = File.builder()
                .id(fileId)
                .fileContent(fileContent)
                .createby(cid)
                .createTime(LocalDateTime.now().format(formatter))
                .build();
        fileMapper.insert(file);
        return fileId;
    }

    @Override
    public InputStream readFile(String fileName ) {

      File file =fileMapper.selectById(fileName);
        InputStream inputStream = new ByteArrayInputStream(file.getFileContent());
        return inputStream;
    }

    private String getFileId(String operateorId,String fileType) {
        SecureRandomUtil random = new SecureRandomUtil();
        StringBuilder sb = new StringBuilder();
        sb.append(operateorId);
        sb.append(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(fileType.toUpperCase());
        return sb.toString();

    }
}
