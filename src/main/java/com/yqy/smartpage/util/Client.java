package com.yqy.smartpage.util;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-07 14:21
 **/
public class Client {
    //设置APPID/AK/SK
    public static final String APP_ID = "16191439";
    public static final String API_KEY = "IjMwRztA3U3boPNKd4u7lMy9";
    public static final String SECRET_KEY = "rs0TB9KaQBLdKfoOghlG8Id61GHetEzz";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "C:\\Users\\好看小哥哥\\Desktop\\QQ截图20190507142309.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }

    public static AipOcr getClient(){
        return new AipOcr(APP_ID, API_KEY, SECRET_KEY);
    }

}
