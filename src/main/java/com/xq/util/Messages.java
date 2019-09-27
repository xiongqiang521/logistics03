package com.xq.util;



import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;


public class Messages {

    public  String Messages(String tel){
        String host = "http://yzxyx.market.alicloudapi.com";
        String path = "/yzx/marketSms";
        String method = "POST";
        String appcode = "ce9b7f1e6d194bbf813e61ea4f42e833";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //验证码随机数
        Integer codes=(int)((Math.random() * 9 + 1) * 100000);
      String  code = Integer.toString(codes);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("phone", tel);
        querys.put("templateId", "TP19092626");
        querys.put("variable", "code:"+code);
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }
}
