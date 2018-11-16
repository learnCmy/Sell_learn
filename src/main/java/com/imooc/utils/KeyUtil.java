package com.imooc.utils;


import java.util.Random;

/**
 * Created by 廖师兄
 * 2017-06-11 19:12
 */
public class KeyUtil {

    private static String TWITTER_ID="tk_";

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }


    public static synchronized String  genTkUniquekey(){
        return TWITTER_ID+UUIDUtils.generateShortUuid();

    }


    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            System.out.println(genTkUniquekey().toLowerCase());
        }

    }
}
