package xuw.bgk.service.impl;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Service;
import xuw.bgk.dao.UserMapper;
import xuw.bgk.entity.User;
import xuw.bgk.exception.ServiceException;
import xuw.bgk.security.DigestUtils;
import xuw.bgk.service.IUserService;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by xuw on 2017/8/11.
 */
@Service
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User checkPassword(String userName, String password) throws ServiceException {
        try {
            return userMapper.searchByUserNameAndPassword(userName, DigestUtils.md5(DigestUtils.md5(password.getBytes("UTF-8")).getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(0, e.getMessage());
        }
    }

    @Override
    public User searchByUserName(String userName) {
        return userMapper.findByName(userName);
    }

    @Override
    public void insertUser(String userName, String password) throws Exception {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(DigestUtils.md5(DigestUtils.md5(password.getBytes("UTF-8")).getBytes("UTF-8")));
        userMapper.save(user);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] aBytes = "a".getBytes();
        printBytes(aBytes);
        byte[] aBytes2 = "a".getBytes("utf-8");
        printBytes(aBytes2);
        String str = new String(aBytes2,"IBM277");
        System.out.println(str);
    }
    public static void printBytes(byte[] bytes){
        System.out.println("===========");
        for(int i=0;i<bytes.length;i++){
            System.out.print(bytes[i]);
        }
        System.out.println("===========");
    }
}
