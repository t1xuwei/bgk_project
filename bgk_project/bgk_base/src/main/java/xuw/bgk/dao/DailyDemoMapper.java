package xuw.bgk.dao;

import org.apache.ibatis.annotations.Select;
import xuw.bgk.entity.DailyDemo;

import java.util.List;

/**
 * Created by xuw on 2017/8/9.
 */
public interface DailyDemoMapper {

    @Select("select * from tb_daily_demo")
    public List<DailyDemo> searchAll();


}
