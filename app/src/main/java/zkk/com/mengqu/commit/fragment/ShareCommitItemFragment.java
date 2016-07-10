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

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.commit.adapter.ShareAdapter;
import zkk.com.mengqu.commit.bean.ShareBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.simplepreferences.SharePreferences;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.refresh.LoadMoreListView;

/**
 * Created by Administrator on 2016/7/1 0001.
 * 资讯
 */
public class ShareCommitItemFragment extends Fragment{

    private  View view;
    private LoadMoreListView listView;
    List<ShareBean.DataBean> shares=new ArrayList<ShareBean.DataBean>();
    private ShareAdapter paintAdapter;
    private Context context;
    public   int type;//  type=4 日常 type=5 吐槽  type=6  番剧 type=3  cos
    public SwipeRefreshLayout sf_lv_share_item_swipe_refresh;

    private boolean isLoad = false;
    private boolean hasMore = true;
    private  String lastId; //最后一个ID
    private  String lastTime;//最后一个的时间

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

            if(type==4){
                if(strJson!=null&&!"".equals(strJson)
                        &&strJson.equals(SharePreferences.getInstance(context).getShareDaily())){
                    SharePreferences.getInstance(context).setShareDaily(strJson);
                    return ;
                }
                SharePreferences.getInstance(context).setShareDaily(strJson);
            }else if(type==5){
                if(strJson!=null&&!"".equals(strJson)
                        &&strJson.equals(SharePreferences.getInstance(context).getShareTucao())){
                    SharePreferences.getInstance(context).setShareTucao(strJson);
                    return ;
                }
                SharePreferences.getInstance(context).setShareTucao(strJson);

            }else if(type==6){
                if(strJson!=null&&!"".equals(strJson)
                        &&strJson.equals(SharePreferences.getInstance(context).getShareFanju())){
                    SharePreferences.getInstance(context).setShareFanju(strJson);
                    return ;
                }
                SharePreferences.getInstance(context).setShareFanju(strJson);

            }else if(type==3){
                if(strJson!=null&&!"".equals(strJson)
                        &&strJson.equals(SharePreferences.getInstance(context).getShareCos())){
                    SharePreferences.getInstance(context).setShareCos(strJson);
                    return ;
                }
                SharePreferences.getInstance(context).setShareCos(strJson);

            }
            lastId=result.getData().get(result.getData().size()-1).getId()+"";
            lastTime=result.getData().get(result.getData().size()-1).getCreateTime()+"";
            shares.addAll(result.getData());
            paintAdapter.notifyDataSetChanged();
        }
    };


    Observer<ShareBean> observer2=new Observer<ShareBean>() {
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
            lastId=result.getData().get(result.getData().size()-1).getId()+"";
            lastTime=result.getData().get(result.getData().size()-1).getCreateTime()+"";

            shares.addAll(result.getData());
            paintAdapter.notifyDataSetChanged();
        }
    };



    public static ShareCommitItemFragment newInstance(int types){

        ShareCommitItemFragment gameInfoFragment=new ShareCommitItemFragment();
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", types);
        gameInfoFragment.setArguments(localBundle);
        return gameInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_commit_share_item,container,false);
        Bundle bundle=getArguments();
        type=bundle.getInt("type",4);
        context=getActivity();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void getAppIndexMore(String dateType,String pageNo3){
        isLoad =false;
        Log.d("zkk","---type"+dateType);
        //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getInstance().getShare(dateType,pageNo3,"5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer2);
    }


    private void getAppIndexData(int dateType,int pageNo3){

        shares.clear();
        ShareBean list=null;
        if(type==4){
            if(!Utils.isNull(SharePreferences.getInstance(context).getShareDaily())){
                 Gson gson = new Gson();
                 list = gson.fromJson(SharePreferences.getInstance(context).getShareDaily(),ShareBean.class );
                 shares.addAll(list.getData());
                 paintAdapter.notifyDataSetChanged();
            }
        }else if(type==5){
            if(!Utils.isNull(SharePreferences.getInstance(context).getShareTucao())){
                Gson gson = new Gson();
                 list = gson.fromJson(SharePreferences.getInstance(context).getShareTucao(),ShareBean.class );
                shares.addAll(list.getData());
                paintAdapter.notifyDataSetChanged();
            }
        }else if(type==6){
            if(!Utils.isNull(SharePreferences.getInstance(context).getShareFanju())){
                Gson gson = new Gson();
                 list = gson.fromJson(SharePreferences.getInstance(context).getShareFanju(),ShareBean.class );
                shares.addAll(list.getData());
                paintAdapter.notifyDataSetChanged();
            }
        }else if(type==3){
            if(!Utils.isNull(SharePreferences.getInstance(context).getShareCos())){
                Gson gson = new Gson();
                 list = gson.fromJson(SharePreferences.getInstance(context).getShareCos(),ShareBean.class );
                shares.addAll(list.getData());
                paintAdapter.notifyDataSetChanged();
            }
        }

        if(list!=null&&list.getData()!=null&&list.getData().size()>0){
            lastId=list.getData().get(list.getData().size()-1).getId()+"";
            lastTime=list.getData().get(list.getData().size()-1).getCreateTime()+"";
        }




        Log.d("zkk","---type"+dateType);
        //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getInstance().getShare(dateType+"","","5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    private  void  init(){
        listView=(LoadMoreListView)view.findViewById(R.id.lv_share_item);
        paintAdapter=new ShareAdapter(shares,context);
        listView.setAdapter(paintAdapter);

        sf_lv_share_item_swipe_refresh=(SwipeRefreshLayout)view.findViewById(R.id.sf_lv_share_item_swipe_refresh);
        sf_lv_share_item_swipe_refresh.setColorSchemeColors(Color.GREEN, Color.RED, Color.YELLOW);
        sf_lv_share_item_swipe_refresh.setEnabled(true);


        listView.setOnLastItemVisibleListener(new LoadMoreListView.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {

                if (isLoad || !hasMore) {
                    listView.setFooter(LoadMoreListView.Mode.NOMORE);
                    return;
                }
                isLoad = true;
                getAppIndexMore(type+"",lastId);
                listView.setFooter(LoadMoreListView.Mode.LOAD);
            }
        });
        sf_lv_share_item_swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAppIndexData(type,0);
            }
        });




        getAppIndexData(type,0);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
}
