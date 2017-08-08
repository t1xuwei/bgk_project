package xuw.bgk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/8.
 */
public class DataDictionary {
    private static List<String> demoList = new ArrayList<String>();

    static{
        demoList.add("单例模式(饿汉式懒汉式,注意懒汉式线程安全)");
        demoList.add("请写出死锁的demo");
        demoList.add("计算两个有序数列的交集");
        demoList.add("链表的实现");
    }

    public static List<String> getDemoList(){
        return demoList;
    }

}
