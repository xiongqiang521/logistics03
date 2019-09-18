package com.xq.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 图片和BASE64格式相互转换工具类
 * @author Mechrevo
 * @version v1.0
 * 2019/9/16 9:19
 */
public class ImgBase64 {
    private ImgBase64(){}

    /**
     * 将图片转换为BASE64格式，BASE64格式为字符串
     * @param path
     * @return
     */
    public static String imageToBase64(String path) {
        //将图片转化为BASE64格式
        InputStream inputStream = null;

        byte[] bytes = new byte[0];
        try {
            inputStream = new FileInputStream(new File(path));
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BASE64Encoder base = new BASE64Encoder();//BASE64格式处理类
        String encode = base.encode(bytes);//将bytes数组格式转化为BASE64格式
        System.out.println(encode);
        return encode;
    }

    /**
     * BASE64解密转换为字符流
     * @param base64
     * @return
     */
    public static byte[] Base64toByte(String base64) {
        byte[] b = new byte[0];
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            if(null!=base64 && !base64.equals("")){
                b = decoder.decodeBuffer(base64);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
