package me.siyoon.ajaxfileupload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadModel {

    private String extraField;

    private MultipartFile[] files;

    //getters and setters
}
