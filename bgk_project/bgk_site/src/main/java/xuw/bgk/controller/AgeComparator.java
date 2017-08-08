package xuw.bgk.controller;

import xuw.bgk.entity.User;

import java.util.*;

/**
 * Created by admin on 2017/7/21.
 */
public class AgeComparator implements Comparator<User>{

    @Override
    public int compare(User user1, User user2) {
        return user1.getId() >  user2.getId() ? 1 : -1;
    }

    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(2L);
        User user2 = new User();
        user2.setId(85L);
        User user3 = new User();
        user3.setId(15L);
        List<User> list = new ArrayList<User>();
        list.add(user1);list.add(user2);list.add(user3);
        Collections.sort(list, new AgeComparator());
        for(User user:list){
            System.out.println(user.getId());
        }
    }
}
