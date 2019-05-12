package com.yqy.smartpage;

import com.yqy.smartpage.util.Utils;
import org.junit.Test;
import org.apache.commons.io.FileSystemUtils;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

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

    @Test
    public void test2() throws IOException {
        System.out.println(FileSystemUtils.freeSpaceKb()/1024/1024);
    }

    public static void main(String[] args) {
        OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();
        double cpu = osMxBean.getSystemLoadAverage();
        System.out.println(cpu);
    }


}
