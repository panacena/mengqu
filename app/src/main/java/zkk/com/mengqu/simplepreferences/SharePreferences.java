package zkk.com.mengqu.simplepreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.bumptech.glide.Glide;

public class SharePreferences {
	private static final String SHARE_PREFERENCE_NAME = "MobileLive";
	public static SharePreferences sf = null;

	private Context ctx;
	private SharedPreferences sp = null;
	private Editor editor;

	private SharePreferences(Context ctx) {
		this.ctx = ctx;
		sp = ctx.getSharedPreferences(SHARE_PREFERENCE_NAME, ctx.MODE_PRIVATE);
		editor = sp.edit();
    }

	public static SharePreferences getInstance(Context ctx) {
		if (null == sf) {
			sf = new SharePreferences(ctx);
		}
		return sf;
	}


	/**
	 *  图集-全部
	 */
	public String getHomeAll(){
		return sp.getString("homeall", "");
	}
	public void  setHomeAll(String homeall){
		editor.putString("homeall", homeall);
		editor.commit();
	}

	/**
	 *  图集-主题
	 */
	public String getHomeTheme(){
		return sp.getString("HomeTheme", "");
	}
	public  void  setHomeTheme(String HomeTheme){
		editor.putString("HomeTheme", HomeTheme);
		editor.commit();
	}



	/**
	 *  图集-排行榜
	 */
	public String getHomeLeader(){
		return sp.getString("homeLeader", "");
	}
	public void  setHomeLeader(String homeLeader){
		editor.putString("homeLeader", homeLeader);
		editor.commit();

	}

	/**
	 *  游戏-最新资讯
	 */
	public String getGameInfo(){
		return sp.getString("gameInfo", "");
	}
	public void  setGameInfo(String gameInfo){
		editor.putString("gameInfo", gameInfo);
		editor.commit();

	}

	/**
	 *  游戏-精彩专题
	 */
	public String getGameTheme(){
		return sp.getString("gameTheme", "");
	}
	public void  setGameTheme(String gameTheme){
		editor.putString("gameTheme", gameTheme);
		editor.commit();
	}


	/**
	 *  社区-画作
	 */
	public String getPaint(){
		return sp.getString("paint", "");
	}
	public void  setPaint(String paint){
		editor.putString("paint", paint);
		editor.commit();
	}

	/**
	 *  社区-分享-日常
	 */
	public String getShareDaily(){
		return sp.getString("shareDaily", "");
	}
	public void  setShareDaily(String shareDaily){
		editor.putString("shareDaily", shareDaily);
		editor.commit();
	}

	/**
	 *  社区-分享-吐槽
	 */
	public String getShareTucao(){
		return sp.getString("shareTucao", "");
	}
	public void  setShareTucao(String  shareTucao){
		editor.putString("shareTucao", shareTucao);
		editor.commit();
	}


	/**
	 *  社区-分享-番剧
	 */
	public String getShareFanju(){
		return sp.getString("shareFanju", "");
	}
	public void  setShareFanju(String  shareFanju){
		editor.putString("shareFanju", shareFanju);
		editor.commit();
	}


	/**
	 *  社区-分享-cos
	 */
	public String getShareCos(){
		return sp.getString("cos", "");
	}
	public void  setShareCos(String cos){
		editor.putString("cos", cos);
		editor.commit();
	}


	/**
	 *  社区-排行榜-日排行
	 */
	public String getLeaderBoardDay(){
		return sp.getString("leaderBoardDay", "");
	}
	public void  setLeaderBoardDay(String leaderBoardDay){
		editor.putString("leaderBoardDay", leaderBoardDay);
		editor.commit();
	}


	/**
	 *  社区-排行榜-周排行
	 */
	public String getLeaderBoardWeek(){
		return sp.getString("leaderBoardWeek", "");
	}
	public void  setLeaderBoardWeek(String leaderBoardWeek){
		editor.putString("leaderBoardWeek", leaderBoardWeek);
		editor.commit();
	}


	/**
	 *  社区-排行榜-月排行
	 */
	public String getLeaderBoardMonth(){
		return sp.getString("LeaderBoardMoth", "");
	}
	public void  setLeaderBoardMoth(String LeaderBoardMoth){
		editor.putString("LeaderBoardMoth", LeaderBoardMoth);
		editor.commit();
	}


	/**
	 *  资讯
	 */
	public String getNews(){
		return sp.getString("news", "");

	}
	public void  setNews(String news){
		editor.putString("news", news);
		editor.commit();
	}

	public   void clear(final Context context){
		editor.clear();
		editor.commit();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Glide.get(context).clearDiskCache();
			}
		}).start();;
		Glide.get(context).clearMemory();
	}

}
