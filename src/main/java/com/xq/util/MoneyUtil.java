package com.xq.util;

/**
 * @ProjectName: logistics03
 * @Package: com.xq.util
 * @ClassName: MoneyUtil
 * @Author: yaoxiaolei
 * @Description: ${description}
 * @Date: 2019/9/20 16:20
 * @Version: 1.0
 */
public class MoneyUtil {
    private MoneyUtil(){}
    public static double getMoney(double weight){
        if (weight<=1){
            return 20;
        }else {
            return (weight - 1) * 14 + 20;
        }
    }
}
