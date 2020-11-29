package com.muc.communityservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespUploadFileVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("文件编号")
    private String fileId;
}
