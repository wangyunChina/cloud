package com.muc.communityservice.controller;

import com.muc.communityservice.consts.FileContentTypeEnum;
import com.muc.communityservice.consts.RetEnum;
import com.muc.communityservice.model.RespUploadFileVo;
import com.muc.communityservice.model.Result;
import com.muc.communityservice.model.ResultGenerator;
import com.muc.communityservice.service.FileService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file/api")
@Slf4j
public class FileController extends BaseController{
    @Autowired
    private FileService fileService;
    @Value("${file.security}")
    private String fileSecurity;
    @Value("${file.size}")
    private long fileSize;
    @ApiOperation(value = "上传文件",notes = "只能上传jpg,jpeg,gif,png,word,pdf,m4a,mp3,mp4格式的文件！")
    @PostMapping(value = "/open/v1/upload_file")
    public Result<RespUploadFileVo> uploadPhoto(@RequestBody MultipartFile fileName) throws IOException {
        Result ret = new Result();
        if (fileName == null) {
            return ResultGenerator.genErrorResult(RetEnum.PARAM_ERROR.getCode(),RetEnum.PARAM_ERROR.getMessage());
        }
        if (fileName.getSize() > fileSize) {

            return ResultGenerator.genErrorResult(RetEnum.FILE_SIZE_ERROR.getCode(),RetEnum.FILE_SIZE_ERROR.getMessage());
        }
        //获取文件后缀
        String suffix = fileName.getOriginalFilename().substring(fileName.getOriginalFilename().lastIndexOf(".") + 1, fileName.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png,word,pdf,m4a,mp3,mp4,avi".toUpperCase().contains(suffix.toUpperCase())) {
            return ret;
        }
        byte[] buffer=new byte[1024];
        int n;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        InputStream inputStream =fileName.getInputStream();
        while ((n = inputStream.read(buffer)) != -1)
        {
            bos.write(buffer, 0, n);
        }
        try{
        String fileid = fileService.uploadFile(bos.toByteArray(),suffix,getCopId());
        if(StringUtils.isNotBlank(fileid)){
           RespUploadFileVo respUploadFileVo= new RespUploadFileVo();
           respUploadFileVo.setFileId(fileid);
            return ResultGenerator.genSuccessResult(respUploadFileVo);
        }}
        catch (Exception e)
        {
            log.error("file upload failed {}",e.getMessage());
        }
        return ResultGenerator.genErrorResult(RetEnum.INTERNAL_ERROR.getCode(), RetEnum.INTERNAL_ERROR.getMessage());

    }
    @ApiOperation(value = "文件读取",notes = "只能上传jpg,jpeg,gif,png,word,pdf,m4a,mp3,mp4格式的文件！")
    @GetMapping(value = "/open/v1/file/{fileName}")
    public void uploadPhoto(@PathVariable String fileName, HttpServletResponse response) throws IOException {
       String sufix = fileName.substring(26);
       response.setContentType( FileContentTypeEnum.valueOf(sufix).getType());
        IOUtils.copy(fileService.readFile(fileName),response.getOutputStream());
    }
}
