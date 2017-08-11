package xuw.bgk.service;

import xuw.bgk.entity.User;

/**
 * Created by xuw on 2017/8/11.
 */
public interface IUserService {
    User checkPassword(String userName, String password);
}
