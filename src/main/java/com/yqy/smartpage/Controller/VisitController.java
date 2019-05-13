package com.yqy.smartpage.Controller;

import com.yqy.smartpage.Mapper.VisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: smartpage-springboot
 * @description:访问量相关
 * @author: Mr.Yqy
 * @create: 2019-05-13 19:48
 **/
@CrossOrigin
@RestController
@RequestMapping("visit")
public class VisitController {
    @Autowired
    VisitMapper visitMapper;
    /**
     * 因为过程简单省略了VisitService层
     */
    @RequestMapping("allPV")
    public int allPV(){
        return visitMapper.getAllPV();
    }
    @RequestMapping("todayPV")
    public int todayPV(){
        return visitMapper.getTodayPV();
    }
}
