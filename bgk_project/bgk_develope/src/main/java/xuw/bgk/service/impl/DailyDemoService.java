package xuw.bgk.service.impl;

import org.springframework.stereotype.Service;
import xuw.bgk.dao.DailyDemoMapper;
import xuw.bgk.entity.DailyDemo;
import xuw.bgk.service.IDailyDemoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xuw on 2017/8/9.
 */
@Service
public class DailyDemoService implements IDailyDemoService {
    @Resource
    private DailyDemoMapper dailyDemoMapper;


    public List<DailyDemo> searchAll() {
        return dailyDemoMapper.searchAll();
    }
}
