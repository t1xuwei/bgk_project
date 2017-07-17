package xuw.bgk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by wei on 2015/7/29.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "/pwd", method = RequestMethod.GET)
    @ResponseBody
    public String resetSend(String phone) {


        return "success";
    }


}
