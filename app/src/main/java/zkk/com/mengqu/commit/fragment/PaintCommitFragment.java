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
import zkk.com.mengqu.commit.adapter.PaintAdapter;
import zkk.com.mengqu.commit.bean.PaintBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.simplepreferences.SharePreferences;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.refresh.LoadMoreListView;

/**
 * Created by Administrator on 2016/7/1 0001.
 * 资讯
 */
public class PaintCommitFragment extends Fragment{

    private  View view;
    private LoadMoreListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    List<PaintBean.DataBean> paintBeens=new ArrayList<PaintBean.DataBean>();
    private PaintAdapter paintAdapter;
    private Context context;
    private boolean isLoad = false;
    private boolean hasMore = true;
    private  String lastId; //最后一个ID
    private  String lastTime;//最后一个的时间
    Observer<PaintBean> observer=new Observer<PaintBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshLayout.setRefreshing(false);
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(PaintBean result) {

            swipeRefreshLayout.setRefreshing(false);
            String strJson = "";
            Gson gson = new Gson();
            strJson = gson.toJson(result);
            if(strJson!=null&&!"".equals(strJson)
                    &&strJson.equals(SharePreferences.getInstance(context).getPaint())){
                SharePreferences.getInstance(context).setPaint(strJson);
                return ;
            }
            lastId=result.getData().get(result.getData().size()-1).getOid()+"";
            lastTime=result.getData().get(result.getData().size()-1).getCreateTime()+"";
            SharePreferences.getInstance(context).setPaint(strJson);

            paintBeens.clear();
            paintBeens.addAll(result.getData());
            paintAdapter.notifyDataSetChanged();
        }
    };


    Observer<PaintBean> observer2=new Observer<PaintBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshLayout.setRefreshing(false);
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(PaintBean result) {


            swipeRefreshLayout.setRefreshing(false);
            lastId=result.getData().get(result.getData().size()-1).getOid()+"";
            lastTime=result.getData().get(result.getData().size()-1).getCreateTime()+"";
            paintBeens.addAll(result.getData());
            paintAdapter.notifyDataSetChanged();
        }
    };


    public static PaintCommitFragment newInstance(){

        PaintCommitFragment gameInfoFragment=new PaintCommitFragment();
        return gameInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_gameinfo,container,false);
        context=getActivity();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void getAppIndexData(int dataType,int pageNo3){

        paintBeens.clear();
        if(!Utils.isNull(SharePreferences.getInstance(context).getPaint())){
            Gson gson = new Gson();
            PaintBean result = gson.fromJson(SharePreferences.getInstance(context).getPaint(),PaintBean.class );

            lastId=result.getData().get(result.getData().size()-1).getOid()+"";
            lastTime=result.getData().get(result.getData().size()-1).getCreateTime()+"";
            paintBeens.addAll(result.getData());
            paintAdapter.notifyDataSetChanged();
        }

        //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getInstance().getoriginalList("","0","5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41","2.1.0","a","Xiaomi")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    private void getAppIndexMore(String dataType,String pageNo3){
        isLoad =false;
        //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getInstance().getoriginalList(dataType,pageNo3,"5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41","2.1.0","a","Xiaomi")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer2);
    }



    private  void  init(){
        listView=(LoadMoreListView)view.findViewById(R.id.lv_gameinfo);
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.sf_gameinfo_swipe_refresh);
        paintAdapter=new PaintAdapter(paintBeens,context);
        listView.setAdapter(paintAdapter);

        swipeRefreshLayout.setColorSchemeColors(Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setEnabled(true);


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
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAppIndexData(0,0);
            }
        });

        getAppIndexData(0,0);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
}
