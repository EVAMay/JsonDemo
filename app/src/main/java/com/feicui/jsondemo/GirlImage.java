package com.feicui.jsondemo;

/**
 * Created by lenovo on 2016/8/31.
 *  封装类
 */
public class GirlImage {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"美女旗袍红唇恋上香烟艺术照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150725/8-150H5153A5D6.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/51904.html"},{"ctime":"2016-03-06 14:11","title":"性感美女绮里嘉ula比基尼秀","description":"THE美女","picUrl":"/content/images/nopic.png","url":"http://www.the6688.com/rhmeinv/1427.html"},{"ctime":"2016-03-06 14:11","title":"尤物诗朵雅美乳私房照","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_fe9bea92980bb30c7fb9cc3c33c992042-760x500.jpg","url":"http://m.xxxiao.com/321"},{"ctime":"2016-03-06 14:11","title":"混血美女性感内衣大秀丰满双乳翘臀照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150727/8-150HGGA2356.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/49974.html"},{"ctime":"2016-03-06 14:11","title":"刘���希黑色内衣大秀丰满双乳诱人照","description":"美女图片","picUrl":"http://t1.27270.com/uploads/tu/201507/378/slt.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/122561.html"},{"ctime":"2016-03-06 14:11","title":"黛欣霓爆乳野辣写真","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_952ef7f7e44e4bdaf7718d20c99d66ff4-760x500.jpg","url":"http://m.xxxiao.com/647"},{"ctime":"2016-03-06 14:11","title":"嫩模刘嘉琦白色衬衫丁字裤展千娇百媚魅力","description":"美女图片","picUrl":"http://t1.27270.com/uploads/tu/201507/391/slt.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/122766.html"},{"ctime":"2016-03-06 14:11","title":"美女古装尽展古典妖娆风情","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150728/8-150HQ523102A.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/50195.html"},{"ctime":"2016-03-06 14:11","title":"风骚���妇火辣诱人私房写真","description":"美女图片","picUrl":"http://t1.27270.com/uploads/150728/8-150HQ51215939.jpg","url":"http://www.27270.com/ent/meinvtupian/2015/49870.html"},{"ctime":"2016-03-06 14:11","title":"内衣美女斯戴媛Amy 气质性感","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_d5a1d941059621b6367bdd932d513dcc-760x500.jpg","url":"http://m.xxxiao.com/1207"}]
     */


    /**
     * ctime : 2016-03-06 14:11
     * title : 美女旗袍红唇恋上香烟艺术照
     * description : 美女图片
     * picUrl : http://t1.27270.com/uploads/150725/8-150H5153A5D6.jpg
     * url : http://www.27270.com/ent/meinvtupian/2015/51904.html
     */


        private String ctime;//时间
        private String title;//标题
        private String description;//描述
        private String picUrl;//图标
        private String url;//跳转的网址

    @Override
    public String toString() {
        return "GirlImage{" +
                "ctime='" + ctime + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public GirlImage(String ctime, String title, String description, String picUrl, String url) {
        this.ctime = ctime;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
