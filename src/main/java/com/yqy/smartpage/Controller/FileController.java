package com.yqy.smartpage.Controller;

import com.yqy.smartpage.Service.FileServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-07 14:36
 **/
@RestController
@CrossOrigin
public class FileController {

    @Autowired
    FileServiceimpl fileServiceimpl;
    @RequestMapping("ocr")
    @ResponseBody
    public ArrayList<String> basicOcr(MultipartFile file) throws IOException {
        ArrayList<String> result=fileServiceimpl.basicOcr(file);
        return result;
    }
}
