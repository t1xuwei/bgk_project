package xuw.bgk.test;

/**
 * 主要用来实现一些与数字相关的算法
 * Created by xuw on 2017/8/9.
 */
public class NumberUtil {

    /**
     * 计算一个32位整数中有多少1
     * @return
     */
    public static int get1Number(Integer a){
        int count = 0;
        int flag = 1;
        for(int i=1;i<32;i++){
            if((a & flag) != 0){
                count = count + 1;
            }
            flag <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(get1Number(11));
    }


}
