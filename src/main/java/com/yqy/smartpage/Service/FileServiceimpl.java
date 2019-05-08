package com.yqy.smartpage.Service;

import com.baidu.aip.ocr.AipOcr;
import com.yqy.smartpage.util.Client;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-07 14:46
 **/
@Service
public class FileServiceimpl {

    public ArrayList<String> basicOcr(MultipartFile file) throws IOException {
        JSONArray jsonArray;//结果数组
        AipOcr aipOcr=Client.getClient();
        ArrayList<String> results;//识别结果数组
        jsonArray = aipOcr.basicGeneral(file.getBytes(),new HashMap<>()).getJSONArray("words_result");
        results=new ArrayList<>();
        if(jsonArray.length()>0){
            for(int i=0;i<jsonArray.length();i++){
                JSONObject j=jsonArray.getJSONObject(i);// 遍历 jsonarray 数组，把每一个对象转成 json 对象
                results.add(j.getString("words"));
            }}
        System.out.println(results.size());
        return results;
    }
}
