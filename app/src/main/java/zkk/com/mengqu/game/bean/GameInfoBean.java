package zkk.com.mengqu.game.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class GameInfoBean {


    /**
     * code : 1
     * carousel : {"data":[]}
     * post : {"data":[{"type":"post","time":1467216000,"list":[{"id":751426,"title":"大人气手游《ICHU偶像进行曲》7月8日双端上线！恋爱偶像为你甜蜜开唱~","coverImage":"http://qn.18touch.com//uploads/acg201606/1467282291937094.jpg","category":"国内手游"},{"id":751424,"title":"令人失望的现代阴阳师物语 《御灵录》评测","coverImage":"http://qn.18touch.com//uploads/acg201606/1467281744340031.jpg","category":"手游评测"},{"id":751418,"title":"20年经典战斗重燃《犬夜叉-觉醒》今日开启觉醒测试","coverImage":"http://qn.18touch.com//uploads/acg201606/1467271563461822.jpg","category":"国内手游"},{"id":751417,"title":"为了世界和平 \u201c冰美人\u201dKP31入驻《少女前线》","coverImage":"http://qn.18touch.com//uploads/acg201606/1467271033365407.jpg","category":"国内手游"},{"id":751416,"title":"《超级女声》手游今日首发 快来零距离调教超女吧~","coverImage":"http://qn.18touch.com//uploads/acg201606/1467270593790447.jpg","category":"国内手游"},{"id":751414,"title":"闪瞎的声优阵容！DMM x Rejet新作和风页游《一血卍傑 -ONLINE- 》开始事前登录","coverImage":"http://qn.18touch.com//uploads/acg201606/1467269809910299.png","category":"事前登录"},{"id":751412,"title":"全民皆勇者 《艾德尔冒险》天空竞技场大乱斗","coverImage":"http://qn.18touch.com//uploads/acg201606/1467256262824024.jpg","category":"国内手游"}]},{"type":"post","time":1467129600,"list":[{"id":751404,"title":"绅士向卡牌手游《限界凸骑 怪物卡片NAKED》安卓版配信开始","coverImage":"http://qn.18touch.com//uploads/acg201606/1467192224590387.jpg","category":"日系手游"},{"id":751401,"title":"休闲RPG手游《无限RPG 无尽的任务》开始事前登录","coverImage":"http://qn.18touch.com//uploads/acg201606/1467183352963183.jpg","category":"事前登录"},{"id":751400,"title":"歌姬与妖の觉醒！《神威启示录》乖离MA联动角色曝光","coverImage":"http://qn.18touch.com//uploads/acg201606/1467181459423991.jpg","category":"国内手游"},{"id":751398,"title":"《战场双马尾》大爆料！萌军新成员一览","coverImage":"http://qn.18touch.com//uploads/acg201606/1467172247970304.jpg","category":"国内手游"}]},{"type":"post","time":1467043200,"list":[{"id":751392,"title":"手游《智龙迷城》将与漫画《浪客剑心》展开联动合作活动","coverImage":"http://qn.18touch.com//uploads/acg201606/1467109589301907.jpg","category":"日系手游"},{"id":751390,"title":"刀剑神域改编RPG手游新作《刀剑神域 记忆碎片》开始事前登录","coverImage":"http://qn.18touch.com//uploads/acg201606/1467103202561722.jpg","category":"日系手游"},{"id":751385,"title":"UMP45、9A91参上！《少女前线》新枪娘曝光","coverImage":"http://qn.18touch.com//uploads/acg201606/1467098426532369.jpg","category":"国内手游"},{"id":751384,"title":"手游《永恒星语》 独创五星转盘对战","coverImage":"http://qn.18touch.com//uploads/acg201606/1467097746153839.jpg","category":"国内手游"},{"id":751382,"title":"日本霸榜RPG来袭 《战斗吧蘑菇君》终极测试即将开启","coverImage":"http://qn.18touch.com//uploads/acg201606/1467095312319542.jpg","category":"国内手游"},{"id":751381,"title":"手游《家庭教师REBORN》动漫原画大换血","coverImage":"http://qn.18touch.com//uploads/acg201606/1467094805653886.jpg","category":"国内手游"},{"id":751378,"title":"休闲手游新作《收集！轻松熊》配信开始","coverImage":"http://qn.18touch.com//uploads/acg201606/1467084418389474.jpg","category":"日系手游"}]},{"type":"post","time":1466956800,"list":[{"id":751373,"title":"乙女向改编音乐手游《惊鸿骑士杰克斯 青与红的狂诗曲》开始事前登录","coverImage":"http://qn.18touch.com//uploads/acg201606/1467019225266508.jpg","category":"事前登录"},{"id":751372,"title":"《少女前线》7月7日上架iOS 预约投票今日开启","coverImage":"http://qn.18touch.com//uploads/acg201606/1467017307866109.jpg","category":"国内手游"},{"id":751364,"title":"舰娘系统手游《萌娘契约》7月6日即将震撼首发","coverImage":"http://qn.18touch.com//uploads/acg201606/1467009421857741.png","category":"国内手游"},{"id":751362,"title":"哪个枪娘最能顶? 《少女前线》实用SMG推荐","coverImage":"http://qn.18touch.com//uploads/acg201606/1466998300359818.jpg","category":"手游专栏"},{"id":751361,"title":"B站独家代理手游《幻游猎人》正式开启预约","coverImage":"http://qn.18touch.com//uploads/acg201606/1466996986792552.jpg","category":"国内手游"},{"id":751359,"title":"史诗RPG手游《苍之骑士团》夏季上映","coverImage":"http://qn.18touch.com//uploads/acg201606/1466995901822812.jpg","category":"国内手游"}]}]}
     */

    private int code;
    private CarouselBean carousel;
    private PostBean post;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CarouselBean getCarousel() {
        return carousel;
    }

    public void setCarousel(CarouselBean carousel) {
        this.carousel = carousel;
    }

    public PostBean getPost() {
        return post;
    }

    public void setPost(PostBean post) {
        this.post = post;
    }

    public static class CarouselBean {
        private List<?> data;

        public List<?> getData() {
            return data;
        }

        public void setData(List<?> data) {
            this.data = data;
        }
    }

    public static class PostBean {
        /**
         * type : post
         * time : 1467216000
         * list : [{"id":751426,"title":"大人气手游《ICHU偶像进行曲》7月8日双端上线！恋爱偶像为你甜蜜开唱~","coverImage":"http://qn.18touch.com//uploads/acg201606/1467282291937094.jpg","category":"国内手游"},{"id":751424,"title":"令人失望的现代阴阳师物语 《御灵录》评测","coverImage":"http://qn.18touch.com//uploads/acg201606/1467281744340031.jpg","category":"手游评测"},{"id":751418,"title":"20年经典战斗重燃《犬夜叉-觉醒》今日开启觉醒测试","coverImage":"http://qn.18touch.com//uploads/acg201606/1467271563461822.jpg","category":"国内手游"},{"id":751417,"title":"为了世界和平 \u201c冰美人\u201dKP31入驻《少女前线》","coverImage":"http://qn.18touch.com//uploads/acg201606/1467271033365407.jpg","category":"国内手游"},{"id":751416,"title":"《超级女声》手游今日首发 快来零距离调教超女吧~","coverImage":"http://qn.18touch.com//uploads/acg201606/1467270593790447.jpg","category":"国内手游"},{"id":751414,"title":"闪瞎的声优阵容！DMM x Rejet新作和风页游《一血卍傑 -ONLINE- 》开始事前登录","coverImage":"http://qn.18touch.com//uploads/acg201606/1467269809910299.png","category":"事前登录"},{"id":751412,"title":"全民皆勇者 《艾德尔冒险》天空竞技场大乱斗","coverImage":"http://qn.18touch.com//uploads/acg201606/1467256262824024.jpg","category":"国内手游"}]
         */

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String type;
            private String time;
            /**
             * id : 751426
             * title : 大人气手游《ICHU偶像进行曲》7月8日双端上线！恋爱偶像为你甜蜜开唱~
             * coverImage : http://qn.18touch.com//uploads/acg201606/1467282291937094.jpg
             * category : 国内手游
             */

            private List<ListBean> list;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private int id;
                private String title;
                private String coverImage;
                private String category;

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
            }
        }
    }
}
