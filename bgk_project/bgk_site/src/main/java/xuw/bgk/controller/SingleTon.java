package xuw.bgk.controller;

/**
 * Created by admin on 2017/8/8.
 */
public class SingleTon {
    public static SingleTon instance;
    private SingleTon(){}

    public static SingleTon getInstance(){
        if(instance == null){
            instance = new SingleTon();
        }
        return instance;
    }

}
