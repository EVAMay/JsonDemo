package com.feicui.jsondemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/8/31.
 */
public class ParserGirlImage {
    /**
     * ctime : 2016-03-06 14:11
     * title : 美女旗袍红唇恋上香烟艺术照
     * description : 美女图片
     * picUrl : http://t1.27270.com/uploads/150725/8-150H5153A5D6.jpg
     * url : http://www.27270.com/ent/meinvtupian/2015/51904.html
     */
    //参数列表放入已获得的json字符串
    public static ArrayList<GirlImage> getGirlInfo(String jsonStr){
        ArrayList<GirlImage> list=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(jsonStr);
            JSONArray jsonArray=jsonObject.getJSONArray("newslist");//通过json的键，获得他的数组，然后遍历
            for (int i=0;i<jsonArray.length();i++){
                JSONObject object=jsonArray.getJSONObject(i);//使用一个新的jsonobject来装载遍历出的信息
                //以键值对的方式获取字符串
                String ctime=object.getString("ctime");//时间
                String title=object.getString("title");//标题
                String description=object.getString("description");//描述
                String picUrl=object.getString("picUrl");//图标
                String url=object.getString("url");//跳转的网页链接
                list.add(new GirlImage(ctime,title,description,picUrl,url));//将数据添加到集合中
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}
