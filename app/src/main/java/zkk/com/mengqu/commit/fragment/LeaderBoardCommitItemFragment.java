package zkk.com.mengqu.commit.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.commit.adapter.LeaderboardAdapter;
import zkk.com.mengqu.commit.bean.ShareBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.simplepreferences.SharePreferences;
import zkk.com.mengqu.util.Utils;

/**
 * Created by Administrator on 2016/7/1 0001.
 * 资讯
 */
public class LeaderBoardCommitItemFragment extends Fragment{

    private  View view;
    private ListView listView;
    List<ShareBean.DataBean> shares=new ArrayList<ShareBean.DataBean>();
    private LeaderboardAdapter leaderboardAdapter;
    private Context context;
    public   int leaderboard; //1:日  2: 周  3:月
    private boolean isLoad = false;
    private boolean hasMore = true;
    private  String lastId; //最后一个ID
    private SwipeRefreshLayout sf_lv_share_item_swipe_refresh;
    Observer<ShareBean> observer=new Observer<ShareBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            sf_lv_share_item_swipe_refresh.setRefreshing(false);
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(ShareBean result) {
            sf_lv_share_item_swipe_refresh.setRefreshing(false);
            String strJson = "";
            Gson gson = new Gson();
            strJson = gson.toJson(result);
            if(leaderboard==1) {
                if(strJson!=null&&!"".equals(strJson)
                            &&strJson.equals(SharePreferences.getInstance(context).getLeaderBoardDay())){
                        SharePreferences.getInstance(context).setLeaderBoardDay(strJson);
                        return ;
                    }
                    SharePreferences.getInstance(context).setLeaderBoardDay(strJson);
            }else if(leaderboard==2){
                if(strJson!=null&&!"".equals(strJson)
                        &&strJson.equals(SharePreferences.getInstance(context).getLeaderBoardWeek())){
                    SharePreferences.getInstance(context).setLeaderBoardWeek(strJson);
                    return ;
                }
                SharePreferences.getInstance(context).setLeaderBoardWeek(strJson);
            }else if(leaderboard==3){
                if(strJson!=null&&!"".equals(strJson)
                        &&strJson.equals(SharePreferences.getInstance(context).getLeaderBoardMonth())){
                    SharePreferences.getInstance(context).setLeaderBoardMoth(strJson);
                    return ;
                }
                SharePreferences.getInstance(context).setLeaderBoardMoth(strJson);
            }
            Log.d("zkk---","result"+result.getData().size());
            shares.clear();
            shares.addAll(result.getData());
            leaderboardAdapter.notifyDataSetChanged();
        }
    };


    public static LeaderBoardCommitItemFragment newInstance(int leaderboards){

        LeaderBoardCommitItemFragment gameInfoFragment=new LeaderBoardCommitItemFragment();
        Bundle localBundle = new Bundle();
        localBundle.putInt("leaderboard", leaderboards);
        gameInfoFragment.setArguments(localBundle);
        return gameInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_commit_leader_item,container,false);
        Bundle bundle=getArguments();
        leaderboard=bundle.getInt("leaderboard",1);
        context=getActivity();
        Log.d("cal--","---leaderboard"+leaderboard);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void getAppIndexData(int dateType,int pageNo3){

        shares.clear();
        if(leaderboard==1){
            if(!Utils.isNull(SharePreferences.getInstance(context).getLeaderBoardDay())){
                Gson gson = new Gson();
                ShareBean list = gson.fromJson(SharePreferences.getInstance(context).getLeaderBoardDay(),ShareBean.class );
                shares.addAll(list.getData());
                leaderboardAdapter.notifyDataSetChanged();
            }
        }else if(leaderboard==2){
            if(!Utils.isNull(SharePreferences.getInstance(context).getLeaderBoardWeek())){
                Gson gson = new Gson();
                ShareBean list = gson.fromJson(SharePreferences.getInstance(context).getLeaderBoardWeek(),ShareBean.class );
                shares.addAll(list.getData());
                leaderboardAdapter.notifyDataSetChanged();
            }
        }else if(leaderboard==3){
            if(!Utils.isNull(SharePreferences.getInstance(context).getLeaderBoardMonth())){
                Gson gson = new Gson();
                ShareBean list = gson.fromJson(SharePreferences.getInstance(context).getLeaderBoardMonth(),ShareBean.class );
                shares.addAll(list.getData());
                leaderboardAdapter.notifyDataSetChanged();
            }
        }

        Log.d("cal--","---type"+dateType);
        //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getInstance().getleaderboard(dateType+"","","5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void onResume() {
      //  Toast.makeText(getActivity(), "onResume--"+shares.size(), Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    private  void  init(){
        listView=(ListView)view.findViewById(R.id.lv_leader_item);
        leaderboardAdapter=new LeaderboardAdapter(shares,context);
        listView.setAdapter(leaderboardAdapter);



        sf_lv_share_item_swipe_refresh=(SwipeRefreshLayout)view.findViewById(R.id.sf_lv_share_item_swipe_refresh);
        sf_lv_share_item_swipe_refresh.setColorSchemeColors(Color.GREEN, Color.RED, Color.YELLOW);
        sf_lv_share_item_swipe_refresh.setEnabled(true);

        sf_lv_share_item_swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAppIndexData(leaderboard,0);
            }
        });
        getAppIndexData(leaderboard,0);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
}
