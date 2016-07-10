package zkk.com.mengqu.simplepreferences;

import com.baoyz.treasure.Preferences;

import zkk.com.mengqu.home.bean.HomeitemBean;

/**
 * Created by Administrator on 2016/7/8 0008.
 */
@Preferences
public interface SimplePreferences {



    /**
     *  图集-全部
     */
    HomeitemBean getHomeAll();
    void  setHomeAll(HomeitemBean homeall);


    /**
     *  图集-主题
     */
    String getHomeTheme();
    void  setHomeTheme(String homeTheme);



    /**
     *  图集-排行榜
     */
    String getHomeLeader();
    void  setHomeLeader(String homeLeader);

    /**
     *  游戏-最新资讯
     */
    String getGameInfo();
    void  setGameInfo(String gameInfo);

    /**
     *  游戏-精彩专题
     */
    String getGameTheme();
    void  setGameTheme(String gameTheme);


    /**
     *  社区-画作
     */
    String getPaint();
    void  setPaint(String paint);

    /**
     *  社区-分享-日常
     */
    String getShareDaily();
    void  setShareDaily(String shareDaily);

    /**
     *  社区-分享-吐槽
     */
    String getShareTucao();
    void  setShareTucao(String  shareTucao);


    /**
     *  社区-分享-番剧
     */
    String getShareFanju();
    void  setShareFanju(String  shareFanju);


    /**
     *  社区-分享-cos
     */
    String getShareCos();
    void  setShareCos(String cos);


    /**
     *  社区-排行榜-日排行
     */
    String getLeaderBoardDay();
    void  setLeaderBoardDay(String leaderBoardDay);


    /**
     *  社区-排行榜-周排行
     */
    String getLeaderBoardWeek();
    void  setLeaderBoardWeek(String leaderBoardWeek);


    /**
     *  社区-排行榜-月排行
     */
    String getLeaderBoardMonth();
    void  setLeaderBoardMoth(String leaderBoardWeek);


    /**
     *  资讯
     */
    String getNews();
    void  setNews(String news);

}
