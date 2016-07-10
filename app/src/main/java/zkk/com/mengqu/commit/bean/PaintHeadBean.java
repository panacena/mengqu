package zkk.com.mengqu.commit.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class PaintHeadBean {

    /**
     * code : 1
     * data : {"oid":2407,"picture":"http://qn.18touch.com/moeju/6207/1464462334_w563_h800_s345298.jpg?imageMogr2/thumbnail/!100p","createTime":1464461564,"content":"跟波风跟波风，屁股先锋不能不援，涂鸦一只娜娜希望大家喜欢！","likedNum":160,"avatar":"http://wx.qlogo.cn/mmopen/DY7Jl8icwibJJGt3KdYhicUkeibGhle8nfnlrj8w7KSgn5foh5R9TQwrTyAMtoT8jpaY9PYmyHqCaPbIqTFuqiaNETPpOjBIGar53/132","nickname":"冰与黑之焱","uid":"6207","author":0,"likedUsers":[{"avatar":"http://wx.qlogo.cn/mmopen/VSia5JtPYWlJCcQ6hI8fEVj76BEOBib2lUGsrJCZicxKzWooePUnCqcreic9ibhL96MFSUudmyibIFvauTFDUIicZhcezXHjrU4z6K4/0","role":"reader","id":8938},{"avatar":"http://18touch.qiniudn.com/uploads/acgavatar/20160225/2016022556cf0843bc437.jpg?imageView2/1/w/240/h/240/q/95","role":"reader","id":24408},{"avatar":"http://wx.qlogo.cn/mmopen/VSia5JtPYWlLkFgUj9UDjabptqafFiaj7DibGIhsmlQLdbcRC8YsicUCmibvdNRgbQHqv3ynPapIESibnQ6jIJ5KW7L5zQEbpicIMIu/0","role":"reader","id":40103},{"avatar":"http://tp4.sinaimg.cn/2319091323/180/5695293013/1","role":"reader","id":8327},{"avatar":"","role":"reader","id":39594}]}
     */

    private int code;
    /**
     * oid : 2407
     * picture : http://qn.18touch.com/moeju/6207/1464462334_w563_h800_s345298.jpg?imageMogr2/thumbnail/!100p
     * createTime : 1464461564
     * content : 跟波风跟波风，屁股先锋不能不援，涂鸦一只娜娜希望大家喜欢！
     * likedNum : 160
     * avatar : http://wx.qlogo.cn/mmopen/DY7Jl8icwibJJGt3KdYhicUkeibGhle8nfnlrj8w7KSgn5foh5R9TQwrTyAMtoT8jpaY9PYmyHqCaPbIqTFuqiaNETPpOjBIGar53/132
     * nickname : 冰与黑之焱
     * uid : 6207
     * author : 0
     * likedUsers : [{"avatar":"http://wx.qlogo.cn/mmopen/VSia5JtPYWlJCcQ6hI8fEVj76BEOBib2lUGsrJCZicxKzWooePUnCqcreic9ibhL96MFSUudmyibIFvauTFDUIicZhcezXHjrU4z6K4/0","role":"reader","id":8938},{"avatar":"http://18touch.qiniudn.com/uploads/acgavatar/20160225/2016022556cf0843bc437.jpg?imageView2/1/w/240/h/240/q/95","role":"reader","id":24408},{"avatar":"http://wx.qlogo.cn/mmopen/VSia5JtPYWlLkFgUj9UDjabptqafFiaj7DibGIhsmlQLdbcRC8YsicUCmibvdNRgbQHqv3ynPapIESibnQ6jIJ5KW7L5zQEbpicIMIu/0","role":"reader","id":40103},{"avatar":"http://tp4.sinaimg.cn/2319091323/180/5695293013/1","role":"reader","id":8327},{"avatar":"","role":"reader","id":39594}]
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String oid;
        private String picture;
        private int createTime;
        private String content;
        private int likedNum;
        private String avatar;
        private String nickname;
        private String uid;
        private int author;
        /**
         * avatar : http://wx.qlogo.cn/mmopen/VSia5JtPYWlJCcQ6hI8fEVj76BEOBib2lUGsrJCZicxKzWooePUnCqcreic9ibhL96MFSUudmyibIFvauTFDUIicZhcezXHjrU4z6K4/0
         * role : reader
         * id : 8938
         */

        private List<LikedUsersBean> likedUsers;

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLikedNum() {
            return likedNum;
        }

        public void setLikedNum(int likedNum) {
            this.likedNum = likedNum;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getAuthor() {
            return author;
        }

        public void setAuthor(int author) {
            this.author = author;
        }

        public List<LikedUsersBean> getLikedUsers() {
            return likedUsers;
        }

        public void setLikedUsers(List<LikedUsersBean> likedUsers) {
            this.likedUsers = likedUsers;
        }

        public static class LikedUsersBean {
            private String avatar;
            private String role;
            private int id;

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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
