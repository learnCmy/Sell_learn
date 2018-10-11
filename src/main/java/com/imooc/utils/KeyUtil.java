package com.imooc.utils;


import java.util.Random;

/**
 * Created by 廖师兄
 * 2017-06-11 19:12
 */
public class KeyUtil {

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


    /**
     * 生成普通用户uid:u+当前毫秒数+三位随机数
     * @return
     * */
    public static String createUid(){
        long time=System.currentTimeMillis();
        String s=getCharAndNumr(3);
        return "u"+time+s;
    }

    /**
     * java生成随机数字和字母组合
     *
     * @param length
     * @return
     */
    public static String getCharAndNumr(int length) {
        String val = "tk_";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            String charAndNumr = getCharAndNumr(6);
            System.out.println(charAndNumr);
        }
    }
}
