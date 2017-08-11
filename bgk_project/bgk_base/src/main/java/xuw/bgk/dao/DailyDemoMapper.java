package xuw.bgk.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import xuw.bgk.entity.DailyDemo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuw on 2017/8/9.
 */
@Component(value="dailyDemoMapper")
public interface DailyDemoMapper extends Serializable {

    @Select("select * from tb_daily_demo")
    public List<DailyDemo> searchAll();


}
