package xuw.bgk.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xuw.bgk.dto.ResultJson;
import xuw.bgk.entity.User;
import xuw.bgk.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xuw on 2017/8/11.
 */
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultJson ajaxLogin(String userName, String password, HttpServletRequest request, HttpSession session){
        ResultJson resultJson = new ResultJson();
        resultJson.setStatusCode(ResultJson.STATUS_CODE_FAIL);
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password) )
        {
            return resultJson;
        }
        User user = userService.checkPassword(userName,password);

        return resultJson;
    }

    @RequestMapping(value = "/exit")
    @ResponseBody
    public ResultJson exit(HttpSession session){
        session.invalidate();
        ResultJson resultJson = new ResultJson();
        resultJson.setStatusCode(ResultJson.STATUS_CODE_SUCCESS);
        return resultJson;
    }

}
