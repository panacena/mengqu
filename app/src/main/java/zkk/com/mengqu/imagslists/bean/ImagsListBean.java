package zkk.com.mengqu.imagslists.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class ImagsListBean {


    /**
     * code : 1
     * id : 13107
     * title : 4月新番代号D机关 ED卡全 东京和美男的十二景
     * like : 49
     * liked : 0
     * fileName : acg131071466996963
     * coverImage : http://7viibj.com2.z0.glb.qiniucdn.com/13107_8_1466996980842_w1280_h720_s438723.jpg?imageView2/1/w/830/q/95%7cimageMogr2/crop/!733x389a97a19/
     * pan : http://pan.baidu.com/s/1bPg0Gm
     * panPw : stvh
     * cp :
     * images : ["http://7viibj.com2.z0.glb.qiniucdn.com/13107_8_1466996980842_w1280_h720_s438723.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_9_1466996980842_w1280_h720_s371448.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_1_1466996980839_w1280_h720_s322249.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_10_1466996980921_w1280_h720_s346673.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_3_1466996980840_w1280_h720_s320292.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_11_1466996980921_w1280_h720_s370419.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_6_1466996980841_w1280_h720_s152682.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_7_1466996980842_w1280_h720_s220287.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_12_1466996980973_w1280_h720_s501410.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_2_1466996980840_w1280_h720_s152078.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_4_1466996980841_w1280_h720_s141373.jpg","http://7viibj.com2.z0.glb.qiniucdn.com/13107_5_1466996980841_w1280_h720_s141313.jpg"]
     */

    private int code;
    private int id;
    private String title;
    private int like;
    private int liked;
    private String fileName;
    private String coverImage;
    private String pan;
    private String panPw;
    private String cp;
    private List<String> images;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPanPw() {
        return panPw;
    }

    public void setPanPw(String panPw) {
        this.panPw = panPw;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
