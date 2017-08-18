package xuw.bgk.service;

import xuw.bgk.entity.User;
import xuw.bgk.exception.ServiceException;

import java.io.UnsupportedEncodingException;

/**
 * Created by xuw on 2017/8/11.
 */
public interface IUserService {
    User checkPassword(String userName, String password) throws ServiceException;

    User searchByUserName(String userName);

    void insertUser(String userName, String password) throws Exception;
}
