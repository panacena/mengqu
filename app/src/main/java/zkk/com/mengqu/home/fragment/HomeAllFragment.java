package zkk.com.mengqu.home.fragment;

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
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.home.adapter.HomeAllAdapter;
import zkk.com.mengqu.home.bean.HomeitemBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.simplepreferences.SharePreferences;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.refresh.LoadMoreListView;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class HomeAllFragment  extends Fragment {

    private LoadMoreListView listView;
    private HomeAllAdapter gameLiveAdapter;
    private Context context;
    private  int pageNo3item=1;
    private SwipeRefreshLayout shelf_swipe_refresh;
    private boolean isLoad = false;
    private boolean hasMore = true;
    private  String lastId; //最后一个ID
    private  String lastTime;//最后一个的时间
    List<HomeitemBean.DataBean> liveBeens=new ArrayList<HomeitemBean.DataBean>();

    Observer<HomeitemBean> observer=new Observer<HomeitemBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            shelf_swipe_refresh.setRefreshing(false);
            Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(HomeitemBean result) {
            shelf_swipe_refresh.setRefreshing(false);

            String strJson = "";
            Gson gson = new Gson();
            strJson = gson.toJson(result);

            if(strJson!=null&&!"".equals(strJson)
                    &&strJson.equals(SharePreferences.getInstance(context).getHomeAll())){
                SharePreferences.getInstance(context).setHomeAll(strJson);
                return ;
            }
            lastId=result.getData().get(result.getData().size()-1).getId()+"";
            lastTime=result.getData().get(result.getData().size()-1).getPostTime()+"";
            SharePreferences.getInstance(context).setHomeAll(strJson);

            liveBeens.clear();
            liveBeens.addAll(result.getData());
            gameLiveAdapter.notifyDataSetChanged();
        }
    };




    Observer<HomeitemBean> observer2=new Observer<HomeitemBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            shelf_swipe_refresh.setRefreshing(false);
            Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(HomeitemBean result) {
            shelf_swipe_refresh.setRefreshing(false);
            lastId=result.getData().get(result.getData().size()-1).getId()+"";
            lastTime=result.getData().get(result.getData().size()-1).getPostTime()+"";
            liveBeens.addAll(result.getData());
            gameLiveAdapter.notifyDataSetChanged();
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main,null);
      //  Treasure.setConverterFactory(new GsonConverterFactory());
        context=getActivity();
        listView=(LoadMoreListView) view.findViewById(R.id.expandableListView);
        shelf_swipe_refresh=(SwipeRefreshLayout)view.findViewById(R.id.shelf_swipe_refresh);
        shelf_swipe_refresh.setColorSchemeColors(Color.GREEN, Color.RED, Color.YELLOW);
        shelf_swipe_refresh.setEnabled(true);
        gameLiveAdapter=new HomeAllAdapter(liveBeens,context);
        listView.setAdapter(gameLiveAdapter);
        liveBeens.clear();


        listView.setOnLastItemVisibleListener(new LoadMoreListView.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {

                if (isLoad || !hasMore) {
                    listView.setFooter(LoadMoreListView.Mode.NOMORE);
                    return;
                }
                isLoad = true;
                getAppIndexMore(lastId,lastTime);
                listView.setFooter(LoadMoreListView.Mode.LOAD);
            }
        });
        shelf_swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAppIndexData(0,pageNo3item);
            }
        });



        getAppIndexData(0,pageNo3item);
        return view;
    }


    private void getAppIndexMore(String dataType,String pageNo3){
        isLoad =false;
        MengquApi.getInstance().getHomespecial(dataType,pageNo3,"5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41","1.7","a","")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer2);
    }

    private void getAppIndexData(int dataType,int pageNo3){


        liveBeens.clear();
        if(!Utils.isNull(SharePreferences.getInstance(context).getHomeAll())){
                 Gson gson = new Gson();
                 HomeitemBean  result = gson.fromJson(SharePreferences.getInstance(context).getHomeAll(),HomeitemBean.class );
                 lastId=result.getData().get(result.getData().size()-1).getId()+"";
                 lastTime=result.getData().get(result.getData().size()-1).getPostTime()+"";
                 liveBeens.addAll(result.getData());
                 gameLiveAdapter.notifyDataSetChanged();
        }

        //lastId=0&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=1.7&os=a&channel=
        MengquApi.getInstance().getHomespecial("0","0","5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41","1.7","a","")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}