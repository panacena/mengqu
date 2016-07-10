package zkk.com.mengqu.home.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class HomeThemeBean {


    /**
     * code : 1
     * data : [{"id":13,"type":3,"name":"绅士","coverImage":"http://qn.18touch.com/uploads/acg201605/1462938141492457.jpg"},{"id":12,"type":3,"name":"腐向","coverImage":"http://qn.18touch.com/uploads/acg201605/1462938151613789.jpg"},{"id":14,"type":3,"name":"扫图","coverImage":"http://qn.18touch.com/uploads/acg201510/1444793517162266.jpg"},{"id":19,"type":3,"name":"同人","coverImage":"http://qn.18touch.com/uploads/acg201601/1451875546152915.jpg"},{"id":23,"type":3,"name":"单行本","coverImage":"http://qn.18touch.com/uploads/acg201605/1462938161707871.jpg"},{"id":3,"type":1,"name":"Love Live!","coverImage":"http://qn.18touch.com/uploads/acg201510/1444788497546942.jpg"},{"id":7,"type":1,"name":"萌系","coverImage":"http://qn.18touch.com/uploads/acg201510/1444788594457237.jpg"},{"id":8,"type":1,"name":"杀必死","coverImage":"http://qn.18touch.com/uploads/acg201605/1462938186226810.jpg"},{"id":16,"type":1,"name":"舰娘","coverImage":"http://qn.18touch.com/uploads/acg201510/1444793559867043.jpg"},{"id":20,"type":1,"name":"恋物癖","coverImage":"http://qn.18touch.com/uploads/acg201602/1456366055175301.jpg"},{"id":21,"type":1,"name":"兽耳","coverImage":"http://qn.18touch.com/uploads/acg201605/1462938209276020.jpg"},{"id":22,"type":1,"name":"制服","coverImage":"http://qn.18touch.com/uploads/acg201605/1462938218526304.jpg"},{"id":4,"type":1,"name":"表情","coverImage":"http://qn.18touch.com/uploads/acg201510/1444793361705945.jpg"},{"id":9,"type":1,"name":"新番","coverImage":"http://qn.18touch.com/uploads/acg201510/1444793396103500.jpg"},{"id":15,"type":1,"name":"足控","coverImage":"http://qn.18touch.com/uploads/acg201605/1462938230663932.jpg"},{"id":18,"type":1,"name":"女生向","coverImage":"http://qn.18touch.com/uploads/acg201510/1444793602706869.jpg"},{"id":17,"type":1,"name":"经典","coverImage":"http://qn.18touch.com/uploads/acg201510/1444793583633907.jpg"},{"id":10,"type":1,"name":"东方","coverImage":"http://qn.18touch.com/uploads/acg201510/1444793414431548.jpg"},{"id":5,"type":1,"name":"V家","coverImage":"http://qn.18touch.com/uploads/acg201510/1444788549971695.jpg"},{"id":11,"type":1,"name":"风景","coverImage":"http://qn.18touch.com/uploads/acg201510/1444793438947446.jpg"},{"id":6,"type":1,"name":"黑子的篮球","coverImage":"http://qn.18touch.com/uploads/acg201510/1444788570215891.jpg"},{"id":2,"type":1,"name":"K project","coverImage":"http://qn.18touch.com/uploads/acg201510/1444788445858304.jpg"}]
     */

    private int code;
    /**
     * id : 13
     * type : 3
     * name : 绅士
     * coverImage : http://qn.18touch.com/uploads/acg201605/1462938141492457.jpg
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int type;
        private String name;
        private String coverImage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }
    }
}
