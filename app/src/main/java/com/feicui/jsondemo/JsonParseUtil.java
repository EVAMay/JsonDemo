package com.feicui.jsondemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lenovo on 2016/8/30.
 */
public class JsonParseUtil {
    private static String httpUrl="http://apis.baidu.com/txapi/mvtp/meinv";
    private static String httpArg="num=10";

    public static String getJsonData(){
        String url=httpUrl+"?"+httpArg;
//        String jsonData="";//请求服务器返回的Json字符串数据
//        InputStreamReader is=null;//输入字符流读取内容
        StringBuffer sb=new StringBuffer();
        try {
            URL urlPath=new URL(url);
            //默认是Get请求,如果要使用Post请求，需要对HttpURLConnection做一些配置，
            // 得到数据后记得关闭流和断开网络链接。
            HttpURLConnection connection= (HttpURLConnection) urlPath.openConnection();//建立网络连接，获取输入流
            connection.setRequestMethod("GET");
            connection.setRequestProperty("apikey","d3158ef53f08a4cb2478a73d4630441c");
            connection.connect();
            connection.setConnectTimeout(5000);

            InputStream is=connection.getInputStream();

            byte b[]=new byte[1024];
            int len=0;
            while ((len=is.read(b))!=-1){
                sb.append(new String(b,0,len));
            }
            is.close();//使用流之后需关流，以免造成内存泄漏
            connection.disconnect();//断开网络连接
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return  sb.toString();
    }
}
