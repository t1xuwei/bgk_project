package xuw.bgk.entity;

import java.io.Serializable;

/**
 * Created by admin on 2017/7/18.
 */
public class User implements Serializable {

    private Long id;
    private String userName;
    private String password;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getId().equals(((User)obj).getId());
    }
}
