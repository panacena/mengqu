package zkk.com.mengqu.game.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class GoodThemeBean {

    /**
     * code : 1
     * data : [{"id":"751054","title":"萌聚手游周速报第17期 打发时间的神器","coverImage":"http://qn.18touch.com//uploads/acg201606/1464937260669513.jpg","category":"手游专栏","postTime":1464937269},{"id":"750983","title":"《VOEZ》能否成为第三代音游霸主？浅谈雷亚音游的进化史","coverImage":"http://qn.18touch.com//uploads/acg201605/1464345965909891.jpg","category":"手游专栏","postTime":1464345989},{"id":"750980","title":"战姬的肌肉谁能不服？让你心跳不已的金刚芭比","coverImage":"http://qn.18touch.com//uploads/acg201605/1464343016535817.png","category":"手游专栏","postTime":1464343040},{"id":"750974","title":"萌聚手游周速报第16期 国产手游也有豪华声优阵","coverImage":"http://qn.18touch.com//uploads/acg201605/1464318927721667.jpg","category":"手游专栏","postTime":1464318956},{"id":"750928","title":"《偶像梦幻祭》的组合有哪些？八大偶像组合全介绍","coverImage":"http://qn.18touch.com//uploads/acg201605/1464084175490565.jpg","category":"手游专栏","postTime":1464084314},{"id":"750925","title":"超越时空的阴X阳幻想 和风满满《阴阳师》参上！","coverImage":"http://qn.18touch.com//uploads/acg201605/1464163997109567.jpg","category":"手游专栏","postTime":1464083051},{"id":"750893","title":"寻找《少女前线》里的十大隐藏巨乳！","coverImage":"http://qn.18touch.com//uploads/acg201605/1463740863841733.jpg","category":"手游专栏","postTime":1463740884},{"id":"750873","title":"萌聚手游周速报第15期 日式RPG经久不衰","coverImage":"http://qn.18touch.com//uploads/acg201605/1463650362346339.jpg","category":"手游专栏","postTime":1463650380},{"id":"750872","title":"当热情似火的美少女遇上冰冷的装甲 极限诱惑就此迸发","coverImage":"http://qn.18touch.com//uploads/acg201605/1463647183244012.png","category":"手游专栏","postTime":1463652966},{"id":"750803","title":"萌聚手游周速报第14期 经典动漫IP涌现","coverImage":"http://qn.18touch.com//uploads/acg201605/1463133054555747.jpg","category":"手游专栏","postTime":1463133154},{"id":"750788","title":"甜死人不偿命！单身狗笑看\u201c黑衣剑士\u201d桐人夫妇秀恩爱","coverImage":"http://qn.18touch.com//uploads/acg201605/1463048217196998.jpg","category":"手游专栏","postTime":1463047398},{"id":"750769","title":"最新一波国产的绝对领域 朦胧战地的极限","coverImage":"http://qn.18touch.com//uploads/acg201605/1462961188239370.png","category":"手游专栏","postTime":1462961189},{"id":"750661","title":"萌聚手游周速报第13期 动次打次嗨起来","coverImage":"http://qn.18touch.com//uploads/acg201605/1462441776897496.jpg","category":"手游专栏","postTime":1462441810},{"id":"750568","title":"萌聚手游周速报第12期 节操是什么能吃吗","coverImage":"http://qn.18touch.com//uploads/acg201604/1461834588850598.jpg","category":"手游专栏","postTime":1461835005},{"id":"750544","title":"《刀剑乱舞》日服新活动\u201c战力扩充计划\u201d玩法详解","coverImage":"http://qn.18touch.com//uploads/acg201604/1461746805193781.png","category":"手游专栏","postTime":1461747583},{"id":"750536","title":"《钢铁少女》考古之战列舰篇\u2014\u2014长门","coverImage":"http://qn.18touch.com//uploads/acg201604/1461751939719579.jpg","category":"手游专栏","postTime":1461723404},{"id":"750496","title":"突破次元壁！二次元中哪种方式会让你心跳加速？","coverImage":"http://qn.18touch.com//uploads/acg201604/1461342193519699.jpg","category":"手游专栏","postTime":1461319812},{"id":"750488","title":"萌聚手游周速报第11期 脸盲症的特效药方","coverImage":"http://qn.18touch.com//uploads/acg201604/1461296750490774.jpg","category":"手游专栏","postTime":1461296854},{"id":"750450","title":"驾驶了21年初号机的少男少女 你为EVA信仰充值了吗","coverImage":"http://qn.18touch.com//uploads/acg201604/1461058842185631.png","category":"手游专栏","postTime":1461144957},{"id":"750412","title":"萌聚手游周速报第10期 动漫改编玩出新花样","coverImage":"http://qn.18touch.com//uploads/acg201604/1460714379679211.jpg","category":"手游专栏","postTime":1460714438}]
     */

    private int code;
    /**
     * id : 751054
     * title : 萌聚手游周速报第17期 打发时间的神器
     * coverImage : http://qn.18touch.com//uploads/acg201606/1464937260669513.jpg
     * category : 手游专栏
     * postTime : 1464937269
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
        private String id;
        private String title;
        private String coverImage;
        private String category;
        private int postTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public int getPostTime() {
            return postTime;
        }

        public void setPostTime(int postTime) {
            this.postTime = postTime;
        }
    }
}
