package zkk.com.mengqu.retrofit2.interfaces;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zkk.com.mengqu.commit.bean.PaintBean;
import zkk.com.mengqu.commit.bean.PaintHeadBean;
import zkk.com.mengqu.commit.bean.ReplyBean;
import zkk.com.mengqu.commit.bean.ShareBean;
import zkk.com.mengqu.game.bean.GoodThemeBean;
import zkk.com.mengqu.home.bean.HomeThemeBean;
import zkk.com.mengqu.home.bean.HomeitemBean;
import zkk.com.mengqu.imagslists.bean.ImagsListBean;
import zkk.com.mengqu.theme.bean.ThemeItemBena;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public interface ApimoejuInterface {


    //http://api.moeju.cn/picture/special?lastId=0&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=1.7&os=a&channel=

    /**
     * 获取首页推荐的图片
     *
     * @param lastId
     * @param lastTime
     * @param dk
     * @param ak
     * @param v
     * @param channel
     * @return
     */
    @GET("picture/special")
    Observable<HomeitemBean> getHomespecial(@Query("lastId") String lastId, @Query("lastTime") String lastTime, @Query("dk") String dk, @Query("ak") String ak
            , @Query("v") String v, @Query("os") String os, @Query("channel") String channel);

    //http://api.moeju.cn/picture/theme?&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41
    @GET(" picture/theme")
    Observable<HomeThemeBean> getHometheme(@Query("dk") String dk, @Query("ak") String ak);


    //http://api.moeju.cn/picture/imageList?id=13107
    @GET("picture/imageList")
    Observable<ImagsListBean> getimageList(@Query("id") String id);


    //http://api.moeju.cn/Picture/themePicture?themeId=19&lastId=0&lastTime=0
    @GET("picture/themePicture")
    Observable<ThemeItemBena> getthemePicture(@Query("themeId") String themeId, @Query("lastId") String lastId, @Query("lastTime") String lastTime);

    //http://api.moeju.cn/news/more?lastId=0&lastTime=0&cat=%E6%B8%B8%E6%88%8F%E8%B5%84%E8%AE%AF
    @GET("news/more")
    Observable<GoodThemeBean> getmoreGameInfo(@Query("lastId") String lastId, @Query("lastTime") String lastTime,
                                              @Query("cat") String cat);


    //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
    //社区--画作
    @GET("painting/originalList")
    Observable<PaintBean> getoriginalList(@Query("lastId") String lastId, @Query("lastTime") String lastTime,
                                          @Query("dk") String dk, @Query("ak") String ak, @Query("v") String v, @Query("os") String os, @Query("channel") String channel);

    //http://api.moeju.cn/Daily/all?type=5&lastId=&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
    //分享
    @GET("Daily/all")
    Observable<ShareBean> getShare(@Query("type") String type,@Query("lastId") String lastId,
                                   @Query("dk") String dk, @Query("ak") String ak);

    //http://api.moeju.cn/Daily/leaderboard?leaderboard=1&lastId=&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
    //排行榜
    @GET("Daily/leaderboard")
    Observable<ShareBean> getleaderboard(@Query("leaderboard") String leaderboard, @Query("lastId") String lastId,
                                         @Query("dk") String dk, @Query("ak") String ak);


    //http://api.moeju.cn/Daily/detail?id=577a547cf4a5ab9d458b4568
    //http://api.moeju.cn/comment?type=3&id=577a547cf4a5ab9d458b4568&lastId=&lastTime=0

    //上方的图片以及like的人
    //http://api.moeju.cn/painting/originalDetail?id=5749e8fcf4a5ab21418b51c0
    @GET("painting/originalDetail")
    Observable<PaintHeadBean> getleaderboard(@Query("id") String id);

    //下方评论
    //http://api.moeju.cn/comment?type=1&id=5749e8fcf4a5ab21418b51c0&lastId=&lastTime=0
    @GET("comment")
    Observable<ReplyBean> getcomment(@Query("type") String leaderboard, @Query("id") String id,@Query("lastTime") String lastTime);

    //http://api.moeju.cn/Daily/detail?id=577a547cf4a5ab9d458b4568
    //http://api.moeju.cn/comment?type=3&id=577a547cf4a5ab9d458b4568&lastId=&lastTime=0

    //上方的图片以及like的人  分享
    //http://api.moeju.cn/Daily/detail?id=577a547cf4a5ab9d458b4568
    @GET("Daily/detail")
    Observable<PaintHeadBean> getSharedetail(@Query("id") String id);
}
