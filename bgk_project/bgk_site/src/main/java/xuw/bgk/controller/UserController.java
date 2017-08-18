package xuw.bgk.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xuw.bgk.dto.ResultJson;
import xuw.bgk.entity.User;
import xuw.bgk.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by xuw on 2017/8/11.
 */
@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultJson ajaxLogin(String userName, String password, HttpServletRequest request, HttpSession session) {
        ResultJson resultJson = new ResultJson();
        resultJson.setStatusCode(ResultJson.STATUS_CODE_FAIL);
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            resultJson.setStatusMessage("用户名和密码不能为空");
            return resultJson;
        }
        try {
            User user = userService.checkPassword(userName, password);
            if (null == user) {
                resultJson.setFailMessage("用户名和密码错误");
                return resultJson;
            }
            resultJson.setSuccessMessage("登录成功！");
            session.setAttribute("user", user);
        } catch (Exception ex) {
            resultJson.setFailMessage(ex.getMessage());
        }
        return resultJson;
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public ResultJson regiester(String userName, String password, String identifyCode, HttpServletRequest request, HttpSession session) {
        ResultJson resultJson = new ResultJson();
        try{
            if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
                resultJson.setFailMessage("用户名或验证码不能为空！");
                return resultJson;
            }
            User user = userService.searchByUserName(userName);
            if(null != user){
                resultJson.setFailMessage("用户名已经被注册！");
                return resultJson;
            }
            userService.insertUser(userName, password);
            resultJson.setSuccessMessage("注册用户成功");
        }catch(Exception e){
            resultJson.setFailMessage("系统异常，注册失败");
        }
        return resultJson;
    }

    @RequestMapping(value = "/exit")
    @ResponseBody
    public ResultJson exit(HttpSession session) {
        session.invalidate();
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccessMessage("成功退出！");
        return resultJson;
    }





}
