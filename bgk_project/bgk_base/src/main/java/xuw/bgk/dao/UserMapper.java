package xuw.bgk.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import xuw.bgk.entity.User;

/**
 * Created by wei on 2017/7/18.
 */
@Component(value="userMapper")
public interface UserMapper {

    @Select("select * from tb_user where username=#{username}")
    public User findByName(String username);


    public void save(User user);

    @Update("update tb_user set password=#{password} where username =#{username} ")
    public void changePwdByPhone(@Param(value = "username") String phone, @Param(value = "password") String password);

    @Select("select * from tb_user where username=#{username} and password=#{password}")
    User searchByUserNameAndPassword(@Param(value="username")String username,@Param(value="password") String password);

}
