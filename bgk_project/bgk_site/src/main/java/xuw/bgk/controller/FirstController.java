package xuw.bgk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2017/7/14.
 */
@Controller
public class FirstController {

    public static void main(String[] args) {
        System.out.println("hello");
    }

    @RequestMapping(value="/first",method= RequestMethod.GET)
    @ResponseBody
    public String firstVisit(){
        System.out.println("hhh");
        return "u got me!";
    }

}
