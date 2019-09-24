package com.xq.util;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/22 8:22
 */
public class IntegerIDUtils {

    private IntegerIDUtils(){}
    private static volatile Integer num=1;



    public static Integer creatID(){
        String data = TimeUtils.getDateToString().replaceAll("-", "");
        int dataInt = Integer.parseInt(data);

        synchronized (num){
            num++;
        }


        return dataInt*10000+num^1024;
    }

}
