package com.muc.communityservice.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileContentTypeEnum {
    JPG("image/jpeg"),
    JPEG("image/jpeg"),
    GIF("image/gif"),
    PNG("image/png"),
    WORD(""),
    PDF("application/pdf"),
    M4A("audio/mp4;charset=UTF-8"),
    MP3("audio/mpeg"),
    MP4("video/mp4"),
    AVI("video/x-msvideo");
    private String type;
}
