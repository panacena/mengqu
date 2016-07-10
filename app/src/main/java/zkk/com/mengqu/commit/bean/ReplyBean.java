package zkk.com.mengqu.commit.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class ReplyBean {

    /**
     * code : 1
     * data : [{"cid":"577a2f02f4a5ab7e3a8b45f2","content":"😳😳","floor":13,"status":1,"createTime":1467625218,"uid":39107,"nickname":"新新格子","avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM6YRqHgOiaAvmYkhdg8Wia0MKIhao4AUMmX7eFiavNO1wDRWLYZ52kZUBxan4DCbBcyggYNdvNCrOAxm2gjqJ5zSb1hahQw8VUf7I/0","role":"reader","reply":null,"image":""},{"cid":"5779a249f4a5abf2108b49b3","content":"秘制凸起","floor":12,"status":1,"createTime":1467589193,"uid":18190,"nickname":"1052872352@qq.com","avatar":"","role":"reader","reply":null,"image":""},{"cid":"5777de9cf4a5abc3688b4952","content":"1","floor":11,"status":1,"createTime":1467473564,"uid":39107,"nickname":"新新格子","avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM6YRqHgOiaAvmYkhdg8Wia0MKIhao4AUMmX7eFiavNO1wDRWLYZ52kZUBxan4DCbBcyggYNdvNCrOAxm2gjqJ5zSb1hahQw8VUf7I/0","role":"reader","reply":{"uid":39107,"nickname":"新新格子","content":"1","role":"reader","image":""},"image":""},{"cid":"5777de91f4a5ab24728b4568","content":"1","floor":10,"status":1,"createTime":1467473553,"uid":39107,"nickname":"新新格子","avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM6YRqHgOiaAvmYkhdg8Wia0MKIhao4AUMmX7eFiavNO1wDRWLYZ52kZUBxan4DCbBcyggYNdvNCrOAxm2gjqJ5zSb1hahQw8VUf7I/0","role":"reader","reply":{"uid":28995,"nickname":"zxh@qq.com","content":"今生今世计算机","role":"reader","image":""},"image":""},{"cid":"5777de84f4a5abfa688b48f2","content":"哈哈","floor":9,"status":1,"createTime":1467473540,"uid":39107,"nickname":"新新格子","avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM6YRqHgOiaAvmYkhdg8Wia0MKIhao4AUMmX7eFiavNO1wDRWLYZ52kZUBxan4DCbBcyggYNdvNCrOAxm2gjqJ5zSb1hahQw8VUf7I/0","role":"reader","reply":null,"image":""},{"cid":"577630b4f4a5ab14628b461d","content":"你买屁股先锋了啊","floor":8,"status":1,"createTime":1467363508,"uid":39667,"nickname":"水可载舟亦可赛艇","avatar":"http://wx.qlogo.cn/mmopen/DY7Jl8icwibJJGt3KdYhicUkRlfd6ZfNBROnHlnAMfdEsxq1JyKXc7JJria4vwKpjsIgg8xIwYFrvlgXmOK1phNnpVs0k2Joxz9w/0","role":"reader","reply":null,"image":""},{"cid":"5769f617f4a5ab4c158b465e","content":"good","floor":7,"status":1,"createTime":1466562071,"uid":26449,"nickname":"cairurui@18touch.com","avatar":"http://18touch.qiniudn.com/uploads/acgavatar/20160426/20160426571ed8a468b99.jpg?imageView2/1/w/240/h/240/q/95","role":"reader","reply":null,"image":""},{"cid":"575c4592f4a5ab780d8b4fda","content":"比起机甲，我居然很喜欢她的手枪，迷一样的好用","floor":6,"status":1,"createTime":1465664914,"uid":17228,"nickname":"s964920209@163.com","avatar":"http://18touch.qiniudn.com/uploads/acgavatar/20160615/2016061557617199ae2ca.jpg?imageView2/1/w/240/h/240/q/95","role":"reader","reply":null,"image":""},{"cid":"5756e38af4a5ab2c788b48a7","content":"我女神！！！！","floor":5,"status":1,"createTime":1465312138,"uid":1137,"nickname":"hunan@163","avatar":"http://18touch.qiniudn.com/uploads/acgavatar/20160315/2016031556e7b248a3d9b.jpg?imageView2/1/w/240/h/240/q/95","role":"reader","reply":null,"image":""},{"cid":"5756522ff4a5abc20b8b4567","content":"一设置为桌面","floor":4,"status":1,"createTime":1465274927,"uid":37071,"nickname":"Diego","avatar":"","role":"reader","reply":null,"image":""}]
     */

    private int code;
    /**
     * cid : 577a2f02f4a5ab7e3a8b45f2
     * content : 😳😳
     * floor : 13
     * status : 1
     * createTime : 1467625218
     * uid : 39107
     * nickname : 新新格子
     * avatar : http://wx.qlogo.cn/mmopen/Q3auHgzwzM6YRqHgOiaAvmYkhdg8Wia0MKIhao4AUMmX7eFiavNO1wDRWLYZ52kZUBxan4DCbBcyggYNdvNCrOAxm2gjqJ5zSb1hahQw8VUf7I/0
     * role : reader
     * reply : null
     * image :
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
        private String cid;
        private String content;
        private int floor;
        private int status;
        private int createTime;
        private int uid;
        private String nickname;
        private String avatar;
        private String role;
        private Object reply;
        private String image;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Object getReply() {
            return reply;
        }

        public void setReply(Object reply) {
            this.reply = reply;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
