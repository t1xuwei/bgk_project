package xuw.bgk.service;

import org.springframework.stereotype.Service;
import xuw.bgk.dao.DailyDemoMapper;
import xuw.bgk.entity.DailyDemo;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xuw on 2017/8/9.
 */
public interface IDailyDemoService {
    public List<DailyDemo> searchAll();
}
