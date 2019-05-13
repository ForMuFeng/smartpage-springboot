package com.yqy.smartpage.Mapper;

import com.yqy.smartpage.Entity.Visit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-13 19:36
 **/
@Component
public interface VisitMapper {
    @Insert("insert into visit (visit_time,visit_user_id) values (#{visit_time},#{visit_user_id})")
    int getNewVisit(Visit visit);

    @Select("select count(visit_user_id) from visit ")
    int getAllPV();

    @Select("select count(visit_user_id) from visit where visit_time between curdate() and date_sub(curdate(),interval -1 day) ")
    int getTodayPV();
}
