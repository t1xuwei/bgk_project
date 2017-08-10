package xuw.bgk.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xuw.bgk.entity.DailyDemo;
import xuw.bgk.service.DailyDemoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * Created by xuw on 2017/8/9.
 */
@Controller
public class DailyDemoController {

    @Resource
    private DailyDemoService dailyDemoService;

    @RequestMapping("/demo")
    public String demoList(HttpServletRequest request){
        List<DailyDemo> dailyDemos = dailyDemoService.searchAll();
        Collections.shuffle(dailyDemos);
        request.setAttribute("demos",dailyDemos);
        request.setAttribute("demoCount",dailyDemos.size());
        return "view/demo";
    }
}
