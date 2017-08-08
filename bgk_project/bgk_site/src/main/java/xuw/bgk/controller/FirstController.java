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
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by admin on 2017/7/14.
 */
@Controller
public class FirstController {

    @Resource
    private UserMapper userMapper;

    public static void main(String[] args) {
//        String[] strs = new String[3];
//        strs[0] = "sss";
//        System.out.println(strs.length);
//        System.out.println("end");
       /* @Override
        public boolean equals(Object obj) {
            return this.getId().equals(((User)obj).getId());
        }*/
        User u1 = new User();
        u1.setId(1L);
        User u2 = new User();
        u2.setId(1L);
        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());
        System.out.println(u1.equals(u2));
        Map m = new HashMap();

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



