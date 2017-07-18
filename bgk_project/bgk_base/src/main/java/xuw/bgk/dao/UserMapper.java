package xuw.bgk.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xuw.bgk.entity.User;

/**
 * Created by wei on 2017/7/18.
 */

public interface UserMapper {

    @Select("select * from tb_user where username=#{username}")
    public User findByName(String username);

    //注意自动增长主键时的方法不用有返回�??
    public void save(User account);

    @Update("update tb_user set password=#{password} where username =#{username} ")
    public void changePwdByPhone(@Param(value = "username") String phone, @Param(value = "password") String password);
}
