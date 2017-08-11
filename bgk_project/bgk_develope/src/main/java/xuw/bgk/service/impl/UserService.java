package xuw.bgk.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import xuw.bgk.dao.UserMapper;
import xuw.bgk.entity.User;
import xuw.bgk.service.IUserService;

import javax.annotation.Resource;

/**
 * Created by xuw on 2017/8/11.
 */
@Service
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User checkPassword(String userName, String password) {
        return userMapper.searchByUserNameAndPassword(userName, DigestUtils.md5Digest(password.getBytes()));

    }
}
