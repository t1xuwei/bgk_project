package xuw.bgk.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xuw.bgk.dao.UserMapper;
import xuw.bgk.entity.User;

import javax.annotation.Resource;
import java.lang.reflect.Array;

/**
 * Created by admin on 2017/7/14.
 */
@Controller
public class FirstController {

    @Resource
    private UserMapper userMapper;

    public static void main(String[] args) {
        System.out.println("hello");
        String[] strs = new String[0];
        System.out.println(strs.length);
        for (String str : strs) {
            System.out.println("s");
            System.out.println(str);
        }

        System.out.println(ArrayUtils.isEmpty(strs));
    }

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    @ResponseBody
    public String firstVisit(String userName) {
        User user = userMapper.findByName(userName);
        System.out.println(user.getEmail());
        return "u got me!";
    }

    @RequestMapping(value="firstview")
    public String firstView(){
        return "test";
    }


}
