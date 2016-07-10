package zkk.com.mengqu.news.bean;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class NewsItemBean {

    private int id;
    private String title;
    private String coverImage;
    private String category;
    private Integer type;  //0:带时间的  1:不带时间的
    private  String time;

    public NewsItemBean() {
    }

    public NewsItemBean(Integer type, int id, String title, String coverImage, String category, String time) {
        this.id = id;
        this.title = title;
        this.coverImage = coverImage;
        this.category = category;
        this.type = type;
        this.time = time;
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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
