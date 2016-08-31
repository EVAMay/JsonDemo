package com.feicui.jsondemo.util;

/**
 * Created by lenovo on 2016/8/31.
 */
public class ImageUtil {
    private static ImageUtil instance;
    private ImageUtil(){

    }
    public static ImageUtil getInstance(){
        if (instance==null){


            if (instance==null){
                instance=new ImageUtil();
            }
        }
        return instance;
    }
}
