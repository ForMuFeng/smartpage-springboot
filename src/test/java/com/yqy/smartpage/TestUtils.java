package com.yqy.smartpage;

import com.yqy.smartpage.util.Utils;
import org.junit.Test;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-08 23:42
 **/
public class TestUtils {
    @Test
    public void test1(){
        System.out.println(Utils.getMd5("1"));
    }
}
