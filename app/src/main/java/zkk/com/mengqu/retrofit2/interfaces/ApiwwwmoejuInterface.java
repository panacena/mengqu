package zkk.com.mengqu.retrofit2.interfaces;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zkk.com.mengqu.game.bean.GameInfoBean;
import zkk.com.mengqu.game.bean.InfoHtmlBean;
import zkk.com.mengqu.home.bean.HomeitemBean;
import zkk.com.mengqu.news.bean.NewsBean;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public interface ApiwwwmoejuInterface {


    //http://www.moeju.cn/api/leaderboard?dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
    @GET("api/leaderboard")
    Observable<HomeitemBean> getHomeleaderboard(@Query("dk") String dk, @Query("ak") String ak, @Query("v") String v, @Query("os") String os
            , @Query("channel") String channel);

    //http://www.moeju.cn/api//gamenews?lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
    // 游戏--- 最新资讯
    @GET("api/gamenews")
    Observable<GameInfoBean> getgamenews(@Query("lastTime") String lastTime,@Query("dk") String dk,@Query("ak") String ak,@Query("v") String v);

    //http://www.moeju.cn/api//newsdetail?id=751426&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
    //点击某一项后 打开的网页
    @GET("api/newsdetail")
    Observable<InfoHtmlBean> getnewsdetail(@Query("id") String id, @Query("dk") String dk, @Query("ak") String ak);


    //http://www.moeju.cn/api//news?lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
    //资讯
    @GET("api/news")
    Observable<NewsBean> getnews(@Query("lastTime") String lastTime, @Query("dk") String dk, @Query("ak") String ak);


}
